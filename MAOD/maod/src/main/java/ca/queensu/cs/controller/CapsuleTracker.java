package ca.queensu.cs.controller;

import java.util.concurrent.Semaphore;

import ca.queensu.cs.server.Event;


public class CapsuleTracker implements Runnable{

	private Semaphore semCapsuleTracker;
	private String capsuleInstance;
	private Event currentEvent;


	public CapsuleTracker(Semaphore semCapsuleTracker, String capsuleInstance) {
		this.semCapsuleTracker = semCapsuleTracker;
		this.capsuleInstance = capsuleInstance;
	}



	public void run() {
		System.out.println("\n\n--> Running thread: " +  capsuleInstance +"\n\n");
		while(true) {

			for (int i = 0; i< TrackerMaker.trackerCount; i ++) {
				if (TrackerMaker.dataArray[i].getCapsuleInstance().contains(capsuleInstance)) {
					if(!TrackerMaker.dataArray[i].getEventQueue().isEmpty()) {
						try {
							currentEvent =  getEventFromCapsuleTrackerQueue(i);
							System.out.println("\n[in CapsuleTracker]-->["+ capsuleInstance+ "]: " + currentEvent.allDataToString());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				}
			}
		}
	}


	public Event getEventFromCapsuleTrackerQueue(int dataArrayNumber) throws InterruptedException {
		
		Event event = new Event();
		
		//semCapsuleTracker.acquire();
		//if (!TrackerMaker.dataArray[dataArrayNumber].getEventQueue().isEmpty())
			event = TrackerMaker.dataArray[dataArrayNumber].getFromQueue();
		//semCapsuleTracker.release(); 
		return event;
	}

	@SuppressWarnings("deprecation")
	public void shutdown() {
		Thread.currentThread().stop();
	}


}
