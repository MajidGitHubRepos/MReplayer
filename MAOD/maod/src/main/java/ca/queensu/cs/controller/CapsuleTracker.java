package ca.queensu.cs.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import ca.queensu.cs.server.Event;
import ca.queensu.cs.umlrtParser.StateData;
import ca.queensu.cs.umlrtParser.TableDataMember;
import ca.queensu.cs.umlrtParser.TransitionData;
import ca.queensu.cs.umlrtParser.UmlrtParser;


public class CapsuleTracker implements Runnable{

	private Semaphore semCapsuleTracker;
	private String capsuleInstance;
	private Event currentEvent;
	private BlockingQueue <Event> eventQueueTmp;
	public BlockingQueue <Message> messageQueue;
	private String currentState;
	private StateData targetStateData;


	public CapsuleTracker(Semaphore semCapsuleTracker, String capsuleInstance) {
		this.semCapsuleTracker = semCapsuleTracker;
		this.capsuleInstance = capsuleInstance;
		this.eventQueueTmp = new LinkedBlockingQueue<Event>(); // read but not consume!
		this.messageQueue = new LinkedBlockingQueue<Message>();
		this.currentState = "REGISTER";
		this.targetStateData = new StateData();
	}


	public void run() {
		//Go to the initial state and wait for the right event

		while(true) {
			try {
				semCapsuleTracker.acquire();
				for (int i = 0; i< TrackerMaker.trackerCount; i ++) {
					if (TrackerMaker.dataArray[i].getCapsuleInstance().contains(capsuleInstance)) {
						if(!TrackerMaker.dataArray[i].getEventQueue().isEmpty()) {
							//System.out.println("\n\n--> [" + TrackerMaker.dataArray[i].getCapsuleInstance() +"] Running thread: " +  capsuleInstance + ", Size: "+ TrackerMaker.dataArray[i].getEventQueue().size() +"\n\n");
							try {

								if (!eventQueueTmp.isEmpty()) {
									//System.out.println("\n-->["+ Thread.currentThread().getName() +"]--->  [checking eventQueueTmp size:]" + eventQueueTmp.size());
									//First: checking eventQueueTmp
									int eventQueueTmpSize = eventQueueTmp.size();
									for (int j = 0; j < eventQueueTmpSize;  j++) {
										Event currentEventTmp = eventQueueTmp.take();
										//System.out.println("\n-->["+ Thread.currentThread().getName() +"] [currentEventTmp]:" + currentEventTmp.allDataToString());
										//checking its validity based on the state machine
										if (isConsumable(currentEventTmp)) {
											//System.out.println("\n["+ Thread.currentThread().getName() +"]=====================> Consumed Done from eventQueueTmp");
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
										//current state changed in *checking functions
										currentEvent =  TrackerMaker.dataArray[i].getFromQueue();
										//System.out.println("\n-->["+ Thread.currentThread().getName() +"] [currentEvent]:" + currentEvent.allDataToString());

										//System.out.println("\n["+ Thread.currentThread().getName() +"]=====================>  Consumed Done from eventQueue");
									}
									//still not consume from eventQueue to eventQueueTmp
									else {eventQueueTmp.put(currentEvent); /*System.out.println("\n["+ Thread.currentThread().getName() +"]--> currentEvent back to the eventQueueTmp");*/ break;}
								}

								//System.out.println("\n[in CapsuleTracker]-->["+ capsuleInstance+ "]: " + currentEvent.allDataToString());
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

		switch (currentState) {
			case "REGISTER":          if (registerChecking(event))       {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: REGISTER received!");
				return true;};
				break;
			case "Initial":  	      if (initChecking(event))           {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: Initial received!"); 
				return true;};
				break;
			
			case "STATEENTRYEND":     if (entryStateChecking(event))     {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: STATEENTRYEND received!");
				return true;};
				break;
			
			
			case "PREtr":     if (preTransitionChecking(event))          { return true;};
				break;
			
			case "TRANISTIONEND":     if (transitionChecking(event))     {
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: STATEEXITEND received!");
				System.out.println(">>>>>>>>>>>>>>>["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: TRANISTIONEND received!");
				return true;};
			break;
				
		}


		return false;
	}

	//==================================================================	
	//==============================================[sendToMessageQueue]
	//==================================================================
	public boolean sendToMessageQueue(String targetCapsuleName, String port, String msg) throws InterruptedException {
		//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[sendToMessageQueue]");

		boolean sentSuccessfully = false;
		Message sentMsg = new Message(port,msg);
		for (int i=0; i< TrackerMaker.trackerCount; i++) {
			if(TrackerMaker.capsuleTrackers[i].capsuleInstance.contains(targetCapsuleName)){
				//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[TrackerMaker.capsuleTrackers[i].capsuleInstance]"+TrackerMaker.capsuleTrackers[i].capsuleInstance);

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
		boolean portFound = false;
		
		for (int i = 0; i< Controller.umlrtParser.getlistCapsuleConn().size(); i++) {
			List<String> listCapsulePortConn = Controller.umlrtParser.getlistCapsuleConn().get(i).getListPortName_connectorName_protocolName();
			//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in listCapsulePortConn]: " +listCapsulePortConn);

			for (int j = 0; j < listCapsulePortConn.size() ; j++) {
				//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in listCapsulePortConn.get(j)]: " +listCapsulePortConn.get(j));

				if (listCapsulePortConn.get(j).contains(port)) {
					//let's find the other side of this connector, which port ? then which capsule?
					String [] listCapsulePortConnSplit = listCapsulePortConn.get(j).split("\\::");
					//connector
					String port1 = listCapsulePortConnSplit[0];
					String porotocol = listCapsulePortConnSplit[1];
					String connector = listCapsulePortConnSplit[2];
					//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[connector]: " +connector);

					for (int t = 0; t< Controller.umlrtParser.getlistCapsuleConn().size(); t++) {
						List<String> listCapsulePortConnTmp = Controller.umlrtParser.getlistCapsuleConn().get(t).getListPortName_connectorName_protocolName();
						//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[getListPortName_connectorName_protocolName]: " +Controller.umlrtParser.getlistCapsuleConn().get(t).getListPortName_connectorName_protocolName());

						for (int k = 0; k < listCapsulePortConnTmp.size() ; k++) {
							String [] listCapsulePortConnTmpSplit = listCapsulePortConnTmp.get(k).split("\\::");
							if ((listCapsulePortConnTmpSplit[2].contains(connector)) && (listCapsulePortConnTmpSplit[1].contains(porotocol)) &&
									!(listCapsulePortConn.equals(listCapsulePortConnTmp))) {

								portFound = true; 
								targetCapsuleName = Controller.umlrtParser.getlistCapsuleConn().get(t).getCapsuleName();
								//System.out.println("\n["+ Thread.currentThread().getName() +"]****new*****[portFound]: " +targetCapsuleName);

								return targetCapsuleName;
							}
						}
		
					}
					
				}
			}
		}
		return targetCapsuleName;		
	}
	
	//==================================================================	
	//==============================================[registerChecking]
	//==================================================================
	public boolean registerChecking(Event event) {
		//Check transitionKind = 10 and eventType = 36 [For REGISTER] 
		if (event.getSourceKind().contentEquals("10") && event.getType().contentEquals("36")) {
			currentState = "Initial";
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
			//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[initChecking][3,14 Done][event]: "+ event.allDataToString());

			//No need to check for trigger because it is init transition!

			//Extracting init transition action code(s) from listTableData
			for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {
				//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[initChecking][OK0][capsuleInstance]:" + capsuleInstance);
				//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[initChecking][OK0][entry.getKey()]:" + entry.getKey());

				if (entry.getKey().contains(capsuleInstance)) {
					//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[initChecking][OK1]");
					for (int i = 0; i < entry.getValue().size(); i++) {
						if ((entry.getValue().get(i).getSource().isInitial() && entry.getValue().get(i).getTransition().getIsInit())) {//isInit

							if ((entry.getValue().get(i).getTransition().getActions().size()>0)) {
								//All action codes
								//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[initChecking][OK2][ActionSize:] " + entry.getValue().get(i).getTransition().getActions());

								for (int j = 0; j < entry.getValue().get(i).getTransition().getActions().size(); j++) {
									String[] actionParts = entry.getValue().get(i).getTransition().getActions().get(j).split("\\.|\\(");
									//System.out.println("\n["+ Thread.currentThread().getName() +"]***[port]"+actionParts[0]);
									//System.out.println("\n["+ Thread.currentThread().getName() +"]***[msg]"+actionParts[1]);

									String targetCapsuleName = lookingForTargetCapsuleName(actionParts[0]);
									//System.out.println("\n["+ Thread.currentThread().getName() +"]**new**[targetCapsuleName]"+targetCapsuleName);

									if (targetCapsuleName != "") {
										do {
											// Sleep current thread, if capsuleTracker for the target capsule has not been created!
											System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
											Thread.currentThread().sleep(1);
										}while(!sendToMessageQueue(targetCapsuleName, actionParts[0], actionParts[1]));
									}
								}
							}
							//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[initChecking][OK3]");

							result = true;
							//[entry.getValue().get(i).getTarget()] : target found in tableData, target should be a source in a member in tableData
							targetStateData = entry.getValue().get(i).getTarget();

							//pick a name [State, PseudoState]
							/*if (entry.getValue().get(i).getTarget().getStateName() != null) {
								currentState = entry.getValue().get(i).getTarget().getStateName();
							} else if (entry.getValue().get(i).getTarget().getPseudoStateKind() != null) {
								currentState = "PseudoState__"+entry.getValue().get(i).getTarget().getPseudoStateKind();
							} else {*/currentState = "STATEENTRYEND";//}
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
		//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[entryStateChecking]");

		boolean result = false;
		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong
		String[] eventSourceNameSplit = event.getSourceName().split("::");
		
		//Check eventSourceKind = 4 and eventType = 16 [For STATEENTRYEND] 
		if (event.getSourceKind().contentEquals("4") && event.getType().contentEquals("16") && 
				(eventSourceNameSplit[4].contentEquals(targetStateData.getStateName()) || (targetStateData.getStateName() == null))) {
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
			currentState = "PREtr";
			result = true;
		}

		return result;
	}
	
	//==================================================================	
	//==============================================[exitStateChecking]
	//==================================================================	
	public boolean exitStateChecking(Event event) throws InterruptedException {
		//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in exitStateChecking][event:]"+event.allDataToString());

		boolean result = false;
		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong
		String[] eventSourceNameSplit = event.getSourceName().split("::");
		
		//checking trigger requirement will be done in the  following transition
				
		//Check eventSourceKind = 4 and eventType = 18 [For STATEEXITEND] 
		if (event.getSourceKind().contentEquals("4") && event.getType().contentEquals("18") && 
				(eventSourceNameSplit[4].contentEquals(targetStateData.getStateName()) || (targetStateData.getStateName() == null))) {
			
			//checking for guards will be done in the following transition
			
			//targetStateData.getExitActions() will be processed in the transition after checking the requirements
			
			//event would be consumed!
			currentState = "TRANISTIONEND";
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
		//	System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in transitionChecking]");
		boolean result = false;
		boolean requirementMet = false; //TODO: trigger by time!
		TransitionData targetTransitionData = new TransitionData();

		//Samples: PingPong::Pinger::PingerStateMachine::Region::PLAYING , PingPong::Pinger::PingerStateMachine::Region::onPong
		String[] eventSourceNameSplit = event.getSourceName().split("::");
		String eventTransitionName = eventSourceNameSplit[4];
		//System.out.println("===========["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: currentState: " +currentState);

		if (currentState.contains("TRANISTIONEND")) {
			 
			//System.out.println("===========["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: in else!");

			//Check eventSourceKind = 3 and eventType = 14 [For TRANISTIONEND] 
			if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14")){
				//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in transitionChecking][3,14 Done]");

				//looking for the right transition in the tabelData
				//--
				for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {
					if (entry.getKey().contains(capsuleInstance)) {
						for (int i = 0; i < entry.getValue().size(); i++) {
							if (entry.getValue().get(i).getTransition().getTransitonName().contentEquals(eventTransitionName)) {
								//Transition found in the tabalData
								targetTransitionData = entry.getValue().get(i).getTransition();
								List <String> listTriggers = entry.getValue().get(i).getTransition().getTriggers();
								//System.out.println("listTriggers: "+listTriggers);

								//How many trigger does it have?
								int triggerSize = listTriggers.size();
								int triggerCount = 0;
								//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in transitionChecking][listTriggers] " + listTriggers);
								//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in transitionChecking][messageQueue.size] " + messageQueue.size());


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
											//System.out.println("\n["+ Thread.currentThread().getName() +"][capsuleInstance]"+capsuleInstance+"*********[in transitionChecking][messageQueue.getMsg] " +  tmpMessage.getMsg());
											//System.out.println("\n["+ Thread.currentThread().getName() +"][capsuleInstance]"+capsuleInstance+"*********[in transitionChecking][messageQueue.getPort] " +  tmpMessage.getPort());

											if (tmpMessage.getMsg().contains(triggerMsg)) { triggerCount++; break; }
											else {messageQueue.put(tmpMessage);} //back to the messageQueue
										} else { //isEmpty
											requirementMet = false;
										}
									}
									if (triggerCount == triggerSize) {
										requirementMet = true; 
									//	System.out.println("===========["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: requirementMet == true");

										break;}
									//semCapsuleTracker.release();
								}
							}
						}
					}
				}
				//--
				//System.out.println("\n["+ Thread.currentThread().getName() +"]*********[in transitionChecking][before Check requirementMet!]");

				//Check requirementMet!
				if ((eventSourceNameSplit[4].contentEquals(targetTransitionData.getTransitonName()) || (targetTransitionData.getTransitonName() == null)) &&
						requirementMet) {

					//TODO:checking for guards will be done later

					//event would be consumed!
					//looking into the targetStateData.getExitActions() for sending messages into messageQueues
					for (int j = 0; j < targetTransitionData.getActions().size(); j++) {
						String[] actionParts = targetTransitionData.getActions().get(j).split("\\.");
						String targetCapsuleName = lookingForTargetCapsuleName(actionParts[0]);
						//semCapsuleTracker.acquire();
						do {
							// Sleep current thread, if capsuleTracker for the target capsule has not been created!
							System.out.println("\n["+ Thread.currentThread().getName() +"]"+ "--> [!] Trying to send the message to the target capsule messageQueue!");
							Thread.currentThread().sleep(1);
						}while(!sendToMessageQueue(targetCapsuleName, actionParts[0], actionParts[1]));
						//semCapsuleTracker.release();
					}
				//	System.out.println("===========["+ Thread.currentThread().getName() +"]--> ["+capsuleInstance+"]: before result = true;");

					currentState = "STATEENTRYEND";
					result = true;
				}
			}
		}
		return result;
	}


	
	@SuppressWarnings("deprecation")
	public void shutdown() {
		Thread.currentThread().stop();
	}


}
