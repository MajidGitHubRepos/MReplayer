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
	
	
	/*
	 * 	part of the event kind and type  are defined based on paper
	 *  Graf, Susanne, Ileana Ober, and Iulian Ober. "A real-time profile for UML."
	 *  International Journal on Software Tools for Technology Transfer 8.2 (2006): 113-127.
	 */
	
	// main category for the event sources, refer to appendix of paper for detail
	enum EVENTSOURCEKIND{SIGNALLING,METHOD,ACTIONECODE,TRANISTION,STATE,CAPSULE,ATTRIBUTE,TIMER,RESOURCE,CONNECTION,DEBUG,RESERVE1,RESERVE2,UNKOWNSOURCEKIND};
	// types of signal events
	enum EVENTTYPE{
	        SENDSIGNAL,RECIEVESIGNAL,DEFERSIGNAL,RECALLSIGNAL,CANCELLSIGNAL, // signal event //4
	        METHODCALL,METHODCALLRECIEVE,METHODSTARTEXECUTE,METHODRETURN,METHODFAILED,METHODRETURNRECIEVED, // method event //10
	        ACTIONSTART,ACTIONEND, // action code events //12
	        TRANISTIONSTART,TRANISTIONEND ,// TRANSITION //14
	        STATEENTRYSTART,STATEENTRYEND,STATEEXITSTART,STATEEXITEND,STATEIDLESTART,STATEIDLEEND, // state events //20
	        CAPSULEINSTNSIATE,CAPSULEFREE, // capsule event //22
	        ATTRIBUTEINSTNSIATE,ATTRIBUTEFREE,ATTRIBUTECHANGE, // attribute event //25
	        TIMERSTART,TIMERRESET,TIMERCANCELL,TIMERTIMEDOUT, // Timer events //29
	        RESOURCEASSIGNED,RESOURCERELEASED,RESOURCEPREEMPTED,RESOURCERESUMED,   // resource event //33
	        CONNECTIONESTABLISHED,CONNECTIONFAILED, // connection event //35
	        REGISTER,VARIABLEDATA,BREAKPOINTDATA,RESERVE5,RESERVE6, //Debug Event //40
	        UNKOWNTYPE //41
	};
	
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
	
	//--GETTERS
	public String getEventId() {
		return this.eventId;
	}
	public String getCapsuleInstance() {
		return this.eventCapsuleInstance;
	}
	public String getSourceKind() {
		return this.eventSourceKind;
	}
	public String getType() {
		return this.eventType;
	}
	public String getCapsuleName() {
		return this.eventCapsuleName;
	}
	public String getCapsuleIndex() {
		return this.eventCapsuleIndex;
	}
	public String getSourceName() {
		return this.eventSourceName;
	}
	public String getCpuTik() {
		return this.eventCpuTik;
	}
	public String getTimePointSecond() {
		return this.eventTimePointSecond;
	}
	public String getTimePointNano() {
		return this.eventTimePointNano;
	}
	public String getVariableData() {
		return this.eventVariableData;
	}
	public String getSignal() {
		return this.eventSignal;
	}
	public String getSource() {
		return this.eventSource;
	}
	public String getStatus() {
		return this.eventStatus;
	}
	public String getTarget() {
		return this.eventTarget;
	}
	
	
	
	public String allDataToString() {
		return ", Event: [eventSourceKind=" + eventSourceKind + ", eventType=" + eventType + ", eventCapsuleInstance=" + eventCapsuleInstance
				+ ", eventCapsuleIndex=" + eventCapsuleIndex + ", eventSourceName=" + eventSourceName + "]";
	}
	
	public String allDataToString_originalFromMDebugger() {
		return ", Event: [eventId="+eventId+", eventSourceKind=" + eventSourceKind + ", eventType=" + eventType + ", eventCapsuleName=" + eventCapsuleName + ", eventCapsuleInstance=" + eventCapsuleInstance
				+ ", eventCapsuleIndex=" + eventCapsuleIndex + ", eventSourceName=" + eventSourceName + ", eventCpuTik=" + eventCpuTik
				+  ", eventTimePointSecond=" + eventTimePointSecond + ", eventTimePointNano=" + eventTimePointNano +
				", eventVariableData=" + eventVariableData +", eventSignal=" + eventSignal +", eventSource=" + eventSource +
				", eventStatus=" + eventStatus +", eventTarget=" + eventTarget +"]";
	}
	

}
