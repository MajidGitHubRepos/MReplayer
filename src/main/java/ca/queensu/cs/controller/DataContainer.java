package ca.queensu.cs.controller;

import java.util.List;
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
	private String currentStatus;
	private Thread thread;
	private Event currentEvent;
	//private String threadName;
	//--
	public DataContainer(String capsuleInstance, BlockingQueue <Event> eventQueue, BlockingQueue <Message> messageQueue) {
		this.capsuleInstance = capsuleInstance;
		this.eventQueue = eventQueue;
		this.messageQueue = messageQueue;
		this.currentStatus = null;
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
	public String getCurrentStatus() {
		return this.currentStatus;
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
	public void getCurrentStatus(String currentStatus ) {
		this.currentStatus = currentStatus;
	}
	
	public String allDataToString() {
		return "TableDataMember [capsuleInstance=" + capsuleInstance + ", eventQueue=" + eventQueue + ", currentStatus= "+ currentStatus  +"]";
	}
	

}
