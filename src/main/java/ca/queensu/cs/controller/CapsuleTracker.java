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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import org.eclipse.microprofile.metrics.Timer;
import org.eclipse.uml2.uml.State;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.util.StringUtils;

import ca.queensu.cs.graph.ViewEngine;
import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.ServerVTOrdering;
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
	private Event currentEvent;
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


	public CapsuleTracker(Semaphore semCapsuleTracker, OutputStream outputFileStream, int[] logicalVectorTime, DataContainer dataContainer) {
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
	}


	public void run() {
		//Go to the initial state and wait for the right event
		System.out.println("============> Running : "+ dataContainer.getCapsuleInstance());


		while(true) {
			try {
				semCapsuleTracker.acquire();
				//System.out.println(dataContainer.getCapsuleInstance() + "============> eventQueueSize : "+ dataContainer.getEventQueue().size());

				if (!eventQueueTmp.isEmpty()) {
					int eventQueueTmpSize = eventQueueTmp.size();
					for (int j = 0; j < eventQueueTmpSize;  j++) {
						Event currentEventTmp = eventQueueTmp.take();
						if(!isPassedEvent(currentEventTmp)) {
							//checking its validity based on the state machine
							if (isConsumable(currentEventTmp) || (listPaths.size()>1)) {
								//vTimeHandler(currentEventTmp);
								if (currentStatus.contentEquals("TRANISTIONEND")) {
									if ((listPaths.size() == 1) && updateCurrentState())
										listPaths.clear();
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
								if ((listPaths.size() == 1) && updateCurrentState())
									listPaths.clear();
								//else
									//throw new IllegalAccessException("updateCurrentState Faild!");
							}
							//vTimeHandler(currentEvent);
						}else {eventQueueTmp.put(currentEvent);}
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
		if(startUpDone && (event.getSourceKind().contentEquals("10") && event.getType().contentEquals("36"))) {
			return true;
		}else if(startUpDone && initDone && ParserEngine.mapTransitionData.get(id).getIsInit()) {
				return true;
		}else if(!prvTookPath.isEmpty() && prvTookPath.contains(id)) {
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
	public void showInfo() {
		System.out.println("=====================[listPaths]=================");
		for (String path : listPaths) {
			System.out.println("Path: " + path);
		}
		System.out.println("=====================[currentState]=================");
		for (Entry<String, String> entry : dataContainer.mapRegionCurrentState.entrySet()) {
			System.out.println("key: " + entry.getKey() + ", value: "+ ParserEngine.mapStateData.get(entry.getValue()).getStateName());
		}
	}
	//==================================================================	
	//==============================================[updateCurrentState]
	//==================================================================		
	public boolean updateCurrentState () {
		String [] pathSplit;
		String lastId = "";
		String region = "";
		//List<String> listRegions = new ArrayList<String>();
		
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
			//if(currentStateId != null) {
			//	currentStateName = ParserEngine.mapStateData.get(currentStateId).getStateName();
			return true;
			//}
		}else {
			showInfo();
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
		
		//System.out.println(dataContainer.getCapsuleInstance() + "-> "+ currentStateId + "============> [stateIds[0]]:> "+ stateIds[0]);

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

		//System.out.println(dataContainer.getCapsuleInstance() + "============> [listPaths.size()]:> "+ listPaths.size());

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
					//break;
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
	//==============================================[sendToMessageQueue]
	//==================================================================
	public boolean sendToMessageQueue(String targetCapsuleName, String port, String msg) throws InterruptedException {

		boolean sentSuccessfully = false;
		int [] tmpLogicalVectorTime = this.logicalVectorTime;
		String capsuleInstance = dataContainer.getCapsuleInstance();

		Message sentMsg = new Message(port,msg, capsuleInstance,this.logicalVectorTime);
/*
		for (int i=0; i< TrackerMaker.trackerCount; i++) {
			if(targetCapsuleName.contains(TrackerMaker.capsuleTrackers[i].capsuleInstance)){
				//System.out.println(">>>>>>>>>>>>>>> TrackerMaker.capsuleTrackers[i].capsuleInstance: " +TrackerMaker.capsuleTrackers[i].capsuleInstance);

				for (int j = 0; j<= TrackerMaker.capsuleTrackers[i].logicalVectorTime.length; j++) {
					if (j == TrackerMakerNumber) {
						tmpLogicalVectorTime[j]=this.logicalVectorTime[j]; // because it gonna be incremented by 1 later but at this point it didn't
						break;
					}
				}
				sentMsg.setLogicalVectorTime(tmpLogicalVectorTime);
				TrackerMaker.capsuleTrackers[i].dataContainer.messageQueue.put(sentMsg);

				sentSuccessfully = true;
				return sentSuccessfully;
			}
		}
*/
		return sentSuccessfully;	
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
			//System.out.println(dataContainer.getCapsuleInstance() + "============> [Status : registerChecking]:> "+ event.allDataToString());
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
			if (listPaths.size() == 1) {
				result =  true;
				currentStatus = "TRANISTIONEND";
			}/*if ((listPaths.size() > 1) && toHistory(listPaths)) {
				System.out.println(dataContainer.getCapsuleInstance() +", before refineListPaths: "+ listPaths.size());

				refineListPaths(id);
				System.out.println(dataContainer.getCapsuleInstance() +", after refineListPaths: "+ listPaths.size());

				result =  true;
				currentStatus = "TRANISTIONEND";
			}*/else if ((listPaths.size() > 1)){
				result = false;
			
			}else {
				System.err.println("__________ No Path Found! __________");
				System.exit(1);
			}
		}
		return result;
	}
	//==================================================================	
	//==============================================[transitionChecking]
	//==================================================================	
	public boolean transitionChecking(Event event) throws InterruptedException {
		
		boolean result = false;
		String id = PES.mapQnameId.get(event.getSourceName());
		System.out.println("event.getSourceName(): " + event.allDataToString());
		String currentSateId = dataContainer.mapRegionCurrentState.get(ParserEngine.mapTransitionData.get(id).getReginName());
		
		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong

		if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14")) {
			showInfo();
			System.out.println(event.getSourceName() +", "+ dataContainer.getCapsuleInstance() +", id: "+ id+ ", listPaths.size(): "+ listPaths.size() +" => [Status : transitionChecking]currentStatus:> "+ currentStatus +" ,StateId: "+currentSateId);
			pathFinder(event.getSourceName());
			if (listPaths.size() == 1) {
				result =  true;
				currentStatus = "TRANISTIONEND";
			}/*else if ((listPaths.size() > 1) && toHistory(listPaths)) {
				System.out.println(dataContainer.getCapsuleInstance() +", before refineListPaths: "+ listPaths.size());

				refineListPaths(id);
				System.out.println(dataContainer.getCapsuleInstance() +", after refineListPaths: "+ listPaths.size());

				result =  true;
				currentStatus = "TRANISTIONEND";
			} else if (listPaths.size() > 1 && !toHistory(listPaths)){
				currentStatus = "CHOICE";
				result =  false;
			} */else if ((listPaths.size() > 1)){
				result = false;
			
			}else {
				System.err.println("__________ No Path Found! __________");
				System.exit(1);
			}
		}
		return result;
	/*	
		//System.out.println(dataContainer.getCapsuleInstance() + "============> [Status : transitionChecking]:> "+ event.allDataToString());

		//System.out.println("\n1["+ Thread.currentThread().getName() +"]*********[in transitionChecking] event: " + event.allDataToString());
		this.targetChoiceState = false;
		this.sourceChoiceState = false;
		boolean result = false;
		boolean requirementMet = false; //TODO: trigger by time!
		TransitionData targetTransitionData = new TransitionData();
		TableDataMember tableDataMember = new TableDataMember();

		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong

		if (currentStatus.contains("TRANISTIONEND")) {

			//Check eventSourceKind = 3 and eventType = 14 [For TRANISTIONEND]


			if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14")){
				String[] eventSourceNameSplit = event.getSourceName().split("\\::");
				String eventTransitionName = eventSourceNameSplit[4];

				//tableDataMember = rowInTableDataMemberLeadsToTargetState(eventSourceNameSplit[4], targetStateData.getStateName());
				tableDataMember = null;
				if (tableDataMember != null) {
					//Transition found in the tabalData
					targetTransitionData = tableDataMember.getTransition();
				}
				if (targetTransitionData.getCapsuleName() != null) { 
					if (tableDataMember.getTarget().getPseudoStateKind() == UmlrtUtils.PseudoStateKind.CHOICE ) {
						this.targetChoiceState = true;
					} else if (tableDataMember.getSource().getPseudoStateKind() == UmlrtUtils.PseudoStateKind.CHOICE) {
						this.sourceChoiceState = true;
					}

					List <String> listTriggers = targetTransitionData.getTriggers();

					//How many trigger does it have?
					int triggerSize = listTriggers.size();
					int triggerCount = 0;

					for (int j =0; j < listTriggers.size(); j++) {

						String trigger = listTriggers.get(j);
						String [] triggerSplit = trigger.split("\\.|\\(");
						//System.out.println("trigger: "+trigger);

						String triggerPort = triggerSplit[0];
						String triggerMsg = triggerSplit[1];

						if (triggerPort.contentEquals("__TIMER__") && triggerMsg.contentEquals("__TIME__")) {
							requirementMet = true;
							senderCapInstanceName = "";
							break;
						}else {
							for (int t = 0; t<dataContainer.messageQueue.size(); t++) {
								if (!dataContainer.messageQueue.isEmpty()) {
									Message tmpMessage = dataContainer.messageQueue.take();

									if (tmpMessage.getMsg().contains(triggerMsg)) { 
										senderCapInstanceName = tmpMessage.getCapsuleInstance(); 
										setLogicalVectorTime(tmpMessage.getLogicalVectorTime());
										requirementMet = true;
										break;}
									else {dataContainer.messageQueue.put(tmpMessage);} //back to the messageQueue
								}else { //isEmpty
									requirementMet = false;
								}
							}
							if (requirementMet)
								break;
						}
						//semCapsuleTracker.release();
					}
					if (listTriggers.size() == 0) {
						//this.currentState = targetTransitionData.getTarget().getName();
						requirementMet = true;
						senderCapInstanceName = "";
					}

					//--

					//Check requirementMet!
					if ((eventSourceNameSplit[4].contains(targetTransitionData.getTransitonName()) || (targetTransitionData.getTransitonName() == null)) &&
							requirementMet) {
						String targetCapsuleName = "";

						//TODO:checking for guards will be done later

						//event would be consumed!
						//looking into the targetStateData.getExitActions() for sending messages into messageQueues
						for (int j = 0; j < targetTransitionData.getActions().size(); j++) {
							if (!lookTrgCap_and_sendMSG(targetTransitionData.getActions().get(j)))
								return false; //faild!
						}

						//Check if the target state is a CHOICE point
						if (this.targetChoiceState) {
							// we should wait for an other transition
							//TODO: guard can be checked!
							currentStatus = "TRANISTIONEND";
							//System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: TRANISTION from: " + targetTransitionData.getSourceName() + " to :" + targetTransitionData.getTargetName());

						}else if (this.sourceChoiceState) {
							//System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: TRANISTION from: " + targetTransitionData.getSourceName() + " to :" + targetTransitionData.getTargetName());

						} else {
							currentStatus = "STATEENTRYEND";
						}
						sourceStateData = tableDataMember.getSource();
						targetStateData = tableDataMember.getTarget();
						transitionName = targetTransitionData.getTransitonName();
						result = true;

					}
				}
			}
		}
		return result;
		*/
	}
	//==================================================================	
	//==============================================[lookTrgCap_and_sendMSG]
	//==================================================================	
	private boolean lookTrgCap_and_sendMSG(String action) throws InterruptedException {
		String targetCapsuleName ="";
		String[] actionParts = action.split("\\.|\\(");
		if ((actionParts[3].contains("sendAt")) && (actionParts[4].contains("msg->sapIndex0_"))) { //TODO: only msg->sapIndex0_ handled 
			//System.out.println("\n====================>["+ Thread.currentThread().getName() +"]"+ "--> senderCapInstanceName:" + senderCapInstanceName);
			targetCapsuleName = senderCapInstanceName;
		}else if ((actionParts[3].contains("sendAt")) && (actionParts[4].contains("0"))) { //TODO: REMOVE LATER -Replication.uml  
			targetCapsuleName = "Simulator__server1";
		}
		else if ((actionParts[3].contains("sendAt")) && (actionParts[4].contains("1"))) { //TODO: REMOVE LATER -Replication.uml  
			targetCapsuleName = "Simulator__server2";
		}else if ((actionParts[3].contains("sendAt")) && !(actionParts[4].contains("msg->sapIndex0_"))) {
			System.err.println("__________ sendAt an unknown capsule __________");
		}else if ((actionParts[3].contentEquals("send")) && (!actionParts[4].contentEquals(");"))) {
			//Sending to all capsules
			targetCapsuleName = lookingForTargetCapsuleName(actionParts[0],true); 
		}else {
			targetCapsuleName = lookingForTargetCapsuleName(actionParts[0],false);
		}

		//}else {
		//	targetCapsuleName = senderCapInstanceName;
		//	senderCapInstanceName = "";
		//}
		//semCapsuleTracker.acquire();
		if (targetCapsuleName.contains(",")) {
			String [] splitTargetCapsuleName = targetCapsuleName.split("\\,");
			for (int q = 0; q<splitTargetCapsuleName.length; q++) {
				int send_to_msgQ_count = 0;
				do {
					// Sleep current thread, if capsuleTracker for the target capsule has not been created!
					System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
					Thread.currentThread().sleep(1);
					sendToMessageQueue(splitTargetCapsuleName[q], actionParts[0], actionParts[1]);
					if (send_to_msgQ_count++ == Controller.MAX_TRY_TO_SEND)
						return false;
				}while(!sendToMessageQueue(splitTargetCapsuleName[q], actionParts[0], actionParts[1]));
			}
		}else {
			int send_to_msgQ_count = 0;
			do {
				// Sleep current thread, if capsuleTracker for the target capsule has not been created!
				System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
				Thread.currentThread().sleep(1);
				if (send_to_msgQ_count++ == Controller.MAX_TRY_TO_SEND)
					return false;
			}while(!sendToMessageQueue(targetCapsuleName, actionParts[0], actionParts[1]));
			//System.out.println("\n=====>  [action]:" + action);

			//semCapsuleTracker.release();
		}
		return true;
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
