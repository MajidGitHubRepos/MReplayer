package ca.queensu.cs.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import org.eclipse.microprofile.metrics.Timer;
import org.eclipse.uml2.uml.State;

import ca.queensu.cs.server.Event;
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
	private StateData sourceStateData;
	private StateData targetStateData;
	private boolean targetChoiceState;
	private boolean sourceChoiceState;
	private OutputStream os;
	private Date date;
	private double timeMilli;
	private String outputStrTofile;
	private long offset;
	private Timer timer;



	public CapsuleTracker(Semaphore semCapsuleTracker, String capsuleInstance, OutputStream os) {
		this.semCapsuleTracker = semCapsuleTracker;
		this.capsuleInstance = capsuleInstance;
		this.os = os;
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
	}


	public void run() {
		//Go to the initial state and wait for the right event

		while(true) {
			try {
				semCapsuleTracker.acquire();
				for (int i = 0; i< TrackerMaker.trackerCount; i ++) {
					if (TrackerMaker.dataArray[i].getCapsuleInstance().contains(capsuleInstance)) {
						if(!TrackerMaker.dataArray[i].getEventQueue().isEmpty()) {
							try {

								if (!eventQueueTmp.isEmpty()) {
									//First: checking eventQueueTmp
									int eventQueueTmpSize = eventQueueTmp.size();
									for (int j = 0; j < eventQueueTmpSize;  j++) {
										Event currentEventTmp = eventQueueTmp.take();
										//checking its validity based on the state machine
										if (isConsumable(currentEventTmp)) {
											//timeMilli = System.nanoTime();
											//timeMilli = date.getTime();
											outputStrTofile = "["+String.format("%f", ((TimerImpl) timer).nowNano())+"]: "+currentEventTmp.allDataToString()+"\n<=======================================>\n";
											outputStreamToFile(this.os,outputStrTofile);
											
											//current state changed in *checking functions 
											break;
										}
										//still not consume from eventQueueTmp to eventQueueTmp
										else {eventQueueTmp.put(currentEventTmp);/*System.out.println("\n-->["+ Thread.currentThread().getName() +"] currentEventTmp back to the eventQueueTmp");*/}
									}
								}
								currentEvent =  TrackerMaker.dataArray[i].getFromQueue(); //push it back to the queue if it dose not consume !
								//System.out.println("\n["+ Thread.currentThread().getName() +"]-> [currentEvent]:" + currentEvent.allDataToString());

								while(true) {
									if (isConsumable(currentEvent)) {
										//timeMilli = System.nanoTime();
										//timeMilli = date.getTime(); //Milisec by imposing delay to the producers that would be enough
										outputStrTofile = "["+String.format("%f", ((TimerImpl) timer).nowNano())+"]: "+currentEvent.allDataToString()+"\n<=======================================>\n";
										outputStreamToFile(this.os,outputStrTofile);
										
										//current state changed in *checking functions
										currentEvent =  TrackerMaker.dataArray[i].getFromQueue();
										//System.out.println("\n-->["+ Thread.currentThread().getName() +"] [currentEvent]:" + currentEvent.allDataToString());

									}
									//still not consume from eventQueue to eventQueueTmp
									else {eventQueueTmp.put(currentEvent); /*System.out.println("\n["+ Thread.currentThread().getName() +"]--> currentEvent back to the eventQueueTmp");*/ break;}
								}

							}catch (NoSuchElementException e) {System.err.println("====[NoSuchElementException]===");break;}
						}
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
	//==============================================[isConsumable]
	//==================================================================
	public boolean isConsumable(Event event) throws InterruptedException {

		switch (currentStatus) {
			case "REGISTER":          if (registerChecking(event))       {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: REGISTER received!");
				return true;};
				break;
			case "Initial":  	      if (initChecking(event))           {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: Initial received!"); 
				return true;};
				break;
			
			case "STATEENTRYEND":     if (entryStateChecking(event))     {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: STATEENTRYEND received! for: "+ currentState);
				return true;};
				break;
			
			
			case "PREtr":     if (preTransitionChecking(event))          { return true;};
				break;
			
			case "TRANISTIONEND":     if (transitionChecking(event))     {
				if (!this.targetChoiceState && !this.sourceChoiceState) {
					System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: STATEEXITEND received! for: "+ previousState);
					System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: TRANISTIONEND received!");
				}
					return true;};
			break;
				
		}


		return false;
	}


	//==================================================================	
	//==============================================[transitionEventGoesToTheTargetState]
	//==================================================================		
	public TableDataMember rowInTableDataMemberLeadsToTargetState(String eventTransitionName, String targetStateName){

		for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {
			if (entry.getKey().contains(capsuleInstance)) {
				for (int i = 0; i < entry.getValue().size(); i++) {
					//check transition source with targetStateName, they have to be the same 
					if ((targetStateName!= null)) {
						if (entry.getValue().get(i).getTransition().getTransitonName().contentEquals(eventTransitionName) && 
								(entry.getValue().get(i).getTransition().getSource().getName().contentEquals(targetStateName))) {
							return entry.getValue().get(i);
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
		return null;
	}
	//==================================================================	
	//==============================================[sendToMessageQueue]
	//==================================================================
	public boolean sendToMessageQueue(String targetCapsuleName, String port, String msg) throws InterruptedException {

		boolean sentSuccessfully = false;
		Message sentMsg = new Message(port,msg);
		for (int i=0; i< TrackerMaker.trackerCount; i++) {
			if(targetCapsuleName.contains(TrackerMaker.capsuleTrackers[i].capsuleInstance)){

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
	public String lookingForTargetCapsuleName(String port) {
		//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in lookingForTargetCapsuleName]: ");

		String targetCapsuleName = "";
		String sourceCapsuleName = "";
		String sourcePort = "";
		String targetPort = "";
		boolean portFound = false;

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
							}

						}
					}

					if (targetPort != "") {
						for (int p = 0; p< Controller.umlrtParser.getlistCapsuleConn().size(); p++) {

							if (Controller.umlrtParser.getlistCapsuleConn().get(p).isListPortNameContainsPort(targetPort)) {
								targetCapsuleName = Controller.umlrtParser.getlistCapsuleConn().get(p).getCapsuleInstanceName();
								//System.out.println("["+ Thread.currentThread().getName() +"]*********[targetCapsuleName]: " +targetCapsuleName);
								if (!sourceCapsuleName.contains(targetCapsuleName)) // TODO: what about self-transitions
									return targetCapsuleName; 
							}
						}
					}
				}
			}
		}
		if (targetCapsuleName == "")
			System.err.println("==================[targetCapsuleName not found!]======================");
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
		String[] eventSourceNameSplit = event.getSourceName().split("::");

		//Check transitionKind = 3 and eventType = 14 [For Init] 
		if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14") && 
				event.getSourceName().contains("Initial")) {
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
									String[] actionParts = entry.getValue().get(i).getTransition().getActions().get(j).split("\\.|\\(");
									//System.out.println("\n["+ Thread.currentThread().getName() +"]***[port]"+actionParts[0]);
									//System.out.println("\n["+ Thread.currentThread().getName() +"]***[msg]"+actionParts[1]);

									String targetCapsuleName = lookingForTargetCapsuleName(actionParts[0]);
									if (targetCapsuleName != "") {
										do {
											// Sleep current thread, if capsuleTracker for the target capsule has not been created!
											System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
											Thread.currentThread().sleep(1);
										}while(!sendToMessageQueue(targetCapsuleName, actionParts[0], actionParts[1]));
									}
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
		String[] eventSourceNameSplit = event.getSourceName().split("::");

		//Check eventSourceKind = 4 and eventType = 16 [For STATEENTRYEND] 
		if (event.getSourceKind().contentEquals("4") && event.getType().contentEquals("16") && 
				(eventSourceNameSplit[4].contentEquals(targetStateData.getStateName()) || ((targetStateData.getStateName() == null) && (targetStateData.getPseudoStateKind() != null)))) {
			//event would be consumed!
			//looking into the targetStateData.getEntryActions() for sending messages into messageQueues
			for (int j = 0; j < targetStateData.getEntryActions().size(); j++) {
				String[] actionParts = targetStateData.getEntryActions().get(j).split(".");
				String targetCapsuleName = lookingForTargetCapsuleName(actionParts[0]);

				//semCapsuleTracker.acquire();
				do {
					// Sleep current thread, if capsuleTracker for the target capsule has not been created!
					System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
					Thread.currentThread().sleep(1);
				}while(!sendToMessageQueue(targetCapsuleName, actionParts[0], actionParts[1]));
				//semCapsuleTracker.release();

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
		String[] eventSourceNameSplit = event.getSourceName().split("::");

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
		//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in transitionChecking] event: " + event.allDataToString());
		this.targetChoiceState = false;
		this.sourceChoiceState = false;
		boolean result = false;
		boolean requirementMet = false; //TODO: trigger by time!
		TransitionData targetTransitionData = new TransitionData();
		TableDataMember tableDataMember = new TableDataMember();

		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong
		String[] eventSourceNameSplit = event.getSourceName().split("::");
		String eventTransitionName = eventSourceNameSplit[4];


		if (currentStatus.contains("TRANISTIONEND")) {

			//Check eventSourceKind = 3 and eventType = 14 [For TRANISTIONEND]


			if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14")){

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

						//semCapsuleTracker.acquire();

						for (int t = 0; t<messageQueue.size(); t++) {
							if (!messageQueue.isEmpty()) {
								Message tmpMessage = messageQueue.take();

								if (tmpMessage.getMsg().contains(triggerMsg)) { requirementMet = true;break;}
								else {messageQueue.put(tmpMessage);} //back to the messageQueue
							}else { //isEmpty
								requirementMet = false;
							}
						}
						if (requirementMet)
							break;//}
						//semCapsuleTracker.release();
					}
					if (triggerSize == 0) {
						//this.currentState = targetTransitionData.getTarget().getName();
						requirementMet = true;
					}

					//--

					//Check requirementMet!
					if ((eventSourceNameSplit[4].contains(targetTransitionData.getTransitonName()) || (targetTransitionData.getTransitonName() == null)) &&
							requirementMet) {

						//TODO:checking for guards will be done later

						//event would be consumed!
						//looking into the targetStateData.getExitActions() for sending messages into messageQueues
						for (int j = 0; j < targetTransitionData.getActions().size(); j++) {
							String[] actionParts = targetTransitionData.getActions().get(j).split("\\.|\\(");
							String targetCapsuleName = lookingForTargetCapsuleName(actionParts[0]);
							//semCapsuleTracker.acquire();
							do {
								// Sleep current thread, if capsuleTracker for the target capsule has not been created!
								System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
								Thread.currentThread().sleep(1);
							}while(!sendToMessageQueue(targetCapsuleName, actionParts[0], actionParts[1]));
							//semCapsuleTracker.release();
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
						result = true;

					}
				}
			}
		}
		return result;
	}
	
	//==================================================================	
	//==============================================[openOutputStreamFile]
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

	@SuppressWarnings("deprecation")
	public void shutdown() {
		Thread.currentThread().stop();
	}


}
