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



public class Data {
	
	private String capsuleInstance;
	private BlockingQueue <Event> eventQueue;
	private String currentStatus;
	private List<TableDataMember> tableData;
	private Thread thread;
	private Event currentEvent;
	//private String threadName;
	//--
	public Data(String capsuleInstance, BlockingQueue <Event> eventQueue, List<TableDataMember> tableData) {
		this.capsuleInstance = capsuleInstance;
		this.eventQueue = eventQueue;
		this.tableData = tableData;
		this.currentStatus = null;
	}
	//--
	public Data() {
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
	public List<TableDataMember> getTableData() {
		return this.tableData;
	}
	public Event getFromQueue() throws InterruptedException {
		return this.eventQueue.take();
	}
	//--SETTERS
	public void setCapsuleInstance(String capsuleInstance ) {
		this.capsuleInstance = capsuleInstance;
	}
	public void setEventQueue(BlockingQueue <Event> eventQueue) {
		this.eventQueue = eventQueue;
	}
	public void getCurrentStatus(String currentStatus ) {
		this.currentStatus = currentStatus;
	}
	public void getTableData(List<TableDataMember> tableData) {
		this.tableData = tableData;
	}
	
	public void addToQueue(Event event) throws InterruptedException {
		this.eventQueue.put(event);
	}
	
	public String allDataToString() {
		return "TableDataMember [capsuleInstance=" + capsuleInstance + ", eventQueue=" + eventQueue + ", currentStatus= "+ currentStatus + ", tableData=" + tableData +"]";
	}
	

}
