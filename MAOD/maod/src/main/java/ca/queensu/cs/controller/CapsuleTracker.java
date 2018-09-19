package ca.queensu.cs.controller;

import java.util.List;
import java.util.Queue;

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
	

}
