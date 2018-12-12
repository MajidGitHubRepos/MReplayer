package com.mxgraph.examples.web;

public class Message implements Comparable<Message> {
	private Integer priorityEventCounter;
	private String capsuleName;
	private String itemName;
	public Message(int priorityEventCounter, String capsuleName, String itemName) {
		this.priorityEventCounter = priorityEventCounter;
		this.capsuleName = capsuleName;
		this.itemName = itemName;
	}
	public Message() {
		this(0,null,null);
	}
	public int getPriorityEventCounter() {
		return priorityEventCounter;
	}
	public String getCapsuleName() {
		return capsuleName;
	}
	public String getItemName() {
		return itemName;
	}

	@Override
	public int compareTo(Message msg) {
		return priorityEventCounter.compareTo(msg.getPriorityEventCounter());
	}
	public String makeJSON() {
		return "{\"list\":[\""+capsuleName+"\", \""+ itemName+ "\"]}";
	}
} 