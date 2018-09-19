package ca.queensu.cs.controller;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.io.IOException;
import java.util.concurrent.Semaphore;

import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.Server;
import ca.queensu.cs.server.Server.RunnableImpl;
import ca.queensu.cs.umlrtParser.UmlrtParser;

public class Controller {

	private OrderingEngine orderingEngine;
	public static UmlrtParser umlrtParser;
	public static Server server;
	public static Event event;

	public Controller() {
		Semaphore sem = new Semaphore(1); 
		Event event = new Event();
		umlrtParser = new UmlrtParser();
		try {
			server = new Server("127.0.0.1",8001, sem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Message msg = new Message("process it", event);
		Waiter waiter = new Waiter(msg, umlrtParser.getlistTableData());
		new Thread(waiter,"waiter").start();
		Notifier notifier = new Notifier(msg, sem);
		new Thread(notifier, "notifier").start();
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
			System.out.println("\n\n<<<<<<<<<<<<<<<[Parsing process has been completed successfully]>>>>>>>>>>>>>>>>>\n");

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
