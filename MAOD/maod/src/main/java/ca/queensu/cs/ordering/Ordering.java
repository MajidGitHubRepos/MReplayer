package ca.queensu.cs.ordering;

import java.io.IOException;

import ca.queensu.cs.server.Server;
import ca.queensu.cs.umlrtParser.UmlrtParser;

public class Ordering {
	
	private OrderingEngine orderingEngine;
	public static UmlrtParser umlrtParser;
	public static Server server;
	
	public Ordering() {
		umlrtParser = new UmlrtParser();
		try {
			server = new Server("127.0.0.1",8001);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException 
    {
		Thread orderingT = new Thread(new Ordering().new RunnableImpl()); 
        orderingT.start(); 
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
	    	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<[Starting Ordering Process]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
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
