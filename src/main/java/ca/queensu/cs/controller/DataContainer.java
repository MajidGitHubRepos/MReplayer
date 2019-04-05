package ca.queensu.cs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.Server;
import ca.queensu.cs.umlrtParser.TableDataMember;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */



public class DataContainer {
	
	private String capsuleInstance;
	public BlockingQueue <Event> eventQueue;
	public BlockingQueue <Message> messageQueue;
	public Map<String, String> mapRegionCurrentState;
	private Thread thread;
	private Event currentEvent;
	
	//private String threadName;
	//--
	public DataContainer(String capsuleInstance, BlockingQueue <Event> eventQueue, BlockingQueue <Message> messageQueue) {
		this.mapRegionCurrentState =  new HashMap<String, String>();
		this.capsuleInstance = capsuleInstance;
		this.eventQueue = eventQueue;
		this.messageQueue = messageQueue;
	}
	//--
	public DataContainer() {
		this(null, null, null);
	}
	
	  
	//--GETTERS
	public String getCapsuleInstance() {
		return this.capsuleInstance;
	}
	public Queue getEventQueue() {
		return this.eventQueue;
	}

	//--SETTERS
	public void setCapsuleInstance(String capsuleInstance ) {
		this.capsuleInstance = capsuleInstance;
	}
	public void setEventToEventQueue(Event event) throws InterruptedException {
		this.eventQueue.put(event);
	}
	public void setEventQueue(BlockingQueue <Event> eventQueue) {
		this.eventQueue = eventQueue;
	}
	
	public String allDataToString() {
		return "TableDataMember [capsuleInstance=" + capsuleInstance + ", eventQueue=" + eventQueue +"]";
	}
	

}
