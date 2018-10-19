package ca.queensu.cs.controller;

public class Message {
	private String capsuleInstance;
	private String port;
	private String msg;
	
	public Message (String port, String msg, String capsuleInstance) {
		this.msg = msg;
		this.port = port;
		this.capsuleInstance = capsuleInstance;
	}
	public Message() {
		this(null, null, null);
	}

	public void setCapsuleInstance(String capsuleInstance) {
		this.capsuleInstance = capsuleInstance;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	public String getMsg() {
		return this.msg;
	}

	public String getPort() {
		return this.port;
	}
	public String getCapsuleInstance() {
		return this.capsuleInstance;
	}


}
