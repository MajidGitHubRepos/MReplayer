package ca.queensu.cs.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.util.ArrayList;
import java.util.HashMap;
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
import ca.queensu.cs.umlrtParser.UmlrtUtils;

public class TrackerMaker implements Runnable{

	//private Event event;
	public String capsuleInstances__indexes;
	private Semaphore semServer;
	private Semaphore semCapsuleTracker;

	public static Data[] dataArray;
	public static CapsuleTracker capsuleTrackers[];
	public static HashMap<String, String> capInstIdxMap;

	public static int trackerCount;
	public static int eventCount;
	public static OutputStream os;
	public static int[] logicalVectorTime;
	private int MAX_NUM_CAPSULE;
	
	public TrackerMaker(Semaphore semServer, int numberOfCapsules){
		this.MAX_NUM_CAPSULE = numberOfCapsules;
		this.capInstIdxMap = new HashMap<String, String>();
		this.semServer = semServer;
		this.semCapsuleTracker = new Semaphore(1); 
		this.capsuleTrackers = new CapsuleTracker[MAX_NUM_CAPSULE];
		this.dataArray = new Data[MAX_NUM_CAPSULE];
		this.trackerCount = 0;
		this.eventCount = 0;
		this.capsuleInstances__indexes = "";

			try {
				this.os = new FileOutputStream(new File("/home/majid/workspace/matd/MAOD/maod/src/main/resources/outputFiles/output.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
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



				//if (eventCount > 300) { for (int i = 0; i<trackerCount;i++) {capsuleTrackers[i].shutdown();} break;} // only first 100 events are considered! [for testing propose] 

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
		//semServer.acquire(); //blockingQueue can handle that with an internal semaphore
		Event event = Server.eventQueue.take();
		//semServer.release(); 
		return event;
	}

	public void enqueue(Event event) throws InterruptedException {
		//System.out.println("\n\n\n["+ Thread.currentThread().getName() +"]+++>[event] : "+ event.allDataToString());
		String capsuleInstance__capsuleIndex = event.getCapsuleInstance() + "__" + event.getCapsuleIndex();
		//System.out.println("["+ Thread.currentThread().getName() +"]+++>[capsuleInstance__capsuleIndex] : "+ capsuleInstance__capsuleIndex+" [capsuleInstances__indexes] : "+capsuleInstances__indexes);

		if (!capsuleInstances__indexes.contains(capsuleInstance__capsuleIndex)) {
			try {
				this.semCapsuleTracker.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Mapping
			mappingCapInstanceIdxToCapfullName(event.getCapsuleInstance(),capsuleInstance__capsuleIndex);
			
			
			//showCapInstIdxMap();
			

			capsuleInstances__indexes = capsuleInstances__indexes + ", " + capsuleInstance__capsuleIndex;
			//System.out.println("\n\n\n["+ Thread.currentThread().getName() +"]====>[capsuleInstances__capsuleIndex] : "+ event.getCapsuleInstance() + "__" + event.getCapsuleIndex());
			
			BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();

			List<TableDataMember> listTableDataMember =  new ArrayList<TableDataMember>();
			//System.out.println("---> listTableData.size(): "+Controller.listTableData.size());
			for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {

				if (entry.getKey().contains(event.getCapsuleInstance())) { // no need to change capsuleInstances__capsuleIndex because listTableDataMembers are identical 
					listTableDataMember = entry.getValue();
				}
			}
			//System.out.println("Controller.datas.length: " +event.getEvent().getCapsuleInstance());
			//CapFullname
			String capsuleFullname = findCapfullNameByCapInstanceIdx(capsuleInstance__capsuleIndex);
			Data data = new Data(capsuleFullname, eventQueue, listTableDataMember);

			data.addToQueue(event);
			eventCount++;
			//	this.semCapsuleTraker.release(); 
			dataArray[trackerCount] =  data;
			System.out.println("- data is created and first event added into the Queue successfully!" );
			//System.out.println("[First]-->["+ event.getCapsuleInstance()+ "]: " + event.allDataToString());
			this.logicalVectorTime = new int[MAX_NUM_CAPSULE]; //default value of 0 for arrays of integral types is guaranteed by the language spec
			CapsuleTracker capsuleTracker = new CapsuleTracker(semCapsuleTracker, capsuleFullname, os, logicalVectorTime);
			Thread capsuleTrackerT = new Thread(capsuleTracker); 
			capsuleTrackerT.start(); 
			capsuleTrackers[trackerCount++] = capsuleTracker;
			this.semCapsuleTracker.release(); 

		}else {
			for (int i = 0; i<trackerCount;i++) {
				if ((dataArray[i].getCapsuleInstance().contains(findCapfullNameByCapInstanceIdx(capsuleInstance__capsuleIndex)))) {
					dataArray[i].addToQueue(event);
					eventCount++;
					//System.out.println("-->["+ event.getCapsuleInstance()+ "]: " + event.allDataToString());
					break;
				}
			}
		}
	}//enqueue
	//==================================================================	
	//==============================================[showdatas]
	//==================================================================			

	public void showdatas() {
		for (int i = 0; i< trackerCount; i++) {
			System.out.println("--> dataArray["+i+"]: " + dataArray[i].allDataToString());
		}
	}
	
	//==================================================================	
	//==============================================[mappingCapInstanceIdxToCapfullName]
	//==================================================================			

	public void mappingCapInstanceIdxToCapfullName(String capsuleInstance, String capsuleInstance__capsuleIndex)  
	{
		for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {

			if (entry.getKey().contains(capsuleInstance)) {
				if (entry.getKey().contains(",")) {
					
					String [] spiltCapsuleFullname = entry.getKey().split("\\,");
					
					for (int i = 0; i<spiltCapsuleFullname.length;i++) {
						String capsuleFullname = spiltCapsuleFullname[i]; //get FullName
						capsuleFullname.replaceAll("\\s+",""); // remove spaces
						
						String tmpCapsuleInstances__capsuleIndex = capInstIdxMap.get(capsuleFullname);
						
						if (tmpCapsuleInstances__capsuleIndex == null) { //does not exist!
						    capsuleFullname = capsuleFullname.replaceAll("\\s+","");
							capInstIdxMap.put(capsuleFullname, capsuleInstance__capsuleIndex);
							break;
							
						} else {
						    // exists such key
						}
					}
				}else {
					//NoLoop
					String  capsuleFullname = entry.getKey();
					capsuleFullname.replaceAll("\\s+",""); // remove spaces
					
					String tmpCapsuleInstances__capsuleIndex = capInstIdxMap.get(capsuleFullname);
					
					if (tmpCapsuleInstances__capsuleIndex == null) { //does not exist!
					    capsuleFullname = capsuleFullname.replaceAll("\\s+","");
						capInstIdxMap.put(capsuleFullname, capsuleInstance__capsuleIndex);
						
					} else {
					    // exists such key
					}			
				}
				break;
			}
		}
	}
	
	//==================================================================	
	//==============================================[findCapfullNameByCapInstanceIdx]
	//==================================================================			

	public String findCapfullNameByCapInstanceIdx (String capsuleInstance__capsuleIndex)  
	{
		for (Map.Entry<String, String> entry  : capInstIdxMap.entrySet()) {
			if(entry.getValue().contains(capsuleInstance__capsuleIndex)) {
				String capfullName = entry.getKey().replaceAll("\\s+","");
				return capfullName;
			}
		}
		System.err.println("==================[__capsuleFullNameNotFound__]======================");
		return "";
		
	}

	//==================================================================	
	//==============================================[showCapInstIdxMap]
	//==================================================================			

	public void showCapInstIdxMap()  
	{
		System.out.println("=======================[capInstIdxMap]==========================");
		for (Map.Entry<String, String> entry  : capInstIdxMap.entrySet()) {
			//if (entry.getKey().contains(event.getCapsuleInstance())) { 
			System.out.println("["+ Thread.currentThread().getName() +"]+++>[entry.getKey()] : "+ entry.getKey()+" [entry.getValue()] : "+entry.getValue());
			//}
		}
		System.out.println("====================================================================");

	}


}