package ca.queensu.cs.server;

public class Event {
	private String eventId; 
	private String eventSourceKind; 
	private String eventType; 
	private String eventCapsuleName; 
	private String eventCapsuleInstance; 
	private String eventCapsuleIndex; 
	private String eventSourceName;
	private String eventCpuTik; 
	private String eventTimePointSecond; 
	private String eventTimePointNano; 
	private String eventVariableData;
	private String eventSignal;
	private String eventSource;
	private String eventStatus;
	private String eventTarget;
	
	
	public Event(String eventId, String eventSourceKind,String eventType,String eventCapsuleName,String eventCapsuleInstance,
			String eventCapsuleIndex,String eventSourceName,String eventCpuTik,String eventTimePointSecond,String eventTimePointNano,String eventVariableData,
			String eventSignal,String eventSource,String eventStatus,String eventTarget) {
		this.eventId=eventId;
		this.eventSourceKind=eventSourceKind;
		this.eventType=eventType; 
		this.eventCapsuleName=eventCapsuleName; 
		this.eventCapsuleInstance=eventCapsuleInstance; 
		this.eventCapsuleIndex=eventCapsuleIndex; 
		this.eventSourceName=eventSourceName;
		this.eventCpuTik=eventCpuTik; 
		this.eventTimePointSecond=eventTimePointSecond; 
		this.eventTimePointNano=eventTimePointNano; 
		this.eventVariableData=eventVariableData;
		this.eventSignal=eventSignal;
		this.eventSource=eventSource;
		this.eventStatus=eventStatus;
		this.eventTarget=eventTarget; 
	}
	public Event() {
		this(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
	}
	
	public String allDataToString() {
		return "Event [eventId="+eventId+", eventSourceKind=" + eventSourceKind + ", eventType=" + eventType + ", eventCapsuleName=" + eventCapsuleName + ", eventCapsuleInstance=" + eventCapsuleInstance
				+ ", eventCapsuleIndex=" + eventCapsuleIndex + ", eventSourceName=" + eventSourceName + ", eventCpuTik=" + eventCpuTik
				+  ", eventTimePointSecond=" + eventTimePointSecond + ", eventTimePointNano=" + eventTimePointNano +
				", eventVariableData=" + eventVariableData +", eventSignal=" + eventSignal +", eventSource=" + eventSource +
				", eventStatus=" + eventStatus +", eventTarget=" + eventTarget +"]";
	}

}
