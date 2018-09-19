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
	public Map<String, List<TableDataMember>> listTableData;
	public CapsuleTracker[] trackers;
	public int trackerCount;

	public Waiter(Message msg, Map<String, List<TableDataMember>> listTableData){
		this.msg=msg;
		this.capsuleInstances = "";
		this.listTableData = listTableData;
		this.trackers = new CapsuleTracker[10];
		trackerCount = 0;
	}

	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Creating Executor Service with a thread pool of Size 5");
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		

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
				//System.out.println(name+" ---->processed: "+msg.getEvent().allDataToString());


				//Showing received events from the notifier
				Runnable task0 = () -> {
					System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
					System.out.println(name+" ---->processed: "+msg.getEvent().allDataToString());
				};
				
				//Making Queue for each capsuleInstance
				Runnable task1 = () -> {
					if (!capsuleInstances.contains(msg.getEvent().getCapsuleInstance())) {
						capsuleInstances = capsuleInstances + ", " + msg.getEvent().getCapsuleInstance();
						Queue eventQueue = new LinkedList<Event>();
						List<TableDataMember> listTableDataMember =  new ArrayList<TableDataMember>();
						for (Map.Entry<String, List<TableDataMember>> entry  : listTableData.entrySet()) {
							//System.out.println("---> entry.getKey(): "+entry.getKey());
							if (entry.getKey() == capsuleInstances) {
								listTableDataMember = entry.getValue();
							}
						}
						CapsuleTracker tracker = new CapsuleTracker(capsuleInstances, eventQueue, listTableDataMember);
						trackers[trackerCount++] =  tracker;
						System.out.println("- Tracker is created successfully!");
					}
				};

				//System.out.println("Submitting the tasks for execution...");
				//executorService.submit(task0);
				executorService.submit(task1);
				
			}//while(true)
		}//synchronized
	}//run()

}
