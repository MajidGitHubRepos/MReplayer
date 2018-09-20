package ca.queensu.cs.controller;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.Server;
import ca.queensu.cs.server.Server.RunnableImpl;
import ca.queensu.cs.umlrtParser.TableDataMember;
import ca.queensu.cs.umlrtParser.UmlrtParser;

public class Controller {

	private OrderingEngine orderingEngine;
	public static UmlrtParser umlrtParser;
	public static Server server;
	public static Event event;
	public static CapsuleTracker[] trackers;
	public static int trackerCount;
	public static Semaphore sem;
	public static Map<String, List<TableDataMember>> listTableData;

	public Controller() {
		this.sem = new Semaphore(1); 
		this.trackers = new CapsuleTracker[10];
		this.trackerCount = 0;
		Event event = new Event();
		umlrtParser = new UmlrtParser();
		this.listTableData = null;
		try {
			server = new Server("127.0.0.1",8001, sem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//for(int i = 0; i<Controller.trackers.length;i++) {if (Controller.trackers[i].getCapsuleInstance() != null) this.trackerCount++;}
	}

	
	public static void main(String[] args) throws IOException 
	{
		Thread controllerT = new Thread(new Controller().new RunnableImpl()); 
		controllerT.start(); 
		//--------------------------------------------------------------------------
		Thread umlrtParserT = new Thread(umlrtParser.new RunnableImpl()); 
		umlrtParserT.start();
		//--------------------------------------------------------------------------
		Thread serverT = new Thread(server.new RunnableImpl()); 
		serverT.start(); 
		//--------------------------------------------------------------------------

	}

	public class RunnableImpl implements Runnable { 

		public void run() {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<[Starting CapsuleTracker Process]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
			System.out.println("Waiting for the UmlrtParsing thread complete the process ....");
			while (true) {if (umlrtParser.getUmlrtParsingDone()) break; else System.out.print(""); }
			System.out.println("\n\n<<<<<<<<<<<<<<<[Parsing process has been completed successfully]>>>>>>>>>>>>>>>>>\n --> umlrtParser.getlistTableData():" +  umlrtParser.getlistTableData());
			
			Controller.listTableData = umlrtParser.getlistTableData();
			//Message msg = new Message("process it", event);
			TrackerMaker waiter = new TrackerMaker(sem);
			new Thread(waiter,"waiter").start();
			//Notifier notifier = new Notifier(msg, Controller.sem);
			//new Thread(notifier, "notifier").start();

			orderingEngine = new OrderingEngine(umlrtParser.getlistTableData());
			Thread orderingEngineT = new Thread(orderingEngine);

			orderingEngineT.start();
			orderingEngineT.interrupt();
			try {
				orderingEngineT.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}