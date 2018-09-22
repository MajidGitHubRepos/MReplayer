package ca.queensu.cs.umlrtParser;

import java.util.ArrayList;
import java.util.List;

public class CapsuleConn {
	
	private List<String> listPortName_protocolName_connectorName;
	private String capsuleName;
	
	
	public CapsuleConn (String portName_protocolName_connectorName, String capsuleName) {
		this.listPortName_protocolName_connectorName = new ArrayList<String>();
		this.capsuleName = capsuleName;
	}
	public CapsuleConn() {
		this(null, null);
	}

	public void addPortName_connectorName_protocolName(String portName_protocolName_connectorName) {
		this.listPortName_protocolName_connectorName.add(portName_protocolName_connectorName);
	}

	
	public void setCapsuleName(String capsuleName) {
		this.capsuleName = capsuleName;
	}
	
	public void setPortName_connectorName_protocolName(int i, String portName_protocolName_connectorName) {
		this.listPortName_protocolName_connectorName.set(i,portName_protocolName_connectorName);
	}
	
	public  List<String> getListPortName_connectorName_protocolName() {
		return this.listPortName_protocolName_connectorName;
	}
	
	public String getPortName_connectorName_protocolName(int i) {
		return this.listPortName_protocolName_connectorName.get(i);
	}
	
	public String getCapsuleName() {
		return this.capsuleName;
	}
	
	public String allDataToString() {
		return "CapsuleConn [capsuleName= "+capsuleName+", listPortName_protocolName_connectorName= " + listPortName_protocolName_connectorName+"]";
	}

}
