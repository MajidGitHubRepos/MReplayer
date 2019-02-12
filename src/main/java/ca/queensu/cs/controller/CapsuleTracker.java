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
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import org.eclipse.microprofile.metrics.Timer;
import org.eclipse.uml2.uml.State;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ca.queensu.cs.graph.ViewEngine;
import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.ServerVTOrdering;
import ca.queensu.cs.umlrtParser.StateData;
import ca.queensu.cs.umlrtParser.TableDataMember;
import ca.queensu.cs.umlrtParser.TransitionData;
import ca.queensu.cs.umlrtParser.UmlrtParser;
import ca.queensu.cs.umlrtParser.UmlrtUtils;


public class CapsuleTracker implements Runnable{

	private Semaphore semCapsuleTracker;
	private String capsuleInstance;
	private Event currentEvent;
	private BlockingQueue <Event> eventQueueTmp;
	public BlockingQueue <Message> messageQueue;
	private String currentStatus;
	public String currentState;
	public String previousState;
	public String transitionName;
	private StateData sourceStateData;
	private StateData targetStateData;
	private boolean targetChoiceState;
	private boolean sourceChoiceState;
	private OutputStream outputFileStream;
	private Date date;
	private double timeMilli;
	private String outputStrTofile;
	private long offset;
	private Timer timer;
	private int MAX_TRY_TO_SEND;
	private int[] logicalVectorTime;
	private int TrackerMakerNumber;
	private Event stateExitEvent;
	private double stateExitTimer =0;
	private static String senderCapInstanceName;
	private static int WEBSERVER_PORT;
	private String currentStateToChiceState;
	private String currentTransitionToFromChiceState;


	public CapsuleTracker(Semaphore semCapsuleTracker, String capsuleInstance, OutputStream outputFileStream, int[] logicalVectorTime) {
		this.currentStateToChiceState ="";
		this.currentTransitionToFromChiceState = "";
		this.WEBSERVER_PORT = 8090;
		this.senderCapInstanceName = "";
		this.stateExitEvent = null;
		this.TrackerMakerNumber = 0;
		this.semCapsuleTracker = semCapsuleTracker;
		this.capsuleInstance = capsuleInstance;
		this.outputFileStream = outputFileStream;
		this.logicalVectorTime = logicalVectorTime;
		this.eventQueueTmp = new LinkedBlockingQueue<Event>(); // read but not consume!
		this.messageQueue = new LinkedBlockingQueue<Message>();
		this.currentStatus = "REGISTER";
		this.currentState = "Initial";
		this.targetStateData = new StateData();
		this.sourceStateData = new StateData();
		this.targetChoiceState = false;
		this.sourceChoiceState = false;
		this.timeMilli = 0;
		this.outputStrTofile = "";
		this.date = new Date();
		this.timer = new TimerImpl();
		this.MAX_TRY_TO_SEND = 2;
	}


	public void run() {
		//Go to the initial state and wait for the right event

		while(true) {
			try {
				semCapsuleTracker.acquire();
				for (int i = 0; i< TrackerMaker.trackerCount; i ++) {
					if (TrackerMaker.dataArray[i].getCapsuleInstance().contains(capsuleInstance)) {
						try {
							TrackerMakerNumber = i; // used to show which element in logicalVectorTime should be changed later 
							if (!eventQueueTmp.isEmpty()) {
								//First: checking eventQueueTmp
								int eventQueueTmpSize = eventQueueTmp.size();
								for (int j = 0; j < eventQueueTmpSize;  j++) {
									Event currentEventTmp = eventQueueTmp.take();
									//checking its validity based on the state machine
									if (isConsumable(currentEventTmp)) {
										//timeMilli = System.nanoTime();
										//timeMilli = date.getTime();
										
										if (TrackerMaker.checkPolicy) {
											if (!TrackerMaker.checkPolicyViolation(capsuleInstance,currentEventTmp)) {
												// policy respected so far!
												TrackerMaker.addCapsulePaths(capsuleInstance, currentEventTmp);
											}else {
												System.err.println("=================[A violation form defined policy happend!]================");
												TrackerMaker.addCapsulePaths(capsuleInstance, currentEventTmp);
											}
										}else {
											TrackerMaker.addCapsulePaths(capsuleInstance, currentEventTmp);
										}
										
										if (currentStatus.contains("TRANISTIONEND")) { // current event is stateExit => save event and do not put timestamp before transition done
											stateExitEvent = currentEventTmp;
											stateExitTimer = ((TimerImpl) timer).nowNano();
										}else if ((currentStatus.contains("STATEENTRYEND")) && (stateExitEvent != null)) { // current event is transition => put timestamp for stateExit and transition
											logicalVectorTime[TrackerMakerNumber]--;
											outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", stateExitTimer)+"]: "+*/stateExitEvent.allDataToString()+"\n\n";
											outputStreamToFile(this.outputFileStream,outputStrTofile);
											logicalVectorTime[TrackerMakerNumber]++;
											outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", ((TimerImpl) timer).nowNano())+"]: "+*/currentEventTmp.allDataToString()+"\n\n";
											outputStreamToFile(this.outputFileStream,outputStrTofile);
											stateExitEvent = null;
											stateExitTimer = 0;
										}else {
											outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", ((TimerImpl) timer).nowNano())+"]: "+*/currentEventTmp.allDataToString()+"\n\n";
											outputStreamToFile(this.outputFileStream,outputStrTofile);
										}

										//current state changed in *checking functions 
										break; //because of the reason if the first element can not be consume at the moment it could go through the rest of the queue 
									}
									//still not consume from eventQueueTmp to eventQueueTmp
									else {eventQueueTmp.put(currentEventTmp);}
								}
							}
							if(!TrackerMaker.dataArray[i].getEventQueue().isEmpty()) {
								currentEvent =  TrackerMaker.dataArray[i].getFromQueue(); //push it back to the queue if it dose not consume !

								//while(true) {
									if (isConsumable(currentEvent)) {
										//timeMilli = System.nanoTime();
										//timeMilli = date.getTime(); //Milisec by imposing delay to the producers that would be enough
										
										if (TrackerMaker.checkPolicy) {
											if (!TrackerMaker.checkPolicyViolation(capsuleInstance, currentEvent)) {
												// policy respected so far!
												TrackerMaker.addCapsulePaths(capsuleInstance, currentEvent);
											}else {
												System.err.println("=================[A violation form defined policy happend!]================");
											}
										}else {
											TrackerMaker.addCapsulePaths(capsuleInstance, currentEvent);
										}
										
										if (currentStatus.contains("TRANISTIONEND")) { // current event is stateExit => save event and do not put timestamp before transition done
											stateExitEvent = currentEvent;
											stateExitTimer = ((TimerImpl) timer).nowNano();
										}else if ((currentStatus.contains("STATEENTRYEND")) && (stateExitEvent != null)) { // current event is transition => put timestamp for stateExit and transition
											logicalVectorTime[TrackerMakerNumber]--;
											outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", stateExitTimer)+"]: "+*/stateExitEvent.allDataToString()+"\n\n";
											outputStreamToFile(this.outputFileStream,outputStrTofile);
											logicalVectorTime[TrackerMakerNumber]++;
											outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", ((TimerImpl) timer).nowNano())+"]: "+*/currentEvent.allDataToString()+"\n\n";
											outputStreamToFile(this.outputFileStream,outputStrTofile);
											stateExitEvent = null;
											stateExitTimer = 0;
										}else {
											outputStrTofile = "Vector Time: "+Arrays.toString(logicalVectorTime)+/*"-["+String.format("%f", ((TimerImpl) timer).nowNano())+"]: "+*/currentEvent.allDataToString()+"\n\n";
											outputStreamToFile(this.outputFileStream,outputStrTofile);
										}

										//current state changed in *checking functions
										//if(!TrackerMaker.dataArray[i].getEventQueue().isEmpty())
										//	currentEvent =  TrackerMaker.dataArray[i].getFromQueue();
										//else break;
										//System.out.println("\n-->["+ Thread.currentThread().getName() +"] [currentEvent]:" + currentEvent.allDataToString());

									}
									//still not consume from eventQueue to eventQueueTmp
									else {eventQueueTmp.put(currentEvent);}
									break;
								//}


							}
						}catch (NoSuchElementException e) {System.err.println("====[NoSuchElementException]===");break;}
						break; //back to the first while
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
		switch (currentStatus) {
			case "REGISTER":          if (registerChecking(event))       {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: REGISTER received!");
				logicalVectorTime[TrackerMakerNumber]++; TrackerMaker.priorityEventCounter++; return true;};
				break;
				
			case "Initial":  	      if (initChecking(event))           {
				//System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]-->[variables]"+ event.getVariableData() );
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: Initial received!");
				
				if (sourceStateData.getStateName()!=null)
					
						if (!callSendJsonToServer(TrackerMaker.priorityEventCounter,capsuleInstance, sourceStateData.getStateName(),event.getVariableData())&&(Controller.args0 == "view")) System.err.println("===[WEB_SERVER CONNECTION FAILD]===");
					
				//TODO: init transitions must be named initTr
				if (!callSendJsonToServer(TrackerMaker.priorityEventCounter,capsuleInstance, "initTr",event.getVariableData())&&(Controller.args0 == "view")) System.err.println("===[WEB_SERVER CONNECTION FAILD]===");
				logicalVectorTime[TrackerMakerNumber]++; return true;};
				break;
			
			case "STATEENTRYEND":     if (entryStateChecking(event))     {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: STATEENTRYEND received! for: "+ currentState);	
				logicalVectorTime[TrackerMakerNumber]++; TrackerMaker.priorityEventCounter++; return true;};
				break;
			
			case "PREtr":             if (preTransitionChecking(event))  {logicalVectorTime[TrackerMakerNumber]++; TrackerMaker.priorityEventCounter++; return true;};
				break;
			
			case "TRANISTIONEND":     if (transitionChecking(event))     {
				if (!this.targetChoiceState && !this.sourceChoiceState) {
					//System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]-->[variables]"+ event.getVariableData() );
					System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: STATEEXITEND received! for: "+ currentState);
					System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: TRANISTIONEND received! for: "+ transitionName);
				}
				if(this.targetChoiceState) { //Keep currentState and transitionName when we have choicePoint
					this.currentTransitionToFromChiceState = transitionName;
					this.currentStateToChiceState = currentState;
				}
				if(this.sourceChoiceState) {
					this.currentTransitionToFromChiceState = this.currentTransitionToFromChiceState +", "+ transitionName;
					System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: STATEEXITEND received! for: "+ currentStateToChiceState);
					System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: TRANISTIONEND received! for: "+ this.currentTransitionToFromChiceState);
					this.currentTransitionToFromChiceState = "";
					this.currentStateToChiceState = "";
				}
				if (!callSendJsonToServer(TrackerMaker.priorityEventCounter,capsuleInstance, currentState, event.getVariableData())&&(Controller.args0 == "view"))   System.err.println("===[WEB_SERVER CONNECTION FAILD]===");
				if (!callSendJsonToServer(TrackerMaker.priorityEventCounter,capsuleInstance, transitionName, event.getVariableData())&&(Controller.args0 == "view")) System.err.println("===[WEB_SERVER CONNECTION FAILD]===");

				logicalVectorTime[TrackerMakerNumber]++; return true;};
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
	//==============================================[setLogicalVectorTime]
	//==================================================================		
	public void setLogicalVectorTime (int [] logicalVT) {
		for (int i = 0; i<logicalVectorTime.length -1 ; i++)
		if (logicalVectorTime[i]< logicalVT[i]) {
			logicalVectorTime[i] = logicalVT[i];
		}
	}
	//==================================================================	
	//==============================================[transitionEventGoesToTheTargetState]
	//==================================================================		
	public TableDataMember rowInTableDataMemberLeadsToTargetState(String eventTransitionName, String targetStateName){

		for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {
			if (entry.getKey().contains(capsuleInstance)) {
				for (int i = 0; i < entry.getValue().size(); i++) {
					//check transition target with targetStateName, they have to be the same 
					if ((targetStateName!= null)) {
						//System.out.println("\n=={Debug}==["+ Thread.currentThread().getName() +"]+++>[getTransition().getSource()] : "+ entry.getValue().get(i).getTransition().getSource().getName());
						if ((entry.getValue().get(i).getTransition().getSource().getName() != null)) {
							//System.out.println("entry.getValue().get(i).getTransition():"+entry.getValue().get(i).getTransition().allDataToString());
						if (entry.getValue().get(i).getTransition().getTransitonName().contentEquals(eventTransitionName) && 
								(entry.getValue().get(i).getTransition().getSource().getName().contentEquals(targetStateName))) {
							return entry.getValue().get(i);
						}
					}
					}else if ((targetStateName == null)) {
						if (entry.getValue().get(i).getTransition().getTransitonName().contentEquals(eventTransitionName) && 
								(entry.getValue().get(i).getSource().getPseudoStateKind() == targetStateData.getPseudoStateKind())) {
							return entry.getValue().get(i);
						}
					}
				}
			}
		}
		//System.err.println("___The row in TableDataMember NOTFOUND__eventTransitionName:"+eventTransitionName+"____targetStateName"+targetStateName);
		return null;
	}
	//==================================================================	
	//==============================================[sendToMessageQueue]
	//==================================================================
	public boolean sendToMessageQueue(String targetCapsuleName, String port, String msg) throws InterruptedException {

		boolean sentSuccessfully = false;
		int [] tmpLogicalVectorTime = this.logicalVectorTime;

		Message sentMsg = new Message(port,msg, this.capsuleInstance,this.logicalVectorTime);

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
				TrackerMaker.capsuleTrackers[i].messageQueue.put(sentMsg);

				sentSuccessfully = true;
				return sentSuccessfully;
			}
		}
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

		for (int i = 0; i< Controller.umlrtParser.getlistCapsuleConn().size(); i++) {
			List<String> listCapsulePortName = Controller.umlrtParser.getlistCapsuleConn().get(i).getListPortName();
			List<String> listCapsulePortConn = Controller.umlrtParser.getlistCapsuleConn().get(i).getListPortName_connectorName_PortName_protocolName();
			String capsuleName = Controller.umlrtParser.getlistCapsuleConn().get(i).getCapsuleInstanceName();
			for (int j = 0; j < listCapsulePortConn.size() ; j++) {
				if (listCapsulePortConn.get(j).contains(port)) {
					//let's find the other side of this connector, which port ? then which capsule?
					String [] listCapsulePortConnSplit = listCapsulePortConn.get(j).split("\\::");
					//connector

					String port1 = listCapsulePortConnSplit[0];
					String connector = listCapsulePortConnSplit[1];
					String port2 = listCapsulePortConnSplit[2];
					String protocol = listCapsulePortConnSplit[3];

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
		return targetCapsuleName;		
	}

	//==================================================================	
	//==============================================[registerChecking]
	//==================================================================
	public boolean registerChecking(Event event) {
		//Check transitionKind = 10 and eventType = 36 [For REGISTER] 
		if (event.getSourceKind().contentEquals("10") && event.getType().contentEquals("36")) {
			currentStatus = "Initial";
			return true;
		}
		return false;
	}

	//==================================================================	
	//==============================================[initChecking]
	//==================================================================	
	public boolean initChecking(Event event) throws InterruptedException {
		//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[initChecking] [event]: "+ event.allDataToString());
		boolean result = false;
		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong
		String[] eventSourceNameSplit = event.getSourceName().split("\\::");

		//Check transitionKind = 3 and eventType = 14 [For Init] 
		if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14") /*&& 
				event.getSourceName().contains("initTr")*/) { 
			//No need to check for trigger because it is init transition!

			//Extracting init transition action code(s) from listTableData
			for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {

				if (entry.getKey().contains(capsuleInstance)) {
					for (int i = 0; i < entry.getValue().size(); i++) {
						if ((entry.getValue().get(i).getSource().isInitial() && entry.getValue().get(i).getTransition().getIsInit())) {//isInit
							//Transition found in the tabalData

							if ((entry.getValue().get(i).getTransition().getActions().size()>0)) {
								//All action codes

								for (int j = 0; j < entry.getValue().get(i).getTransition().getActions().size(); j++) {
									
									if (!lookTrgCap_and_sendMSG(entry.getValue().get(i).getTransition().getActions().get(j)))
										return false; //faild!
									//Replaced by lookTrgCap_and_sendMSG
									/*String[] actionParts = entry.getValue().get(i).getTransition().getActions().get(j).split("\\.|\\(");
									String targetCapsuleName = lookingForTargetCapsuleName(actionParts[0],false);
									
									int send_to_msgQ_count = 0;
									if (targetCapsuleName != "") {
										do {
											// Sleep current thread, if capsuleTracker for the target capsule has not been created!
											System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
											Thread.currentThread().sleep(1);
											if (send_to_msgQ_count++ == MAX_TRY_TO_SEND)
												return false;
										}while(!sendToMessageQueue(targetCapsuleName, actionParts[0], actionParts[1]));
									}*/
								}
							}

							result = true;
							//[entry.getValue().get(i).getTarget()] : target found in tableData, target should be a source in a member in tableData
							sourceStateData = entry.getValue().get(i).getSource();
							targetStateData = entry.getValue().get(i).getTarget();

							//pick a name [State, PseudoState]
							/*if (entry.getValue().get(i).getTarget().getStateName() != null) {
								currentStatus = entry.getValue().get(i).getTarget().getStateName();
							} else if (entry.getValue().get(i).getTarget().getPseudoStateKind() != null) {
								currentStatus = "PseudoState__"+entry.getValue().get(i).getTarget().getPseudoStateKind();
							} else {*/currentStatus = "STATEENTRYEND";//}
						}//isInit
					}
				}
			}
		}
		return result;
	}

	//==================================================================	
	//==============================================[entryStateChecking]
	//==================================================================	
	public boolean entryStateChecking(Event event) throws InterruptedException {

		boolean result = false;
		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong
		String[] eventSourceNameSplit = event.getSourceName().split("\\::");

		//Check eventSourceKind = 4 and eventType = 16 [For STATEENTRYEND] 
		if (event.getSourceKind().contentEquals("4") && event.getType().contentEquals("16") && 
				(eventSourceNameSplit[4].contentEquals(targetStateData.getStateName()) || ((targetStateData.getStateName() == null) && (targetStateData.getPseudoStateKind() != null)))) {
			//event would be consumed!
			//looking into the targetStateData.getEntryActions() for sending messages into messageQueues
			for (int j = 0; j < targetStateData.getEntryActions().size(); j++) {

				if (!lookTrgCap_and_sendMSG(targetStateData.getEntryActions().get(j)))
					return false; //faild!
				//Replaced by lookTrgCap_and_sendMSG
				/*String[] actionParts = targetStateData.getEntryActions().get(j).split("\\.");  
				String targetCapsuleName = lookingForTargetCapsuleName(actionParts[0],false);

				//semCapsuleTracker.acquire();
				do {
					// Sleep current thread, if capsuleTracker for the target capsule has not been created!
					System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
					Thread.currentThread().sleep(1);
				}while(!sendToMessageQueue(targetCapsuleName, actionParts[0], actionParts[1]));
				//semCapsuleTracker.release();
				*/
			}
			//previous transition done
			
			if ((sourceStateData.getStateName() != null) && (targetStateData.getStateName()!= null)) {
				this.previousState = sourceStateData.getStateName();
				this.currentState = targetStateData.getStateName();
			} else if ((sourceStateData.getStateName() != null) && (targetStateData.getStateName()== null)) {
				this.previousState = sourceStateData.getStateName();
				this.currentState = targetStateData.getPseudoStateKind().toString();
				
			} else if((sourceStateData.getStateName() == null) && (targetStateData.getStateName()!= null)) {
				this.previousState = sourceStateData.getPseudoStateKind().toString();
				this.currentState = targetStateData.getStateName();
			}
			
			//become ready for the next transition 
			currentStatus = "PREtr";
			result = true;
		}

		return result;
	}

	//==================================================================	
	//==============================================[exitStateChecking]
	//==================================================================	
	public boolean exitStateChecking(Event event) throws InterruptedException {

		boolean result = false;
		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong
		String[] eventSourceNameSplit = event.getSourceName().split("\\::");

		//checking trigger requirement will be done in the  following transition

		//Check eventSourceKind = 4 and eventType = 18 [For STATEEXITEND] 
		if (event.getSourceKind().contentEquals("4") && event.getType().contentEquals("18") && 
				(eventSourceNameSplit[4].contentEquals(targetStateData.getStateName()) || ((targetStateData.getStateName() == null) && (targetStateData.getPseudoStateKind() != null)))) {

			//checking for guards will be done in the following transition

			//targetStateData.getExitActions() will be processed in the transition after checking the requirements

			//event would be consumed!
			currentStatus = "TRANISTIONEND";
			result = true;
		}
		return result;
	}

	//==================================================================	
	//==============================================[preTransitionChecking]
	//==================================================================	
	public boolean preTransitionChecking(Event event) throws InterruptedException {

		if (event.getSourceKind().contentEquals("4") && event.getType().contentEquals("18")) {
			if (exitStateChecking(event))
				return true;
		}
		return false;
	}

	//==================================================================	
	//==============================================[transitionChecking]
	//==================================================================	
	public boolean transitionChecking(Event event) throws InterruptedException {
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

				tableDataMember = rowInTableDataMemberLeadsToTargetState(eventSourceNameSplit[4], targetStateData.getStateName());
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
							for (int t = 0; t<messageQueue.size(); t++) {
								if (!messageQueue.isEmpty()) {
									Message tmpMessage = messageQueue.take();

									if (tmpMessage.getMsg().contains(triggerMsg)) { 
										senderCapInstanceName = tmpMessage.getCapsuleInstance(); 
										setLogicalVectorTime(tmpMessage.getLogicalVectorTime());
										requirementMet = true;
										break;}
									else {messageQueue.put(tmpMessage);} //back to the messageQueue
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
							System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: TRANISTION from: " + targetTransitionData.getSourceName() + " to :" + targetTransitionData.getTargetName());

						}else if (this.sourceChoiceState) {
							System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: TRANISTION from: " + targetTransitionData.getSourceName() + " to :" + targetTransitionData.getTargetName());

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
					if (send_to_msgQ_count++ == MAX_TRY_TO_SEND)
						return false;
				}while(!sendToMessageQueue(splitTargetCapsuleName[q], actionParts[0], actionParts[1]));
			}
		}else {
			int send_to_msgQ_count = 0;
			do {
				// Sleep current thread, if capsuleTracker for the target capsule has not been created!
				System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
				Thread.currentThread().sleep(1);
				if (send_to_msgQ_count++ == MAX_TRY_TO_SEND)
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
