package ca.queensu.cs.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import ca.queensu.cs.server.Event;
import ca.queensu.cs.umlrtParser.TableDataMember;

public class Waiter implements Runnable{

	//private Event event;
	private Message msg;
	public String capsuleInstances;
	//public Map<String, List<TableDataMember>> listTableData;
	public int trackerCount;

	public Waiter(Message msg){
		this.msg=msg;
		this.capsuleInstances = "";
	}

	public void run() {
		String name = Thread.currentThread().getName();
		//System.out.println("Creating Executor Service with a thread pool of Size 5");
		//ExecutorService executorService = Executors.newFixedThreadPool(1);


		synchronized (msg) {

			while(true) {
				try{
					//System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
					msg.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				//System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
				//process the message now
				enqueue(msg);
				
				//--
				//Showing received events from the notifier
				Runnable task0 = () -> {
					System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
					System.out.println(name+" ---->processed: "+msg.getEvent().allDataToString());
				};


				//System.out.println("Submitting the tasks for execution...");
				//executorService.submit(task0);
				//executorService.submit(task1);

			}//while(true)
		}//synchronized
	}//run()

	public void enqueue(Message msg) {
		if (!capsuleInstances.contains(msg.getEvent().getCapsuleInstance())) {
			capsuleInstances = capsuleInstances + ", " + msg.getEvent().getCapsuleInstance();
			Queue eventQueue = new LinkedList<Event>();
			List<TableDataMember> listTableDataMember =  new ArrayList<TableDataMember>();
			//System.out.println("---> listTableData.size(): "+Controller.listTableData.size());
			for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {
				
				if (entry.getKey().contains(msg.getEvent().getCapsuleInstance())) {
					listTableDataMember = entry.getValue();
				}
			}
			//System.out.println("Controller.trackers.length: " +msg.getEvent().getCapsuleInstance());
			CapsuleTracker tracker = new CapsuleTracker(msg.getEvent().getCapsuleInstance(), eventQueue, listTableDataMember);
			tracker.addToQueue(msg.getEvent());
			Controller.trackers[Controller.trackerCount++] =  tracker;
			System.out.println("- Tracker is created and first event added into the Queue successfully!" );
			System.out.println("[First]-->["+ msg.getEvent().getCapsuleInstance()+ "]: " + msg.getEvent().allDataToString());

		}else {
			for (int i = 0; i<Controller.trackerCount;i++) {
				if ((Controller.trackers[i].getCapsuleInstance().contains(msg.getEvent().getCapsuleInstance()))) {
					Controller.trackers[i].addToQueue(msg.getEvent());
					System.out.println("-->["+ msg.getEvent().getCapsuleInstance()+ "]: " + msg.getEvent().allDataToString());
					break;
				}
			}
		}
	}

}
