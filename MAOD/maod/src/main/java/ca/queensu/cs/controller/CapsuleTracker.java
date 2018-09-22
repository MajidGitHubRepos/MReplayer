package ca.queensu.cs.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import ca.queensu.cs.server.Event;
import ca.queensu.cs.umlrtParser.TableDataMember;


public class CapsuleTracker implements Runnable{

	private Semaphore semCapsuleTracker;
	private String capsuleInstance;
	private Event currentEvent;
	private BlockingQueue <Event> eventQueueTmp;
	private BlockingQueue <Message> messageQueue;
	private String currentState;


	public CapsuleTracker(Semaphore semCapsuleTracker, String capsuleInstance) {
		this.semCapsuleTracker = semCapsuleTracker;
		this.capsuleInstance = capsuleInstance;
		this.eventQueueTmp = new LinkedBlockingQueue<Event>(); // read but not consume!
		this.messageQueue = new LinkedBlockingQueue<Message>();
		this.currentState = "REGISTER";
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

								//Thread.currentThread().sleep(1);

								if (!eventQueueTmp.isEmpty()) {
									//First: checking eventQueueTmp
									for (int j = 0; j < eventQueueTmp.size(); j++) {
										Event currentEventTmp = eventQueueTmp.take();
										//checking its validity based on the state machine
										if (isConsumable(currentEventTmp)) {

											//change current state 
											break;
										}
										eventQueueTmp.put(currentEventTmp);//still not consume!
									}
								}
								currentEvent =  TrackerMaker.dataArray[i].getFromQueue(); //push it back to the queue if it dose not consume !


								eventQueueTmp.put(currentEvent);//not consume!

								//System.out.println("\n[in CapsuleTracker]-->["+ capsuleInstance+ "]: " + currentEvent.allDataToString());
							} catch (NoSuchElementException e) {
								System.err.println("=============================[NoSuchElementException]===================================");
								break;
							}
						}
						break;
					}
				}
				semCapsuleTracker.release();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public boolean isConsumable(Event event) throws InterruptedException {

		switch (currentState) {
		case "REGISTER":  if (registerChecking(event)) {currentState = "Initial"; return true;};
		break;
		case "Initial":   if (initChecking(event))     {return true;};
		break;
		}



		return false;
	}

	//==================================================================	
	//==============================================[registerChecking]
	//==================================================================
	public boolean registerChecking(Event event) {
		//Check transitionKind = 10 and eventType = 36 [For REGISTER] 
		if (event.getSourceKind().contentEquals("10") && event.getType().contentEquals("36")) {
			return true;
		}
		return false;
	}

	//==================================================================	
	//==============================================[initChecking]
	//==================================================================	
	public boolean initChecking(Event event) throws InterruptedException {
		//Check transitionKind = 3 and eventType = 14 [For Init] 
		if (event.getSourceKind().contentEquals("3") && event.getType().contentEquals("14") && 
				event.getSourceName().contentEquals("Initial")) {
			//No need to check for trigger because it is init transition!

			//Extracting init transition action code(s) from listTableData
			for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {
				if (entry.getKey().contains(capsuleInstance)) {
					for (int i = 0; i < entry.getValue().size(); i++) {
						if (entry.getValue().get(i).getSource().isInitial() && entry.getValue().get(i).getTransition().getIsInit()) {//isInit
							//All action codes
							for (int j = 0; j < entry.getValue().get(i).getTransition().getActions().size(); j++) {
								String[] actionParts = entry.getValue().get(i).getTransition().getActions().get(j).split(".");
								Message message = new Message(actionParts[0], actionParts[1]); //port,msg
								messageQueue.put(message);
							}
							if (entry.getValue().get(i).getTarget().getStateName() != null) {
								currentState = entry.getValue().get(i).getTarget().getStateName();
							} else if (entry.getValue().get(i).getTarget().getPseudoStateKind() != null) {
								currentState = "PseudoState__"+entry.getValue().get(i).getTarget().getPseudoStateKind();
							} else {currentState = "State";}
						}//isInit
					}
				}
			}
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public void shutdown() {
		Thread.currentThread().stop();
	}


}
