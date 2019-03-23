package ca.queensu.cs.umlrtParser;

import org.eclipse.uml2.uml.State;

public class MyConnector {
	public String capInstanceName1;
	public String capInstanceName2;
	public String portCap1;
	public String portCap2;
	public String protocolName;
	public Boolean bhvPortCap1;
	public Boolean bhvPortCap2;
	public String connectorName;
	
	
	public MyConnector(String capInstanceName1, String portCap1, Boolean bhvPortCap1, String capInstanceName2, String portCap2, Boolean bhvPortCap2, String protocolName, String connectorName) {
		this.capInstanceName1 = capInstanceName1;
		this.capInstanceName2 = capInstanceName2;
		this.portCap1 = portCap1;
		this.portCap2 = portCap2;
		this.protocolName = protocolName;
		this.bhvPortCap1 = bhvPortCap1;
		this.bhvPortCap2 = bhvPortCap2;
		this.connectorName = connectorName;
	}
	
	public MyConnector() {
		this(null, null, null, null, null, null, null, null);
	}

	
	public String allDataToString() {
		return ", Event: [capInstanceName1=" + capInstanceName1 + ", portCap1=" + portCap1 + ", bhvPortCap1=" + bhvPortCap1
				+ ", capInstanceName2=" + capInstanceName2 + ", portCap2=" + portCap2 + ", bhvPortCap2=" + bhvPortCap2 + ", protocolName=" + protocolName + ", connectorName=" + connectorName +"]";
	}


}
