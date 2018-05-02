package chatClient2;

import java.net.*;
import java.io.*;

public class ListenFromServer extends Thread {
	
	private Socket socket;
	private InputStream inputStream;
	private String receivedMessage;
	private BufferedReader bufferedReader;
	private boolean run;
	
	public ListenFromServer(Socket socket) {
		
		try {
			
			this.socket = socket;
			this.inputStream = socket.getInputStream();
			this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			this.run = true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		
		while (run) {
			
			try {
				
			receivedMessage = bufferedReader.readLine();
				
				if (receivedMessage == null) {
					stopThread();
				}
					
				else {
					System.out.println(receivedMessage);
				}	
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void stopThread() {
		run = false;
	}

}
