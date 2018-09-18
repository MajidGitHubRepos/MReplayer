package ca.queensu.cs.capsuleTracker;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import ca.queensu.cs.server.Event;

public class Waiter implements Runnable{
    
    //private Event event;
	private Message msg;
	
    public Waiter(Message msg){
        this.msg=msg;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
        	while(true) {
            try{
                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                msg.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+" ---->processed: "+msg.getEvent().allDataToString());
        }
        }
    }

}
