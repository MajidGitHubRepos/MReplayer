package ca.queensu.cs.antler4AC;


public class SendMessage {
	
	public String port;
	public String msg;
	public Value data;
	public Value dest;
	
	public SendMessage (String _port, String _msg, Value _data, Value _dest) {
		this.msg = _msg;
		this.port = _port;
		this.data = _data;
		this.dest = _dest;
	}
	
	public SendMessage() {
		this(null, null, null, null);
	}
	
	public String allDataToString() {
		if (dest != null)
			return "[PORT=" + port + ", MSG=" + msg + ", DATA=" + data.toString()+ ", DEST=" + dest.toString() +"]";
		else
			return "[PORT=" + port + ", MSG=" + msg + ", DATA=" + data.toString() + "]";
	}
	
}
