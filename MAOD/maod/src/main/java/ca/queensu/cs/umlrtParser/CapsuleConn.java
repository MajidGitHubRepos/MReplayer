package ca.queensu.cs.umlrtParser;

import java.util.ArrayList;
import java.util.List;

public class CapsuleConn {
	
	private List<String> listPortName_connectorName_PortName_protocolName;
	private String capsuleName;
	private String capsuleInstanceName;
	private List<String> listPortName;
	
	
	public CapsuleConn (String portName_protocolName_connectorName, String capsuleName, String capsuleInstanceName) {
		this.listPortName_connectorName_PortName_protocolName = new ArrayList<String>();
		this.listPortName = new ArrayList<String>();
		this.capsuleInstanceName = capsuleInstanceName;

		this.capsuleName = capsuleName;
	}
	public CapsuleConn() {
		this(null, null, null);
	}

	public void addPortName_connectorName_protocolName(String listPortName_connectorName_PortName_protocolName) {
		this.listPortName_connectorName_PortName_protocolName.add(listPortName_connectorName_PortName_protocolName);
	}

	public void setCapsuleName(String capsuleName) {
		this.capsuleName = capsuleName;
	}
	
	public void setCapsuleInstanceName(String capsuleInstanceName) {
		this.capsuleInstanceName = capsuleInstanceName;
	}
	
	public String getCapsuleInstanceName() {
		return this.capsuleInstanceName;
	}
	
	public void addListPortName(String portName) {
		this.listPortName.add(portName);
	}
	
	public void setPortName_connectorName_protocolName(int i, String PortName_connectorName_PortName_protocolName) {
		this.listPortName_connectorName_PortName_protocolName.set(i,PortName_connectorName_PortName_protocolName);
	}
	
	public List<String> getListPortName() {
		return this.listPortName;
	}
	
	public  List<String> getListPortName_connectorName_PortName_protocolName() {
		return this.listPortName_connectorName_PortName_protocolName;
	}
	
	public String getPortName_connectorName_PortName_protocolName(int i) {
		return this.listPortName_connectorName_PortName_protocolName.get(i);
	}
	
	public String getCapsuleName() {
		return this.capsuleName;
	}
	
	public String allDataToString() {
		return "CapsuleConn [capsuleName= "+capsuleName +", capsuleInstanceName= "+capsuleInstanceName+", listPortName_connectorName_PortName_protocolName= " + listPortName_connectorName_PortName_protocolName+", listPortName= " + listPortName+"]";
	}

}
