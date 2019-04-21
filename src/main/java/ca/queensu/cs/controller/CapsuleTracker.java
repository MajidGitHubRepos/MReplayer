package ca.queensu.cs.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.microprofile.metrics.Timer;
import org.eclipse.uml2.uml.State;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.util.StringUtils;

import ca.queensu.cs.antler4AC.ACLexer;
import ca.queensu.cs.antler4AC.ACParser;
import ca.queensu.cs.antler4AC.EvalVisitor;
import ca.queensu.cs.antler4AC.SendMessage;
import ca.queensu.cs.antler4AC.Value;
import ca.queensu.cs.graph.ViewEngine;
import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.ServerVTOrdering;
import ca.queensu.cs.umlrtParser.CapsuleConn;
import ca.queensu.cs.umlrtParser.MyConnector;
import ca.queensu.cs.umlrtParser.PES;
import ca.queensu.cs.umlrtParser.ParserEngine;
import ca.queensu.cs.umlrtParser.StateData;
import ca.queensu.cs.umlrtParser.TableDataMember;
import ca.queensu.cs.umlrtParser.TransitionData;
import ca.queensu.cs.umlrtParser.UmlrtParser;
import ca.queensu.cs.umlrtParser.UmlrtUtils;


public class CapsuleTracker implements Runnable{

	private Semaphore semCapsuleTracker;
	//private String capsuleInstance;
	private BlockingQueue <Event> eventQueueTmp;
	private String currentStatus; //{StartUp, INIT, TRANSITIONEND}
	//public String currentStateName;
	//public String currentStateId;
	public String previousState;
	public String transitionName;
	public DataContainer dataContainer;
	private StateData sourceStateData;
	private StateData targetStateData;
	private boolean targetChoiceState;
	private boolean sourceChoiceState;
	private OutputStream outputFileStream;
	private double timeMilli;
	private String outputStrTofile;
	private long offset;
	private Timer timer;
	private int[] logicalVectorTime;
	private int TrackerMakerNumber;
	private Event stateExitEvent;
	private double stateExitTimer =0;
	private static String senderCapInstanceName;
	private String currentStateToChiceState;
	private String currentTransitionToFromChiceState;
	private List<String> listPaths;
	private String currentCapsuleRegion;
	private String prvTookPath;
	private boolean startUpDone;
	private boolean initDone;
	private Map<String,List<String>> mapPathTrigger;
	private Map<String,List<String>> mapPathActionCode;
	private Map<String, Value> maplocalHeap;
    private List<SendMessage> listPortMsg;
    private List<String> listAllPathTaken;
    private String lastTookPath;
    private String msgTobeConsumed;
    private String msgSender;


	public CapsuleTracker(Semaphore semCapsuleTracker, OutputStream outputFileStream, int[] logicalVectorTime, DataContainer dataContainer) {
		this.msgTobeConsumed = "";
		this.maplocalHeap = new HashMap<String, Value>();
		this.listPortMsg = new ArrayList<SendMessage>();
		this.mapPathTrigger =  new HashMap<String,List<String>>();
		this.mapPathActionCode =  new HashMap<String,List<String>>();
		this.listAllPathTaken =  new ArrayList<String>();
		this.listPaths =  new ArrayList<String>();
		this.currentStateToChiceState ="";
		this.currentTransitionToFromChiceState = "";
		this.dataContainer = dataContainer;
		this.senderCapInstanceName = "";
		this.stateExitEvent = null;
		this.TrackerMakerNumber = 0;
		this.semCapsuleTracker = semCapsuleTracker;
		//this.capsuleInstance = capsuleInstance;
		this.outputFileStream = outputFileStream;
		this.logicalVectorTime = logicalVectorTime;
		this.eventQueueTmp = new LinkedBlockingQueue<Event>(); // read but not consume!
		this.currentStatus = "StartUp";
		//this.currentStateName = "INIT";
		//this.currentStateId = "";
		this.targetStateData = new StateData();
		this.sourceStateData = new StateData();
		this.targetChoiceState = false;
		this.sourceChoiceState = false;
		this.timeMilli = 0;
		this.outputStrTofile = "";
		this.timer = new TimerImpl();
		this.currentCapsuleRegion = "INIT";
		this.prvTookPath = "";
		this.initDone = false;
		this.startUpDone = false;
		this.lastTookPath = "";
		this.msgSender = "";
	}


	public void run() {
		try {
			semCapsuleTracker.acquire();
			//Go to the initial state and wait for the right event
			System.out.println("============> Running : "+ dataContainer.getCapsuleName() );

			List<String> listAttributes = ParserEngine.mapCapAttributes.get(dataContainer.getCapsuleName());

			if (listAttributes != null) {
				for (String att : listAttributes) {
					//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> att: "+ att);
					String [] attSplit = att.split(":");
					if (attSplit[1].contentEquals("String"))
						maplocalHeap.put(attSplit[0], new Value("", "String"));
					else if (attSplit[1].contentEquals("Integer"))
						maplocalHeap.put(attSplit[0], new Value(Double.valueOf(0), "Integer"));
					else if (attSplit[1].contentEquals("Real"))
						maplocalHeap.put(attSplit[0], new Value(Double.valueOf(0), "Double"));
					else if (attSplit[1].contentEquals("Boolean"))
						maplocalHeap.put(attSplit[0], new Value(false, "Boolean"));
					else {
						System.err.println("__________ The Tyep of Attribute Not supported! __________");
						System.exit(1);
					}
				}
			}
			semCapsuleTracker.release();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while(true) {
			try {
				semCapsuleTracker.acquire();
				//System.out.println(dataContainer.getCapsuleInstance() + "============> eventQueueSize : "+ dataContainer.getEventQueue().size());

				if (!eventQueueTmp.isEmpty() || !dataContainer.getEventQueue().isEmpty()) {
					Event currentEventTmp = new Event();
					Event currentEvent = new Event();
					if (!eventQueueTmp.isEmpty()) {
						int eventQueueTmpSize = eventQueueTmp.size();
						for (int j = 0; j < eventQueueTmpSize;  j++) {
							currentEventTmp = eventQueueTmp.take();
							if(!isPassedEvent(currentEventTmp)) {
							//checking its validity based on the state machine
							if (isConsumable(currentEventTmp) || (listPaths.size()>1)) {
								//vTimeHandler(currentEventTmp);
								if (currentStatus.contentEquals("TRANISTIONEND")) {
									if ((listPaths.size() == 1) && isRequirementMet(listPaths.get(0))) {
										listAllPathTaken.add(listPaths.get(0));
							 			//System.err.println(dataContainer.getCapsuleInstance()+"++++++++++++++++++++++++++++++++>>>>>>>> before updateLocalHeap: ");
										updateLocalHeap(listPaths.get(0),msgSender);
										updateCurrentState();
										dataContainer.mapSendMessages.remove(msgTobeConsumed);
										msgTobeConsumed = "";
										msgSender = "";
										listPaths.clear();
										break;
									}
									//else
									//throw new IllegalAccessException("updateCurrentState Faild!");
								}
								break; //because of the reason if the first element can not be consume at the moment it could go through the rest of the queue 
							}else {eventQueueTmp.put(currentEventTmp);}
						}
						}
					}
					if(!dataContainer.getEventQueue().isEmpty()) {
						currentEvent =  dataContainer.eventQueue.take(); //push it back to the queue if it dose not consume !
						if(!isPassedEvent(currentEvent)) {

						if (isConsumable(currentEvent) || (listPaths.size()>1)) {
							if (currentStatus.contentEquals("TRANISTIONEND")) {
								if ((listPaths.size() == 1) && isRequirementMet(listPaths.get(0))) {
									listAllPathTaken.add(listPaths.get(0));
						 			//System.err.println(dataContainer.getCapsuleInstance()+"++++++++++++++++++++++++++++++++>>>>>>>> before updateLocalHeap: ");
									updateLocalHeap(listPaths.get(0),msgSender);
									updateCurrentState();
									dataContainer.mapSendMessages.remove(msgTobeConsumed);
									msgTobeConsumed = "";
									msgSender = "";
									listPaths.clear();
								}
								//else
								//throw new IllegalAccessException("updateCurrentState Faild!");
							}
							//vTimeHandler(currentEvent);
						}else {eventQueueTmp.put(currentEvent);}

					}
					if (currentEventTmp.getSourceName() != null) {
						showInfo(currentEventTmp);
						currentEventTmp = null;
					}if (currentEvent.getSourceName() !=null) {
						showInfo(currentEvent);
						currentEvent = null;}

				}

				}
				semCapsuleTracker.release();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	//==================================================================	
	//====================================================[isPassedEvent]
	//==================================================================	
	public boolean isPassedEvent(Event event) {
		String id = PES.mapQnameId.get(event.getSourceName());
		if(!prvTookPath.isEmpty() && prvTookPath.contains(",") && prvTookPath.contains(id)) {
			return true;
		}
		return false;
	}
	
	//==================================================================	
	//====================================================[vTimeHandler]
	//==================================================================
	public void vTimeHandler(Event event) {
		if (currentStatus.contains("TRANISTIONEND")) { // current event is stateExit => save event and do not put timestamp before transition done
			stateExitEvent = event;
			stateExitTimer = ((TimerImpl) timer).nowNano();
		}else if ((currentStatus.contains("STATEENTRYEND")) && (stateExitEvent != null)) { // current event is transition => put timestamp for stateExit and transition
			logicalVectorTime[TrackerMakerNumber]--;
			outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", stateExitTimer)+"]: "+*/stateExitEvent.allDataToString()+"\n\n";
			outputStreamToFile(this.outputFileStream,outputStrTofile);
			logicalVectorTime[TrackerMakerNumber]++;
			outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", ((TimerImpl) timer).nowNano())+"]: "+*/event.allDataToString()+"\n\n";
			outputStreamToFile(this.outputFileStream,outputStrTofile);
			stateExitEvent = null;
			stateExitTimer = 0;
		}else {
			outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", ((TimerImpl) timer).nowNano())+"]: "+*/event.allDataToString()+"\n\n";
			outputStreamToFile(this.outputFileStream,outputStrTofile);
		}
	}
	
	//==================================================================	
	//==============================================[callSendJsonToServer]
	//==================================================================
	public static boolean callSendJsonToServer(int priorityEventCounter, String capsuleInstance, String itemName, String allVariables) throws Exception {
		if (isPortInUse("localhost",8090)) { //8090 used to send command to the local draw.io server
			try {
	
				JSONObject jsonObj = makeJSONobj(priorityEventCounter,capsuleInstance, itemName, allVariables);
				ViewEngine.sendJsonToServer(jsonObj.toJSONString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TrackerMaker.priorityEventCounter++;
			return true;
		}
		return false;
	}

	//==================================================================	
	//==============================================[isConsumable]
	//==================================================================
	public boolean isConsumable(Event event) throws InterruptedException {
		try {
			String capsuleInstance = dataContainer.getCapsuleInstance();
		switch (currentStatus) {
			case "StartUp":          	if (registerChecking(event))       {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: StartUp received!");
				startUpDone = true;
				return true;};
				break;
			
			case "INIT":  	      		if (initChecking(event))           {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: Init received!");
				initDone = true;
				return true;};
				break;
				
			case "TRANISTIONEND":     	if (transitionChecking(event))     {
				return true;};
				break;
		}

		return false;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			return false;
			
		}
	}
	
	
	//==================================================================	
	//==============================================[showInfo]
	//==================================================================
	public void showInfo(Event event) {
		System.out.println("=====================[CapsuleInstance]: " + dataContainer.getCapsuleInstance() +", [eventQueueTmp.size()]: "+eventQueueTmp.size() + ", [dataContainer.eventQueue.size():]: "+ dataContainer.eventQueue.size());
		if (event !=null)
			System.out.println("=====================[event]: " + event.allDataToString());
		else
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[No Event Selected]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("=====================[listAllPathTaken]");
		int i = 0;
		
		for (String path : listAllPathTaken) {
			String pathCurr = "";
			if(path.contains(",")) {
				String [] pathsSplit = path.split("\\,");
				pathCurr = "";
				for (String str : pathsSplit) {
					if (pathCurr.isEmpty()) {
						pathCurr = PES.mapIdQname.get(str);
						//pathCurr = str;
					}else {	
						pathCurr = pathCurr+ "-->" + PES.mapIdQname.get(str);
						//pathCurr = pathCurr+ "-->" + str;
					}
				}
			}else {
				pathCurr = PES.mapIdQname.get(path);
				//pathCurr = listRegionalPaths.get(i);
			}
			System.out.println("["+i+++"]:" +pathCurr);
		}

		System.out.println("=====================[listPaths]");
		i = 0;
		for (String path : listPaths) {
			String pathCurr = "";
			if(path.contains(",")) {
				String [] pathsSplit = path.split("\\,");
				pathCurr = "";
				for (String str : pathsSplit) {
					if (pathCurr.isEmpty()) {
						pathCurr = PES.mapIdQname.get(str);
						//pathCurr = str;
					}else {	
						pathCurr = pathCurr+ "-->" + PES.mapIdQname.get(str);
						//pathCurr = pathCurr+ "-->" + str;
					}
				}
			}else {
				pathCurr = PES.mapIdQname.get(path);
				//pathCurr = listRegionalPaths.get(i);
			}
			System.out.println("["+i+++"]:" +pathCurr);
		}
		System.out.println("=====================[currentState]");
		for (Entry<String, String> entry : dataContainer.mapRegionCurrentState.entrySet()) {
			System.out.println("key: " + entry.getKey() + ", value: "+ ParserEngine.mapStateData.get(entry.getValue()).getStateName());
		}
		System.out.println("=====================[mapLocalHeap]");
		for (Entry<String, Value> entry : maplocalHeap.entrySet()) {
			System.out.println("key: " + entry.getKey() + ", value: "+ entry.getValue());
		}
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[DONE]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
	}
	
	//==================================================================	
	//==============================================[updateCurrentState]
	//==================================================================		
	public boolean updateCurrentState () {
		String [] pathSplit;
		String lastId = "";
		String region = "";
		
		if (listPaths.size()==1) {
			String path = listPaths.get(0);
			prvTookPath = path;

			if(path.contains(",")) {
				pathSplit = path.split("\\,");
				lastId = pathSplit[pathSplit.length -1];
				for(String tr : pathSplit) {
					region = ParserEngine.mapTransitionData.get(tr).getReginName();
					String [] trSplit = ParserEngine.mapTransitionData.get(tr).getPath().split("\\-");
					dataContainer.mapRegionCurrentState.put(region, trSplit[trSplit.length -1]);
				}
			}else {
				lastId = path;
				region = ParserEngine.mapTransitionData.get(lastId).getReginName();
				String [] trSplit = ParserEngine.mapTransitionData.get(lastId).getPath().split("\\-");
				dataContainer.mapRegionCurrentState.put(region, trSplit[trSplit.length -1]);	
				}
			
			return true;
		}else {
			showInfo(null);
			//System.err.println("__________ There are too much path in the listPaths __________ size: " + listPaths.size());
			//System.exit(1);
		}
		return false;
	}

	//==================================================================	
	//======================================================[checkPathConsistency]
	//==================================================================		
	public boolean checkPathConsistency (String region, String path) {
		String firstId = "";
		if (path.contains(",")) {
			String [] pathSplit = path.split("\\,");
			firstId = pathSplit[0];
		}else {
			firstId = path;}
		String [] stateIds = ParserEngine.mapTransitionData.get(firstId).getPath().split("\\-");		
		
		if (dataContainer.mapRegionCurrentState.get(region).contentEquals(stateIds[0]) || 
				((ParserEngine.mapStateData.get(stateIds[0]).getPseudoStateKind() != null) && (ParserEngine.mapStateData.get(stateIds[0]).getPseudoStateKind().toString().contentEquals("INITIAL"))))
			return true;
		else 
			return false;
	}

	//==================================================================	
	//======================================================[pathFinder]
	//==================================================================		
	public List<String> pathFinder (String qName) {

		String id = PES.mapQnameId.get(qName);
		String region = ParserEngine.mapTransitionData.get(id).getReginName();
		String capInstance = ParserEngine.mapTransitionData.get(id).getCapsuleInstanceName();
		
		
		if (listPaths.isEmpty()) {
			for (Map.Entry<String, List<String>> entry : PES.mapRegionPaths.entrySet()) {
				if (entry.getKey().contains(capInstance+"::"+region)) {
					for (String path : entry.getValue()) {
						if (path.contains(id) && checkPathConsistency(region, path)) {
							listPaths.add(path);
						}
					}
				}
			}
		}else {
			List <String> listPathsTmp =  new ArrayList<String>();
			listPathsTmp.clear();
			
			for (String path : listPaths) {
				if (path.contains(id)){
					listPathsTmp.add(path);
				}
			}
			
			listPaths.clear();
			listPaths.addAll(listPathsTmp);
			
			if (listPaths.size() == 2) {//add all path from history into listPath
				listPathsTmp.clear();
				for (String path : listPaths) {
					String lastId = "";
					if (path.contains(",")) {
						String [] pathSplit = path.split("\\,");
						lastId = pathSplit[pathSplit.length -1];
					}else {
						lastId = path;
					}
					region = ParserEngine.mapTransitionData.get(lastId).getReginName();
					capInstance = ParserEngine.mapTransitionData.get(lastId).getCapsuleInstanceName();
					
					String currentState = dataContainer.mapRegionCurrentState.get(region);
					if(ParserEngine.mapTransitionData.get(lastId).getIsInit()) {
						if((currentState != null) && !currentState.contains("INIT")) {
							listPathsTmp.addAll(addAllPathFrom(currentState));
						}else {
							listPathsTmp.add(path);
						}
					}
				}

				listPaths.clear();
				listPaths.addAll(listPathsTmp);
			}

		}
		return listPaths;
	}


	//==================================================================	
	//==============================================[setLogicalVectorTime]
	//==================================================================		
	public List<String> addAllPathFrom (String currentState) {
		
		List <String> listPathsTmp =  new ArrayList<String>();
		String innerRegionName = ParserEngine.mapStateData.get(currentState).getRegion();
		String capInstance = ParserEngine.mapStateData.get(currentState).getCapsuleInstanceName();
		List<String> innerRegionPaths = PES.mapRegionPaths.get(capInstance+"::"+innerRegionName);
		
		for (TransitionData tr :  ParserEngine.listTransitionData){
			if((tr.getReginName().contentEquals(innerRegionName)) && 
					(tr.getCapsuleInstanceName().contentEquals(capInstance))) {
				String [] pathSplit = tr.getPath().split("\\-");
				String trId = tr.getId();
				if (pathSplit[0].contentEquals(currentState)) {
					for (String innerRegionPath : innerRegionPaths) {
						String innerPathId = "";
						if (innerRegionPath.contains(",")) {
						
						String [] innerRegionPathSplit = innerRegionPath.split("\\,");
						innerPathId = innerRegionPathSplit[0];
						}else
							innerPathId = innerRegionPath;
						
						if (trId.contentEquals(innerPathId)) {
							listPathsTmp.add(innerRegionPath);
						}
					}
				}
			}
		}
		return listPathsTmp;
	}

	//==================================================================	
	//==============================================[setLogicalVectorTime]
	//==================================================================		
	public void setLogicalVectorTime (int [] logicalVT) {
		for (int i = 0; i<logicalVectorTime.length -1 ; i++)
		if (logicalVectorTime[i]< logicalVT[i]) {
			logicalVectorTime[i] = logicalVT[i];
		}
	}

	//==================================================================	
	//==============================================[lookingForTargetCapsuleName]
	//==================================================================
	public String lookingForTargetCapsuleName(String port,boolean sendToAll) {

		String targetCapsuleName = "";
		String sourceCapsuleName = "";
		String sourcePort = "";
		String targetPort = "";
		boolean portFound = false;
		boolean srcCapFound = false;
		boolean trgCapFound = false;
		String capsuleInstance = dataContainer.getCapsuleInstance();
				
		for (int i = 0; i< Controller.umlrtParser.getlistCapsuleConn().size(); i++) {
			//List<String> listCapsulePortName = Controller.umlrtParser.getlistCapsuleConn().get(i).getListPortName();
			List<MyConnector> listMyConnectorLocal = Controller.umlrtParser.getlistCapsuleConn().get(i).getListMyConnector();
			String capsuleName = Controller.umlrtParser.getlistCapsuleConn().get(i).getCapsuleInstanceName();
			for (int j = 0; j < listMyConnectorLocal.size() ; j++) {

				if ((listMyConnectorLocal.get(j).portCap1.contains(port)) || (listMyConnectorLocal.get(j).portCap2.contains(port))) {
					//let's find the other side of this connector, which port ? then which capsule?
					//String [] listCapsulePortConnSplit = listMyConnectorLocal.get(j).split("\\::");
					//connector

					String port1 = listMyConnectorLocal.get(j).portCap1;
					String connector = listMyConnectorLocal.get(j).connectorName;
					String port2 = listMyConnectorLocal.get(j).portCap2;
					String protocol = listMyConnectorLocal.get(j).protocolName;

					if (port1.contains(port)) {
						//conn found, let's check for relay
						if (!UmlrtUtils.isRelayPort(Controller.umlrtParser.getlistCapsuleConn(), port2)) {
							targetPort = port2;
							sourcePort = port1;
						}
						else {
							//we should look for the port that this port is connected to that
							sourcePort = port1;
							targetPort = UmlrtUtils.lookingForTargetPort(Controller.umlrtParser.getlistCapsuleConn(), port1, port2);
						}
					} else if (port2.contains(port)) {
						//conn found, let's check for relay
						if (!UmlrtUtils.isRelayPort(Controller.umlrtParser.getlistCapsuleConn(), port1)) {
							targetPort = port1;
							sourcePort = port2;
						}
						else {
							//we should look for the port that this port is connected to that
							sourcePort = port2;
							targetPort = UmlrtUtils.lookingForTargetPort(Controller.umlrtParser.getlistCapsuleConn(), port2, port1);
						}
						
					}else {
						System.err.println("=================[Target Port Not Found]================");
						//TODO: exception handling 
					}

					if (sourcePort != "") {
						
						for (int p = 0; p< Controller.umlrtParser.getlistCapsuleConn().size(); p++) {
							if (Controller.umlrtParser.getlistCapsuleConn().get(p).isListPortNameContainsPort(sourcePort)) {
								sourceCapsuleName = Controller.umlrtParser.getlistCapsuleConn().get(p).getCapsuleInstanceName();
								//System.out.println("["+ Thread.currentThread().getName() +"]*********[sourceCapsuleName]: " +sourceCapsuleName);
								
								//check sourceCapsuleName containing more than one capsule name, then we consider the capsule that are closer to the current capsule
								if (sourceCapsuleName.contains(",")) {
									sourceCapsuleName = sourceCapsuleName.replaceAll("\\s+","");
									String [] splitSourceCapsuleName = sourceCapsuleName.split("\\,");
									for (int q = 0; q<splitSourceCapsuleName.length; q++) {
										
										int lastIndexOf_ = splitSourceCapsuleName[q].lastIndexOf("__");
										String sourceCapsuleName__withoutInstanceName = splitSourceCapsuleName[q].substring(0, lastIndexOf_);
										if (capsuleInstance.contains(sourceCapsuleName__withoutInstanceName)) {
											//sourceCapsuleName found!
											sourceCapsuleName = splitSourceCapsuleName[q];
											srcCapFound = true;
											break;
										}
									}
									if (srcCapFound) break;
									if (sourceCapsuleName.contains(",")){ //sourceCapsuleName not found!
										System.err.println("=================[sourceCapsuleName Not Found]================");
									}
								}else {
									//TODO: Make sure the order in CapsuleConn does not affect this function 
									break;
								}
							}
						}
					}

					if (targetPort != "") {
						for (int p = 0; p< Controller.umlrtParser.getlistCapsuleConn().size(); p++) {

							if (Controller.umlrtParser.getlistCapsuleConn().get(p).isListPortNameContainsPort(targetPort)) {
								targetCapsuleName = Controller.umlrtParser.getlistCapsuleConn().get(p).getCapsuleInstanceName();
								//System.out.println("["+ Thread.currentThread().getName() +"]*********[targetCapsuleName]: " +targetCapsuleName);
								
								//check targetCapsuleName containing more than one capsule name, then we consider the capsule that are closer to the current capsule
								if (targetCapsuleName.contains(",")) {
									targetCapsuleName = targetCapsuleName.replaceAll("\\s+","");
									String [] splitTargetCapsuleName = targetCapsuleName.split("\\,");
									for (int q = 0; q<splitTargetCapsuleName.length; q++) {
										
										int lastIndexOf_ = splitTargetCapsuleName[q].lastIndexOf("__");
										String targetCapsuleName__withoutInstanceName = splitTargetCapsuleName[q].substring(0, lastIndexOf_);
										if (capsuleInstance.contains(targetCapsuleName__withoutInstanceName)) {
											//targetCapsulName found!
											targetCapsuleName = splitTargetCapsuleName[q];
											trgCapFound = true;
											break;
										}
									}
									//if (trgCapFound) break;
									if (targetCapsuleName.contains(",")&& sendToAll){
										return targetCapsuleName;
									}
									else if (targetCapsuleName.contains(",")){ //targetCapsulName not found!
										System.err.println("sourceCapsuleName: "+sourceCapsuleName+"\n=================[targetCapsulName Not Found]================\ntargetCapsuleName"+targetCapsuleName);
									}
								}
								
								if (!sourceCapsuleName.contains(targetCapsuleName)) // TODO: what about self-transitions
									return targetCapsuleName; 
							}
						}
					}
				}
			}
		}

		
		if (targetCapsuleName == "")
			System.err.println("==================[targetCapsuleName Not Found]======================");
			//System.err.println("sourceCapsuleName: "+sourceCapsuleName+"\n=================[targetCapsulName Not Found]================\ntargetCapsuleName"+targetCapsuleName);
		return targetCapsuleName;		
	}
	
	//==================================================================	
	//==============================================[toHistory]
	//==================================================================	
	public boolean toHistory(List<String> list) {
		
		for(String path : list) {
			if(path.contains(",")) {
				String [] regionPathSplit = path.split("\\,");
				if(ParserEngine.mapTransitionData.get(regionPathSplit[regionPathSplit.length-1]).getIsInit())
					return true;
			}
		}
		return false;
	}

	//==================================================================	
	//==============================================[registerChecking]
	//==================================================================
	public boolean registerChecking(Event event) {

		//Check transitionKind = 10 and eventType = 36 [For REGISTER] 
		if (event.getSourceKind().contentEquals("10") && event.getType().contentEquals("36")) {
			currentStatus = "INIT";
			return true;
		}
		return false;
	}

	//==================================================================	
	//==============================================[initChecking]
	//==================================================================	
	public boolean initChecking(Event event) throws InterruptedException {
		System.out.println(dataContainer.getCapsuleInstance() +", in initChecking "+ listPaths.size());

		boolean result = false;
		String id = PES.mapQnameId.get(event.getSourceName());
		
		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong

		if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14") && ParserEngine.mapTransitionData.get(id).getIsInit()) {
			//System.out.println(dataContainer.getCapsuleInstance() + "============> [Status : initChecking]:> "+ event.allDataToString());
			
			String [] pathSplit = ParserEngine.mapTransitionData.get(id).getPath().split("\\-");
			dataContainer.mapRegionCurrentState.put(ParserEngine.mapTransitionData.get(id).getReginName(),pathSplit[2]);
			
			pathFinder(event.getSourceName());
			if ((listPaths.size() == 1) && isRequirementMet(listPaths.get(0))) {
				result =  true;
				currentStatus = "TRANISTIONEND";
			}else if ((listPaths.size() > 1)){
				result = false;
			
			}else {
				System.err.println("__________ No Path Found! __________");
				System.exit(1);
			}
		}
		return result;
	}
	
	
	//==================================================================	
	//==============================================[sendMessages]
	//==================================================================	
	public void sendMessages() throws InterruptedException {
		
		for (SendMessage sendMessage : listPortMsg) {
			sendMessage.capsuleInstance = dataContainer.getCapsuleInstance();
			List<MyConnector> listMyConnectors = new ArrayList <MyConnector>();
			String trgCapsule = "";
			if (sendMessage.dest != null) {
				System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> DEST is not NULL!");
				for ( CapsuleConn capConn : ParserEngine.listCapsuleConn) {
					if (capConn.getCapsuleInstanceName().contentEquals(dataContainer.getCapsuleInstance())) {
						listMyConnectors = capConn.getListMyConnector();
						for (MyConnector connector : listMyConnectors) { 
							if (connector.portCap1.contentEquals(sendMessage.port) && (connector.port1Idx == sendMessage.dest.asInteger())) {
								trgCapsule = connector.capInstanceName2;
								break;
							}else if (connector.portCap2.contentEquals(sendMessage.port)&& (connector.port2Idx == sendMessage.dest.asInteger())) {
								trgCapsule = connector.capInstanceName1;
								break;
							}
						}
						break;
					}
				}
				
			}else {
				for ( CapsuleConn capConn : ParserEngine.listCapsuleConn) {
					if (capConn.getCapsuleInstanceName().contentEquals(dataContainer.getCapsuleInstance())) {

						listMyConnectors = capConn.getListMyConnector();
						for (MyConnector connector : listMyConnectors) { 

							if (connector.portCap1.contentEquals(sendMessage.port)) {
								trgCapsule = connector.capInstanceName2;
								break;
							}else if (connector.portCap2.contentEquals(sendMessage.port)) {
								trgCapsule = connector.capInstanceName1;
								break;
							}
						}
						break;
					}
				}
			}
			Iterator<Entry<String, CapsuleTracker>> itr = TrackerMaker.mapCapsuleTracker.entrySet().iterator();  
			while(itr.hasNext()) 
	        { 
				Entry<String, CapsuleTracker> entry = itr.next();
				if (entry.getKey().contains(trgCapsule)) {
					if ((sendMessage.data != null) && sendMessage.dataName.contentEquals("__getName__") && sendMessage.data.toString().contains("__CapInstanceName__")) { //TODO: find the corresponding varibale name in the target capsule; we have the same rule in the AC.g4
						sendMessage.data = new Value (dataContainer.getCapsuleInstance(),"String");
						entry.getValue().dataContainer.mapSendMessages.put(sendMessage.msg, sendMessage);
					}else
						entry.getValue().dataContainer.mapSendMessages.put(sendMessage.msg, sendMessage);
					break;
				}
	        }
			
			listMyConnectors = null;
		}
		
	}
	
	//==================================================================	
	//==============================================[interpretActionCode]
	//==================================================================	
	public void interpretActionCode(String actionCode, String msgSender) throws InterruptedException {
        System.out.println("[actionCode]: "+actionCode);        
		ACLexer lexer = new ACLexer(new ANTLRInputStream(actionCode));
		ACParser parser = new ACParser(new CommonTokenStream(lexer));
		EvalVisitor visitor = new EvalVisitor(maplocalHeap);
		visitor.visit(parser.parse());
		listPortMsg = visitor.getListPortMsg();
		
		//Thread.currentThread().sleep(2000); //TODO: replace with a thread syncronization method

		Iterator<Entry<String, Value>> itr = visitor.getHeapMem().entrySet().iterator(); 
        
        while(itr.hasNext()) 
        { 
             Map.Entry<String, Value> entry = itr.next();
             if (entry.getValue().toString().contentEquals("__CapInstanceName__")) {
            	 maplocalHeap.put(entry.getKey(), new Value (dataContainer.getCapsuleInstance(),"String"));
             }else if (entry.getValue().toString().contentEquals("msg->sapIndex0")) { // msg->sapIndex0 returns port index that the msg came in
            	 //who did this path trigger ? (which message from which port)
            	 for (MyConnector myConnector : ParserEngine.listMyConnectors) {
            		 if (msgSender.contains(myConnector.capInstanceName1) && dataContainer.getCapsuleInstance().contains(myConnector.capInstanceName2)) {
            			 maplocalHeap.put(entry.getKey(), new Value(myConnector.port2Idx,"Integer"));
            			 break;
            		 }else if (msgSender.contains(myConnector.capInstanceName2) && dataContainer.getCapsuleInstance().contains(myConnector.capInstanceName1)){
            			 maplocalHeap.put(entry.getKey(), new Value(myConnector.port1Idx,"Integer"));
            			 break;
            		 }
            		 
            	 }            	 
        	 }else {
            	 maplocalHeap.put(entry.getKey(), entry.getValue());
        	 }
        }
        
        sendMessages();
		
		lexer = null;
		parser = null;
		visitor = null;
		
	}
	/* WithRunnable
	 * public void interpretActionCode(String actionCode, String msgSender) throws InterruptedException {
        System.out.println("[actionCode]: "+actionCode);

		currentActionCode = actionCode;
		
		
		Thread runnableVisitorT = new Thread(new RunnableVisitor()); 		
		runnableVisitorT.start();


		Thread.currentThread().sleep(1000); //TODO: replace with a thread syncronization method
		listPortMsg = RunnableVisitor.visitor.getListPortMsg();
		Iterator<Entry<String, Value>> itr = RunnableVisitor.visitor.getHeapMem().entrySet().iterator(); 
        
        while(itr.hasNext()) 
        { 
             Map.Entry<String, Value> entry = itr.next();
             if (entry.getValue().toString().contentEquals("__CapInstanceName__")) {
            	 maplocalHeap.put(entry.getKey(), new Value (dataContainer.getCapsuleInstance(),"String"));
             }else if (entry.getValue().toString().contentEquals("msg->sapIndex0")) { // msg->sapIndex0 returns port index that the msg came in
            	 //who did this path trigger ? (which message from which port)
            	 for (MyConnector myConnector : ParserEngine.listMyConnectors) {
            		 if (msgSender.contains(myConnector.capInstanceName1) && dataContainer.getCapsuleInstance().contains(myConnector.capInstanceName2)) {
            			 maplocalHeap.put(entry.getKey(), new Value(myConnector.port2Idx,"Integer"));
            			 break;
            		 }else if (msgSender.contains(myConnector.capInstanceName2) && dataContainer.getCapsuleInstance().contains(myConnector.capInstanceName1)){
            			 maplocalHeap.put(entry.getKey(), new Value(myConnector.port1Idx,"Integer"));
            			 break;
            		 }
            		 
            	 }            	 
        	 }else {
            	 maplocalHeap.put(entry.getKey(), entry.getValue());
        	 }
        }
        
        sendMessages();
        runnableVisitorT.stop();
		
	}
	
	 */
	//==================================================================	
	//==============================================[updateLocalHeap]
	//==================================================================	
	public void updateLocalHeap(String path, String msgSender) throws InterruptedException {
		List<String> listTrigger = new ArrayList<String>();
		List<String> listActionCode = new ArrayList<String>();
		String firstTrInPath = "";
		if (path.contains(",")) {
			String [] pathSplit = path.split("\\,");
			firstTrInPath = pathSplit[0];
		}else
			firstTrInPath = path;
		
		listTrigger = mapPathTrigger.get(path);
		
		
		
		if (!listTrigger.isEmpty()) {
			
			for(String msg : listTrigger) {
				String [] msgSplit = msg.split("\\.");
				//if (!msgSplit[1].contains("_TIMER_")) { //we need to get msg __TIMER__ !
					SendMessage sendMessage = dataContainer.mapSendMessages.get(msgSplit[1]);
					if ((sendMessage != null) && (sendMessage.dataName != null) && (sendMessage.data != null)) 
						maplocalHeap.put(sendMessage.dataName, sendMessage.data);
				//}
			}
			
			
		}/*else if (!ParserEngine.mapTransitionData.get(firstTrInPath).getIsInit()){ //init Tr dose not need a trigger!
			System.err.println("__________ listTrigger is empty! __________"); //TODO: make it clean!
		}*/
		
		listActionCode = mapPathActionCode.get(path);
		
		for(String ac : listActionCode) {
			if (!ac.isEmpty())
				interpretActionCode(ac,msgSender);
		}
	}
	//==================================================================	
	//==============================================[makeListTrigger]
	//==================================================================	
		public List<String> makeListTrigger(String path) throws InterruptedException {
			List<String> listTrigger = new ArrayList<String>();
			List<String> listActionCode = new ArrayList<String>();
			
			if (path.contains(",")) {
				String [] pathSplit = path.split("\\,");
				for (String pathID : pathSplit) {
					listTrigger.addAll(ParserEngine.mapTransitionData.get(pathID).getTriggers());
					listActionCode.add(ParserEngine.mapTransitionData.get(pathID).getActionCode());
					
					String [] trPartsID = ParserEngine.mapTransitionData.get(pathID).getPath().split("\\-");
					if (ParserEngine.mapStateData.get(trPartsID[0]).getExitAC() != null)
						listActionCode.add(ParserEngine.mapStateData.get(trPartsID[0]).getExitAC());
					if (ParserEngine.mapStateData.get(trPartsID[2]).getEntrAC() != null)
						listActionCode.add(ParserEngine.mapStateData.get(trPartsID[2]).getEntrAC());
					
				}
			}else {
				listTrigger.addAll(ParserEngine.mapTransitionData.get(path).getTriggers());
				listActionCode.add(ParserEngine.mapTransitionData.get(path).getActionCode());
				
				
				String [] trPartsID = ParserEngine.mapTransitionData.get(path).getPath().split("\\-");
				if (ParserEngine.mapStateData.get(trPartsID[0]).getExitAC() != null)
					listActionCode.add(ParserEngine.mapStateData.get(trPartsID[0]).getExitAC());
				if (ParserEngine.mapStateData.get(trPartsID[2]).getEntrAC() != null)
					listActionCode.add(ParserEngine.mapStateData.get(trPartsID[2]).getEntrAC());
			}
			if (listTrigger != null) {
				mapPathTrigger.put(path, listTrigger);
				mapPathActionCode.put(path, listActionCode);
				
			}else {
				System.err.println("__________ No Trigger Found! __________"); //TODO: make it clean!
				System.exit(1);
			}
				
			return listTrigger;
		}
	
	//==================================================================	
	//==============================================[isRequirementMet]
	//==================================================================	
	public boolean isRequirementMet(String path) throws InterruptedException {

		boolean result = false;
		List<String> listTrigger = new ArrayList<String>();
		
		listTrigger = mapPathTrigger.get(path);
		
		if (listTrigger == null) {
			listTrigger = makeListTrigger(path);
		}
		
		if (listTrigger.isEmpty())
			result = true;
		else {
			result = true;
			for(String msg : listTrigger) {
				if(!msg.contains("__TIMER__")){
					//System.err.println(dataContainer.getCapsuleInstance()+"++++++++++++++[in isRequirementMet]+++++++++++++>>>found a msg that is not : __TIMER__");
					result = false;
				}
			}

			for(String msg : listTrigger) {
				String [] msgSplit = msg.split("\\.");
				if ((dataContainer.mapSendMessages.get(msgSplit[1]) != null)) {
					//System.err.println(dataContainer.getCapsuleInstance()+"++++++++++++++[in isRequirementMet]+++++++++++++>>>found: " + msgSplit[1]);

					msgSender = dataContainer.mapSendMessages.get(msgSplit[1]).capsuleInstance;
					result = true;
					msgTobeConsumed = msgSplit[1];
					//System.out.println("----------> In: "+ dataContainer.getCapsuleInstance() + ",msgTobeConsumed: "+ msgTobeConsumed);

				}
			}
		}



		if (!result) {
			for(String msg : listTrigger) {
				String [] msgSplit = msg.split("\\.");
				//System.err.println("In: "+ dataContainer.getCapsuleInstance() + ", expecting msg is "+ msgSplit[1]);
			}
			
			Iterator<Entry<String, SendMessage>> itr = dataContainer.mapSendMessages.entrySet().iterator();  
			while(itr.hasNext()) 
	        { 
				Entry<String, SendMessage> entry = itr.next();
				//System.err.println("In: "+ dataContainer.getCapsuleInstance() + ", we got "+ entry.getKey());
	        }
			//System.exit(1);
		}
			//System.err.println(dataContainer.getCapsuleInstance()+"++++++++++++++++++++++++++++++++++++++++++++++>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> isRequirementMet: " + result);

 		if (! result) {
 			//System.out.println(dataContainer.getCapsuleInstance()+"++++++++++++++++++++++++++++++++++++++++++++++>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> isRequirementMet: " + result);
 			//System.exit(1);
 		}
		return result;
			
	}
	
	//==================================================================	
	//==============================================[transitionChecking]
	//==================================================================	
	public boolean transitionChecking(Event event) throws InterruptedException {
		
		boolean result = false;
		String id = PES.mapQnameId.get(event.getSourceName());
		/*System.out.println(dataContainer.getCapsuleInstance()+", event.getSourceName(): " + event.getSourceName());
		System.out.println(dataContainer.getCapsuleInstance()+ ", id: " + id);
		System.out.println(dataContainer.getCapsuleInstance()+ ", ParserEngine.mapTransitionData.get(id): " + ParserEngine.mapTransitionData.get(id));
		System.out.println(dataContainer.getCapsuleInstance()+ ", ParserEngine.mapTransitionData.get(id).getReginName(): " + ParserEngine.mapTransitionData.get(id).getReginName());
		 */


		String currentSateId = dataContainer.mapRegionCurrentState.get(ParserEngine.mapTransitionData.get(id).getReginName());
		
		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong

		if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14")) {
			//showInfo();
			//System.out.println(event.getSourceName() +", "+ dataContainer.getCapsuleInstance() +", id: "+ id+ ", listPaths.size(): "+ listPaths.size() +" => [Status : transitionChecking]currentStatus:> "+ currentStatus +" ,StateId: "+currentSateId);
			pathFinder(event.getSourceName());
			if ((listPaths.size() == 1) && isRequirementMet(listPaths.get(0))) {
				result =  true;
				currentStatus = "TRANISTIONEND";
			}/*else if ((listPaths.size() == 1) && !isRequirementMet(listPaths.get(0))) {
				result =  false;
				//currentStatus = "TRANISTIONEND";
			}else if ((listPaths.size() > 1)){
				result = false;
			
			}else {
				System.err.println("__________ No Path Found! in ["+dataContainer.getCapsuleInstance()+"]__________"+listPaths.size());
				System.err.println("__________ Event:__________"+event.allDataToString());

				System.exit(1);
			}*/
			else
				result = false;
		}
		return result;
	}
	//==================================================================	
	//==============================================[outputStreamToFile]
	//==================================================================	
	private static void outputStreamToFile(OutputStream os, String data) {
		try {
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		}/*finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
	}

	//==================================================================	
	//==============================================[isPortInUse]
	//==================================================================
	public static boolean isPortInUse(String host, int port) {
		  // Assume no connection is possible.
		  boolean result = false;

		  try {
		    (new Socket(host, port)).close();
		    result = true;
		  }
		  catch(SocketException e) {
		    // Could not connect.
		  } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  return result;
		}
	//==================================================================	
	//==============================================[makeJSONobj]
	//==================================================================
	private static JSONObject makeJSONobj(int priorityEventCounter, String capInstName, String transitionName, String allVariables) {
			JSONObject jsonObj = new JSONObject();
			JSONArray traceID = new JSONArray();
			traceID.add(priorityEventCounter); traceID.add(capInstName); traceID.add(transitionName);
			jsonObj.put("traceID", traceID);
			JSONArray traceVar = new JSONArray();
			//processing variables
			if(allVariables!=null) {
				String[] variables = allVariables.split(System.getProperty("line.separator"));
				for (int i=0; i<variables.length;i++) {
					//System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]-->[variables]"+ variables[i] );
					String[] varData = variables[i].split("\\,"); //Sample: pongCount,Integer,7
					if (varData.length == 3) {
						traceVar.add(varData[0]); traceVar.add(varData[1]); traceVar.add(varData[2]);
					}
					else {
						//TODO: make sure it works with mulitple variables
						//System.err.println("__________ Error in the event's vaiables__________");
					}
				}
			}
			
			jsonObj.put("traceVar", traceVar);
			return jsonObj;
			
		}
	@SuppressWarnings("deprecation")
	public void shutdown() {
		Thread.currentThread().stop();
	}


}
