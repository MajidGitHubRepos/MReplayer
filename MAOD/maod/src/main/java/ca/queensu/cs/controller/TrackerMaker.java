package ca.queensu.cs.controller;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.Server;
import ca.queensu.cs.umlrtParser.TableDataMember;

public class TrackerMaker implements Runnable{

	//private Event event;
	public String capsuleInstances;
	private Semaphore sem;
	//public Map<String, List<TableDataMember>> listTableData;
	public int trackerCount;

	public TrackerMaker(Semaphore sem){
		this.sem = sem;
		this.capsuleInstances = "";
	}

	public void run() {
		String name = Thread.currentThread().getName();
			while(true) {
				System.out.print("");
				if (!Server.eventQueue.isEmpty()) {
					//System.out.println("--->");
					Event eventTmp;
					try {
						eventTmp = getQueueEvent();
						enqueue(eventTmp);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				}
				
				//--
				//Showing received events from the notifier
				//Runnable task0 = () -> {
				//	System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
					//System.out.println(name+" ---->processed: "+msg.allDataToString());
				//};


				//System.out.println("Submitting the tasks for execution...");
				//executorService.submit(task0);
				//executorService.submit(task1);

			}//while(true)
		//}//synchronized
	}//run()
	
	public Event getQueueEvent() throws InterruptedException {
		sem.acquire();
		Event event = Server.eventQueue.remove();
		sem.release(); 
		return event;
	}

	public void enqueue(Event msg) {
		
		if (!capsuleInstances.contains(msg.getCapsuleInstance())) {
			capsuleInstances = capsuleInstances + ", " + msg.getCapsuleInstance();
			Queue eventQueue = new LinkedList<Event>();
			List<TableDataMember> listTableDataMember =  new ArrayList<TableDataMember>();
			//System.out.println("---> listTableData.size(): "+Controller.listTableData.size());
			for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {
				
				if (entry.getKey().contains(msg.getCapsuleInstance())) {
					listTableDataMember = entry.getValue();
				}
			}
			//System.out.println("Controller.trackers.length: " +msg.getEvent().getCapsuleInstance());
			CapsuleTracker tracker = new CapsuleTracker(msg.getCapsuleInstance(), eventQueue, listTableDataMember);
			tracker.addToQueue(msg);
			Controller.trackers[Controller.trackerCount++] =  tracker;
			System.out.println("- Tracker is created and first event added into the Queue successfully!" );
			System.out.println("[First]-->["+ msg.getCapsuleInstance()+ "]: " + msg.allDataToString());

		}else {
			for (int i = 0; i<Controller.trackerCount;i++) {
				if ((Controller.trackers[i].getCapsuleInstance().contains(msg.getCapsuleInstance()))) {
					Controller.trackers[i].addToQueue(msg);
					System.out.println("-->["+ msg.getCapsuleInstance()+ "]: " + msg.allDataToString());
					break;
				}
			}
		}
	}

}