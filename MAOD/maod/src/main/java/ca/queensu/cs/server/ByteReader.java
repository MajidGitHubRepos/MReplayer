package ca.queensu.cs.server;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

*/

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Queue;

//import org.eclipse.debug.core.DebugException;

import ca.queensu.cs.server.ByteReader.Command;


public final class ByteReader implements Runnable {

	public static enum Command {
		WAITING_FOR_BREAKPOINT_REACHED,
		WAITING_FOR_BREAKPOINT_LIST,
		WAITING_FOR_EVENT_LIST,
		WAITING_FOR_VALUE_CHANGE_ACK,
		WAITING_FOR_ACK,
		WAITING_FOR_RUN_ACK,
		WAITING_FOR_LAST_EVENT,
		STEPPING,
		RESUME
	};

	//private final Queue<byte[]> queue;
	private final SocketIO io;
	private Map<Integer, Command> commandStack;
	private static int commandId = 0;
	private String[] capsuleNames;
	public String info;

	public ByteReader(final SocketIO serverIo, String[] caps ) {
		info = "This is a reader!";
		io = serverIo;
		capsuleNames = caps;
	}

	public final void run() {
		try {
			io.input = new DataInputStream(io.socket.getInputStream());

			readFromSocketWithSize();

			while (!Thread.currentThread().isInterrupted()) {
				if (!io.isConnected()) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					io.close();
					//return;
					continue;
				}

				byte[] messageBuffer = new byte[4096];
				String message;
				io.read(messageBuffer);
				message = new String(messageBuffer, StandardCharsets.UTF_8);
				System.out.println(">>>>>>>>>>>>>>>>>>>> message: "+message);
				int id = 0;

				if (message.indexOf('|') >= 0) {

					String[] table = message.split("[|]", 2);
					String messageId = table[0];
					message = table[1];

					id = Integer.parseInt(messageId);


					if ((id == 0)) {
						this.retrieveCapsuleList(message);
					}
					else {
						this.retrieveLastEvent(message);
					}
				}

			}

			System.out.println("Deleting client");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void retrieveEventList(String message) {
		System.out.println("========================[In retrieveEventList]========================");	

		String[] traces = message.split("[|]");

		if (traces.length <= 1)
			return;

		String capsule = traces[0];
		String currentState = traces[1];
		//IThread thread = ((MDebuggerDebugTarget)this.target).getThread(capsule);

		//IStackFrame[] stackFrames;
		//IVariable[] variables;

		String[] events = new String[traces.length -2];
		for (int i = 0; i < events.length; i++) {
			events[i] = traces[i+2];
			System.out.println("event: " +  events[i]);
			System.out.println("-------------------------------------");
		}

		//((CapsuleThread)thread).setEvents(events);

	}

	private void retrieveLastEvent(String message) {
		System.out.println("========================[In retrieveLastEvent]========================");	
		String[] traces = message.split("[|]");
		String capsule = traces[0];
		String currentState = traces[1];
		//String event = traces[2];

		//IThread thread = ((MDebuggerDebugTarget)this.target).getThread(capsule);

		//		String[] events = new String[traces.length -2];
		for (int i = 0; i < traces.length -2; i++) {
			String event = traces[i+2];
			System.out.println("event: " +  event);
			System.out.println("-------------------------------------");
			//((CapsuleThread)thread).pushEvent(event);
		}	

	}


	public  Map<Integer, Command> getCommandStack() {
		return this.commandStack;
	}

	public void retrieveCapsuleList(String message) {
		System.out.println("========================[In retrieveCapsuleList]========================");	
		String[] capsuleTraces;

		capsuleTraces = message.split("&");

		int n = capsuleTraces.length;
		String[] capsules = new String[n];
		String[] currentStates = new String[n];

		for (int i = 0 ; i < n; i++) {
			String[] traces = capsuleTraces[i].split("[|]");
			capsules[i] = traces[0];
			currentStates[i] = traces[1];
			System.out.println("capsule: " +  capsules[i]);
			System.out.println("capsule: " +  currentStates[i]);
			System.out.println("-------------------------------------");

		}

		//((MDebuggerDebugTarget)target).setCapsule(capsules, currentStates);

		//if (target.canSuspend())
		//	target.suspend();

	}
	public void readFromSocketWithSize() {
		try {
			if (!io.isConnected()) {
				//Thread.sleep(100);
				io.close();
				return;
			}
			char[] sizeBuffer = new char[4];
			char[] messageBuffer;
			String message;
			int size;

			//----------[Reading size and message from client]

			byte[] byteBuffer1 = new byte[sizeBuffer.length];
			int result = io.read(byteBuffer1, 0, 4);
			for (int i = 0; i < byteBuffer1.length; i++) {
				sizeBuffer[i] = (char) byteBuffer1[i];
			}
			if (result == -1) {
				io.close();
				return;
			}

			size = Integer.parseInt(new String(sizeBuffer));
			//System.out.println(">>>>>>>>>>>>>>>>>>>> sizeBuffer: "+size);
			//size = 500;
			messageBuffer = new char[size];


			byte[] byteBuffer2 = new byte[messageBuffer.length];
		
			message = new String(messageBuffer);
			io.read(byteBuffer2, 0, size);

			message = new String(byteBuffer2, StandardCharsets.UTF_8);
			System.out.println(">>>>>>>>>>>>>>>>>>>> message: "+message);
			int id = 0;

			if (message.indexOf('|') >= 0) {

				String[] table = message.split("[|]", 2);
				String messageId = table[0];
				message = table[1];

				try{
					id = Integer.parseInt(messageId);
				} catch (NumberFormatException e) {
				}


				if ((id == 0)) {
					this.retrieveCapsuleList(message);
				}
				else {
					this.retrieveLastEvent(message);

					/*
				Command command = this.commandStack.get(id);

				if (command == null) {
					System.out.println("command is null!");
					return;
				}

				this.retrieveLastEvent(message);

				switch (command) {
				case WAITING_FOR_BREAKPOINT_REACHED:
					this.retrieveCapsuleList(message);
					break;
				case WAITING_FOR_EVENT_LIST:
					this.retrieveEventList(message);
					break;
				case STEPPING:
					//	this.refreshAfterACK(message);
					break;
				case WAITING_FOR_LAST_EVENT:
					//System.err.println("never called");
					this.retrieveLastEvent(message);
					break;
				case WAITING_FOR_VALUE_CHANGE_ACK:
					//this.refreshAfterACK(message);
					break;
				case WAITING_FOR_RUN_ACK:
					//this.sendCmdHandler.requestLastEvent();
					break;
				case WAITING_FOR_ACK:
					break;
				}


				if (id != 0)
					commandStack.remove(id);
					 */
				}
			}

			sizeBuffer = new char[4];
			messageBuffer = null;
		}catch (final IOException e) {
			e.printStackTrace();
		}

	}

	
}