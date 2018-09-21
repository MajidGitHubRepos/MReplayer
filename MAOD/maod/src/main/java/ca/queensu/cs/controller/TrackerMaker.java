package ca.queensu.cs.controller;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import ca.queensu.cs.controller.Controller.RunnableImpl;
import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.Server;
import ca.queensu.cs.umlrtParser.TableDataMember;

public class TrackerMaker implements Runnable{

	//private Event event;
	public String capsuleInstances;
	private Semaphore semServer;
	private Semaphore semCapsuleTracker;

	public static Data[] dataArray;
	public static CapsuleTracker capsuleTrackers[];

	public static int trackerCount;
	public static int eventCount;

	public TrackerMaker(Semaphore semServer){
		this.semServer = semServer;
		this.semCapsuleTracker = new Semaphore(1); 
		this.capsuleTrackers = new CapsuleTracker[10];
		this.dataArray = new Data[10];
		this.trackerCount = 0;
		this.eventCount = 0;
		this.capsuleInstances = "";
	}

	public void run() {
		String name = Thread.currentThread().getName();
		//System.out.println("Creating Executor Service with a thread pool of Size 2");
		//ExecutorService executorService = Executors.newFixedThreadPool(1);

		while(true) {
			System.out.print("");
			if (!Server.eventQueue.isEmpty()) {
				//System.out.println("--->");
				Event eventTmp;
				try {
					eventTmp = getEventFromServerQueue();
					enqueue(eventTmp);
					//Thread.currentThread().sleep(1);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



				if (eventCount > 100) { for (int i = 0; i<trackerCount;i++) {capsuleTrackers[i].shutdown();} break;} // only first 100 events are considered! [for testing propose] 

				//--
				//Sample Runnable task1 is in [https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/]

				//System.out.println("Submitting the tasks for execution...");
				//executorService.submit(task0);
			}
			//executorService.submit(task1);

		}//while(true)
		//showdatas();

	}//run()

	public Event getEventFromServerQueue() throws InterruptedException {
		semServer.acquire();
		Event event = Server.eventQueue.take();
		semServer.release(); 
		return event;
	}

	public void enqueue(Event event) throws InterruptedException {

		if (!capsuleInstances.contains(event.getCapsuleInstance())) {
			try {
				this.semCapsuleTracker.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			capsuleInstances = capsuleInstances + ", " + event.getCapsuleInstance();
			BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();

			List<TableDataMember> listTableDataMember =  new ArrayList<TableDataMember>();
			//System.out.println("---> listTableData.size(): "+Controller.listTableData.size());
			for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {

				if (entry.getKey().contains(event.getCapsuleInstance())) {
					listTableDataMember = entry.getValue();
				}
			}
			//System.out.println("Controller.datas.length: " +event.getEvent().getCapsuleInstance());
			Data data = new Data(event.getCapsuleInstance(), eventQueue, listTableDataMember);

			data.addToQueue(event);
			eventCount++;
			//	this.semCapsuleTraker.release(); 
			dataArray[trackerCount] =  data;
			System.out.println("- data is created and first event added into the Queue successfully!" );
			//System.out.println("[First]-->["+ event.getCapsuleInstance()+ "]: " + event.allDataToString());
			CapsuleTracker capsuleTracker = new CapsuleTracker(semCapsuleTracker, event.getCapsuleInstance());
			Thread capsuleTrackerT = new Thread(capsuleTracker); 
			capsuleTrackerT.start(); 
			capsuleTrackers[trackerCount++] = capsuleTracker;
			this.semCapsuleTracker.release(); 

		}else {
			for (int i = 0; i<trackerCount;i++) {
				if ((dataArray[i].getCapsuleInstance().contains(event.getCapsuleInstance()))) {
					dataArray[i].addToQueue(event);
					eventCount++;
					//System.out.println("-->["+ event.getCapsuleInstance()+ "]: " + event.allDataToString());
					break;
				}
			}
		}
	}//enqueue

	public void showdatas() {
		for (int i = 0; i< trackerCount; i++) {
			System.out.println("--> dataArray["+i+"]: " + dataArray[i].allDataToString());
		}
	}


}