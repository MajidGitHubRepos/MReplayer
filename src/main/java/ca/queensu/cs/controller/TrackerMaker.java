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

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

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
	

	public static int trackerCount;
	public static int priorityEventCounter;
	public static int eventCount;
	public static OutputStream outputFileStream;
	public static int[] logicalVectorTime;
	private int MAX_NUM_CAPSULE;
	private static int MAX_NUM_POLICY;
	private static List<String[]> listPolicies;
	public static boolean checkPolicy;
	public static HashMap<String, String> capsulePathsMap;

	
	public TrackerMaker(Semaphore semServer, int numberOfCapsules){
		this.MAX_NUM_POLICY = 2; //Maximum number of entities in the policy chain
		this.capsulePathsMap =  new HashMap<String, String>();
		this.MAX_NUM_CAPSULE = numberOfCapsules;
		this.semServer = semServer;
		this.semCapsuleTracker = new Semaphore(1); 
		this.capsuleTrackers = new CapsuleTracker[MAX_NUM_CAPSULE];
		this.dataArray = new Data[MAX_NUM_CAPSULE];
		this.trackerCount = 0;
		this.priorityEventCounter = 0;
		this.eventCount = 0;
		this.capsuleInstances__indexes = "";

			try {
	    		System.out.println("=================================================[Output/Policy files]========================================");
	    		System.out.println("==============[ADDRESS:> workspace/model_aware_event_ordering/target/classes/input_output_Files]==============");

	    		ClassLoader classLoader = getClass().getClassLoader();
	    		//String outputFileName = "input_output_Files/output.txt";
	    		String outputFileDir = "input_output_Files";
	    		File outputFile = new File(classLoader.getResource(outputFileDir).getFile()+"/output.txt");
	    		// ADDRESS: workspace/model_aware_event_ordering/target/classes/input_output_Files
	    		outputFile.createNewFile(); // if file already exists will do nothing 
	    		System.out.println("\n["+ Thread.currentThread().getName() +"]> outputFile exists in : "+ outputFile.getAbsolutePath());
				this.outputFileStream = new FileOutputStream(outputFile,false);
				//-----------
				
	    		//String policyFileName = "input_output_Files/policy.txt";
	    		File policyFile = new File(classLoader.getResource(outputFileDir).getFile()+"/policy.txt");
	    		policyFile.createNewFile(); // if file already exists will do nothing 
	    		this.listPolicies = UmlrtUtils.readListPolicies(policyFile.getAbsolutePath().toString());
	    		if (this.listPolicies.size() == 0) {
		    		System.out.println("["+ Thread.currentThread().getName() +"]> NO Policy defined in : "+ outputFile.getAbsolutePath());
		    		this.checkPolicy = false;
	    		}else {
		    		System.out.println("["+ Thread.currentThread().getName() +"]> <<"+ this.listPolicies.size() +">> Policy/Policies defined in : "+ policyFile.getAbsolutePath());
		    		this.checkPolicy = true; //e.g: bank,controller,cashDispenser
	    		}
	    		System.out.println("\n============================================================================================================");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("===[FileNotFoundException]===");
				System.err.println("=====[PROGRAM TERMINATED]=====");
				System.exit(0);
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("===[IOException]===");
				System.err.println("=====[PROGRAM TERMINATED]=====");
				System.exit(0);
				e.printStackTrace();
			}
		
	}

	public void run() {
		String name = Thread.currentThread().getName();
		//System.out.println("Creating Executor Service with a thread pool of Size 2");
		//ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		//Make capsuleTrackers 
		//TODO this block of code initiates set of CapsuleTrackers for the model [LATER CAN BE REPLACED WITH THE CURRENT METHOD]
		//=================================================================================================================
		/*
		for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {

			if (!entry.getKey().isEmpty()) {
				String capInstances = entry.getKey();
				capInstances = capInstances.replaceAll("\\s+","");
				String [] splitCapInstances = capInstances.split("\\,");
				for (int q = 0; q<splitCapInstances.length; q++) {
					this.logicalVectorTime = new int[MAX_NUM_CAPSULE]; 
					
					BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();

					List<TableDataMember> listTableDataMember =  new ArrayList<TableDataMember>();
					//System.out.println("---> listTableData.size(): "+Controller.listTableData.size());
					for (Map.Entry<String, List<TableDataMember>> entry2  : Controller.listTableData.entrySet()) {

						if (entry.getKey().contains(splitCapInstances[q])) { // no need to change capsuleInstances__capsuleIndex because listTableDataMembers are identical 
							listTableDataMember = entry2.getValue();
							break;
						}
					}
					
					Data data = new Data(splitCapInstances[q], eventQueue, listTableDataMember);
					dataArray[q] =  data;
					CapsuleTracker capsuleTracker = new CapsuleTracker(semCapsuleTracker, splitCapInstances[q], outputFileStream, logicalVectorTime); 
					Thread capsuleTrackerT = new Thread(capsuleTracker); 
					capsuleTrackerT.start(); 
					capsuleTrackers[q] = capsuleTracker;					
				}
				
			}
		
		}
		//=================================================================================================================
		*/

		while(true) {
			/*if (TrackerMaker.priorityEventCounter>1000) {
				System.err.println("=====================================[EXPERIMENT DONE]======================================");
				 System.exit(0);
			}*/
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
			System.out.println("***************************> event.getCapsuleInstance(): "+event.getCapsuleInstance());
			System.out.println("***************************> capsuleInstance__capsuleIndex: "+capsuleInstance__capsuleIndex);


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
			// listPolicies given to the capsuleTracker to check consumable event with the policy
			CapsuleTracker capsuleTracker = new CapsuleTracker(semCapsuleTracker, capsuleFullname, outputFileStream, logicalVectorTime); 
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
						capsuleFullname = capsuleFullname.replaceAll("\\s+",""); // remove spaces
						
						String tmpCapsuleInstances__capsuleIndex = Controller.capInstIdxMap.get(capsuleFullname);
						
						if (tmpCapsuleInstances__capsuleIndex == null) { //does not exist!
						    capsuleFullname = capsuleFullname.replaceAll("\\s+","");
						    Controller.capInstIdxMap.put(capsuleFullname, capsuleInstance__capsuleIndex);
							break;
							
						} else {
						    // exists such key
							//System.out.println("-->For "+capsuleFullname+" EXIST "+ tmpCapsuleInstances__capsuleIndex);
						}
					}
				}else {
					//NoLoop
					String  capsuleFullname = entry.getKey();
					capsuleFullname.replaceAll("\\s+",""); // remove spaces
					
					String tmpCapsuleInstances__capsuleIndex = Controller.capInstIdxMap.get(capsuleFullname);
					
					if (tmpCapsuleInstances__capsuleIndex == null) { //does not exist!
					    capsuleFullname = capsuleFullname.replaceAll("\\s+","");
					    Controller.capInstIdxMap.put(capsuleFullname, capsuleInstance__capsuleIndex);
						
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
		for (Map.Entry<String, String> entry  : Controller.capInstIdxMap.entrySet()) {
			if(entry.getValue().contains(capsuleInstance__capsuleIndex)) {
				String capfullName = entry.getKey().replaceAll("\\s+","");
				return capfullName;
			}
		}
		System.err.println("==================[__capsuleFullNameNotFound__]["+capsuleInstance__capsuleIndex+"]======================");
		return "";
		
	}

	//==================================================================	
	//==============================================[showCapInstIdxMap]
	//==================================================================			

	public void showCapInstIdxMap()  
	{
		System.out.println("=======================[capInstIdxMap]==========================");
		for (Map.Entry<String, String> entry  : Controller.capInstIdxMap.entrySet()) {
			//if (entry.getKey().contains(event.getCapsuleInstance())) { 
			System.out.println("["+ Thread.currentThread().getName() +"]+++>[entry.getKey()] : "+ entry.getKey()+" [entry.getValue()] : "+entry.getValue());
			//}
		}
		System.out.println("====================================================================");

	}

	//==================================================================	
	//==============================================[checkPolicyViolation]
	//==================================================================			

	public static boolean checkPolicyViolation(String capsuleInstance, Event event)  
	{
		boolean result = false; //policy respected! //TODO: too much optimistic assumption
		String requirement = "";
		
		for (Map.Entry<String, String> entry  : capsulePathsMap.entrySet()) {
			if (entry.getKey().contentEquals(capsuleInstance)) {
				String [] currPathArr = entry.getValue().split("\\,");
				System.out.println("["+ Thread.currentThread().getName() +"]===================> [capsuleInstance]: "+ capsuleInstance +" [PATH]: "+ entry.getValue());
				//Arbitrary security policy can be applied here on the received event
				
				// looking for the requirement in listPolices
				for(int i = 0; i < listPolicies.size();i++) {
					String [] policies = listPolicies.get(i);
					for (int j = 0; j < policies.length ;j++) {
						if ((capsuleInstance.contains(policies[j])) && (j > 0)){
							requirement = policies[j-1];
							break;
						}
					}
					if (requirement != "")
						break;
				}
				
				//Check Happen-Before rule
				// TODO: only internal Happen-Before relationship supported in this version
				if (requirement != "") {
					int lastIndexOf_ = capsuleInstance.lastIndexOf("__");
					String rootName = capsuleInstance.substring(0, lastIndexOf_);
					
					for (Map.Entry<String, String> entryPath  : capsulePathsMap.entrySet()) {
						if ((entryPath.getKey().contains(rootName)) && (entryPath.getKey().contains(requirement))) {
							//check security policy
							String [] pathArr = entryPath.getValue().split("\\,");
							if (pathArr.length == 0) { //assumption: if pathArr.length > 0 then required capsule is being sent or has been done! 
								//requirement has not met!
								result = true;
								System.out.println("["+ Thread.currentThread().getName() +"]*****************> [rootName]: "+ rootName +" [requirement]: "+ requirement);
								System.out.println("["+ Thread.currentThread().getName() +"]*****************> [capsuleInstance]: "+ capsuleInstance +" [BAD PATH]: "+ entryPath.getValue());

								break;
							}
						}
					}
				}
			}
		}
		
		return result;

	}

	//==================================================================	
	//==============================================[addCapsulePaths]
	//==================================================================			

	public static boolean addCapsulePaths(String capsuleInstance, Event event)  
	{
		for (Map.Entry<String, String> entry  : capsulePathsMap.entrySet()) {
			if (entry.getKey().contentEquals(capsuleInstance)) {
				String currPath = entry.getValue();
				// check MAX_NUM_POLICY to avoid memory overflow
				String [] currPathArr = currPath.split("\\,");
				if (currPathArr.length > MAX_NUM_POLICY) {
					currPath = event.getSourceKind()+"_"+event.getType()+"_"+event.getCapsuleInstance()+"_"+event.getCapsuleIndex();
				} else {
				currPath = currPath + ","+event.getSourceKind()+"_"+event.getType()+"_"+event.getCapsuleInstance()+"_"+event.getCapsuleIndex();
				}
				capsulePathsMap.put(entry.getKey(),currPath);
				return true;
			}
		}
	
		capsulePathsMap.put(capsuleInstance, event.getSourceKind()+"_"+event.getType()+"_"+event.getCapsuleInstance()+"_"+event.getCapsuleIndex());
		return false;
	}
}