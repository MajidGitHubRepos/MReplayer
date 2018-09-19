package ca.queensu.cs.controller;

import java.util.List;
import java.util.Queue;

import ca.queensu.cs.server.Event;
import ca.queensu.cs.umlrtParser.TableDataMember;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */



public class CapsuleTracker {
	
	private String capsuleInstance;
	private Queue eventQueue;
	private String currentStatus;
	private List<TableDataMember> tableData;
	//--
	public CapsuleTracker(String capsuleInstance, Queue eventQueue, List<TableDataMember> tableData) {
		this.capsuleInstance = capsuleInstance;
		this.eventQueue = eventQueue;
		this.tableData = tableData;
		this.currentStatus = "Init";
	}
	//--
	public CapsuleTracker() {
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
	//--SETTERS
	public void setCapsuleInstance(String capsuleInstance ) {
		this.capsuleInstance = capsuleInstance;
	}
	public void setEventQueue(Queue eventQueue) {
		this.eventQueue = eventQueue;
	}
	public void getCurrentStatus(String currentStatus ) {
		this.currentStatus = currentStatus;
	}
	public void getTableData(List<TableDataMember> tableData) {
		this.tableData = tableData;
	}
	
	public void addToQueue(Event event) {
		this.eventQueue.add(event);
	}
	
	public String allDataToString() {
		return "TableDataMember [capsuleInstance=" + capsuleInstance + ", eventQueue=" + eventQueue + ", currentStatus= "+ currentStatus + ", tableData=" + tableData +"]";
	}

}
