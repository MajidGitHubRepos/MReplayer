package com.mxgraph.examples.web;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Message implements Comparable<Message> {
	private Integer priorityEventCounter;
	private String capsuleName;
	private String itemName;
	private HashMap<String, String> vatriablesHashMap;
	
	public Message(int priorityEventCounter, String capsuleName, String itemName) {
		this.priorityEventCounter = priorityEventCounter;
		this.capsuleName = capsuleName;
		this.itemName = itemName;
		this.vatriablesHashMap = new HashMap<String, String>();
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
	public void putToVatriablesHashMap(String key, String value) {
		vatriablesHashMap.put(key, value);
	}
	public HashMap<String, String> getVatriablesHashMap() {
		return vatriablesHashMap;
	}

	@Override
	public int compareTo(Message msg) {
		return priorityEventCounter.compareTo(msg.getPriorityEventCounter());
	}
	public String makeJSON() {
		String result = "{\"traceID\":[\""+capsuleName+"\", \""+ itemName+ "\"";
		
		Iterator iterator = vatriablesHashMap.entrySet().iterator();
		int counter = 0;
		if (iterator.hasNext()) {
			

			result = result+"],\"traceVar\":[";
			while(iterator.hasNext())
			{
				counter++;
				Map.Entry mentry = (Map.Entry) iterator.next();
				result = result+"{\"name\":\""+mentry.getKey()+"\", \"value\": \""+mentry.getValue() +"\"},";
				//System.out.println("["+ counter+"]> (Name): "+ mentry.getKey() + ", (Variable): " + mentry.getValue());
			}
		
			result = result.substring(0, result.length() - 1);
		}
		return result+"]}";
		
	}
} 