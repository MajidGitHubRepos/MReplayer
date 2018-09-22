package ca.queensu.cs.controller;

public class Message {
	private String port;
	private String msg;
	
	public Message (String port, String msg) {
		this.msg = msg;
		this.port = port;
	}
	public Message() {
		this(null, null);
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


}
