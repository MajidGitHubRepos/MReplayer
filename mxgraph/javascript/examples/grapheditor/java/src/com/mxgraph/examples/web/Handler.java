package com.mxgraph.examples.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.io.*;

import org.json.*;

public class Handler extends Thread {
	private String name;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	public  OutputStream outputFileStream;

	private Semaphore sem;
	public String outputFileName;
	public File outputFile;

	/**
	 * Constructs a handler thread, squirreling away the socket.
	 * All the interesting work is done in the run method.
	 */
	public Handler(Socket socket, OutputStream outputFileStream) {
		this.socket = socket;
		this.outputFileStream = outputFileStream;
		//this.inMsgQueue = inMsgQueue;



	}

	public void run() {
		try{
			//sem.acquire();
			BufferedReader socketReader = null;
			socketReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));



			String inMsg = null;
			inMsg = socketReader.readLine();
			//while ((inMsg = socketReader.readLine()) != null) {

			if (inMsg != null) {
				if (ModelJsonServer.inMsgQueue.isEmpty()) {
					System.out.println("==================================[write into the registration.json]============================");
					//  try {
					outputFileStream.write(inMsg.getBytes(), 0, inMsg.length());
					outputFileStream.flush();
					outputFileStream.close();
					System.out.println("\n>>>>> inMsgJSON: "+ inMsg);
					JSONObject inMsgJSON = new JSONObject(inMsg);
					//JSONArray inMsgJSONArr = inMsgJSON.getJSONArray("list");

					Message msg = new Message( -1, null, null);
					ModelJsonServer.inMsgQueue.put(msg);
					inMsgJSON = null;
					msg = null;
					//}catch (InterruptedException e) {System.err.println("====[NoSuchElementException]===");}

				}else {
					//System.out.println("inMsgQueue: " + ModelJsonServer.inMsgQueue);
					JSONObject inMsgJSON = new JSONObject(inMsg);
					JSONArray inMsgJSONArr = inMsgJSON.getJSONArray("list");
					System.out.println("\n>>>>> inMsgJSON: "+ inMsgJSONArr.toString());

					Message msg = new Message( Integer.parseInt(inMsgJSONArr.get(0).toString()), inMsgJSONArr.get(1).toString(), inMsgJSONArr.get(2).toString());

					ModelJsonServer.inMsgQueue.put(msg);
					inMsgJSON = null;
					inMsgJSONArr = null;
					msg = null;
				}
				//outputStreamToFile();
			}
			//}

			//FileWriter file;


			//outputStreamToFile();



			socket.close();
			//sem.release();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	//==================================================================	
	//==============================================[outputStreamToFile]
	//==================================================================	
	//    	public void outputStreamToFile() {
	//    		try {
	//    			while(!inMsgQueue.isEmpty()) {
	//    				
	//    				
	//    				 		System.out.println("==================================[write into the changes.json]============================");
	//    			    		//ClassLoader classLoader = getClass().getClassLoader();
	//    			    		
	//    			    		//outputFile.createNewFile();
	//    			    		//System.out.println("\n["+ Thread.currentThread().getName() +"]> outputFile exists in : "+ outputFile.getAbsolutePath());
	//    			    		
	//    			    		
	//    			        
	//    				 String msg = inMsgQueue.take();
	//    				 for (int i = 0; i < 10 ; i++) {
	//    					 msg = msg + System.lineSeparator();
	//    				 }
	//    				 outputFileStream.write(msg.getBytes(), 0, msg.length());
	//    				 outputFileStream.flush();
	//    				 //outputFileStream.close();
	//    				//outputFile = null;
	//    				//outputFileStream = null;
	//    			}
	//    		} catch (IOException e) {
	//    			e.printStackTrace();
	//    		}catch (InterruptedException e) {System.err.println("====[NoSuchElementException]===");}
	//    	}
	//        
}