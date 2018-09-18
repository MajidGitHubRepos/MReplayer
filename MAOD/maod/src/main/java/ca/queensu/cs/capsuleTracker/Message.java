package ca.queensu.cs.capsuleTracker;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import ca.queensu.cs.server.Event;

public class Message {
    private String msg;
    private Event event;
    
    public Message(String str, Event event ){
        this.msg=str;
        this.event = event;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String str) {
        this.msg=str;
    }
    
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
    	this.event = event;
    }

}