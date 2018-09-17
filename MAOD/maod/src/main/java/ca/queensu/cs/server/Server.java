package ca.queensu.cs.server;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

*/

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;



public class Server  {

    private  String ip;
    private  int port;
    private  SocketIO io;
    private  Thread writerT;
    private  Thread readerT;
    private String[] capsuleNames = {"Pinger:pinger:0","Ponger:ponger:0"};
    private ServerSocket serverSocket;
    private ByteReader reader;
    private ByteWriter writer;
    
    public Server(final String ipAddress, final int portNumber) throws IOException {
        ip = ipAddress;
        port = portNumber;
        io = new SocketIO();
        //getModelInfo();
        reader = new ByteReader(io, capsuleNames);
        writer = new ByteWriter(io, capsuleNames);
        readerT = new Thread(reader);
        writerT = new Thread(writer);
        try {
			serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args) throws IOException 
    { 
        Thread t1 = new Thread(new Server("127.0.0.1",8001).new RunnableImpl()); 
        t1.start(); 
    } 
  
    public class RunnableImpl implements Runnable { 

    public void run() {
        

        try {
        	System.out.println("Now accepting new client!");
        	writer.setReader(reader);
        	io.socket = serverSocket.accept();
        	
			System.out.println("socket communication created");
            //writerT.start();
            readerT.start();
            
            while (!Thread.currentThread().isInterrupted()) {
                if (!io.isConnected()) {
                    break;
                }
                //Thread.sleep(100);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        	
        }

        try {
            io.close();
            //writerT.interrupt();
            readerT.interrupt();
            //writerT.join();
            readerT.join();
        } catch (final IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    }
    
    public void getModelInfo() {
		try {
		//Enter data using BufferReader 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print("How many capsules do you have? ");
		int capsuleNumber = Integer.valueOf(reader.readLine());
		for (int i = 0; i<capsuleNumber; i++) {
			System.out.print("["+Integer.toString(i+1)+"]: ");
			String capsuleName;			
				capsuleName = reader.readLine();
				capsuleNames[i] = capsuleName;	
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
}