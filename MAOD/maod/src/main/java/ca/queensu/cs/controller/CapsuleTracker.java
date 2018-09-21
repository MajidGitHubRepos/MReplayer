package ca.queensu.cs.controller;

import java.util.NoSuchElementException;
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

		while(true) {


			try {
				semCapsuleTracker.acquire();

				for (int i = 0; i< TrackerMaker.trackerCount; i ++) {
					if (TrackerMaker.dataArray[i].getCapsuleInstance().contains(capsuleInstance)) {
						if(!TrackerMaker.dataArray[i].getEventQueue().isEmpty()) {
							//System.out.println("\n\n--> [" + TrackerMaker.dataArray[i].getCapsuleInstance() +"] Running thread: " +  capsuleInstance + ", Size: "+ TrackerMaker.dataArray[i].getEventQueue().size() +"\n\n");
							try {

								//Thread.currentThread().sleep(1);

								currentEvent =  TrackerMaker.dataArray[i].getFromQueue();
								//System.out.println("\n[in CapsuleTracker]-->["+ capsuleInstance+ "]: " + currentEvent.allDataToString());
							} catch (NoSuchElementException e) {
								System.err.println("=============================[!]===================================");
								break;
							}
						}
						break;
					}
				}
				semCapsuleTracker.release();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void shutdown() {
		Thread.currentThread().stop();
	}


}
