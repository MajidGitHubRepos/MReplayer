package ca.queensu.cs.capsuleTracker;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.util.concurrent.Semaphore;
import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.Server;

public class Notifier implements Runnable {

	private Semaphore sem;
	private Message msg;

	public Notifier(Message msg, Semaphore sem) {
		this.sem = sem;
		this.msg = msg;
	}

	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" started");
		while (!Thread.currentThread().isInterrupted()) {

			if (Server.eventQueue.size()>0) {
				try {
					Event event = getQueueEvent();
					msg.setEvent(event);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				synchronized (msg) {
					msg.notifyAll();
				}

			}
		}

	}
	public Event getQueueEvent() throws InterruptedException {
		sem.acquire();
		Event event = Server.eventQueue.remove();
		//System.out.println("[getQueueEvent]: " + event.allDataToString());
		// Release the permit. 
		//System.out.println(threadName + " releases the permit."); 
		sem.release(); 
		return event;
	}

}