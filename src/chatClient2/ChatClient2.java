package chatClient2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatClient2 {
	
	private Socket socket;
	private Scanner scanner = new Scanner(System.in);
	private String receivedMessage;
	private OutputStream outputStream;
	private PrintWriter printWriter;
	
	public ChatClient2() {
		
		try {
			
			socket = new Socket("localhost", 3000);
			System.out.println("Connected to " + socket.getRemoteSocketAddress());
			
			ListenFromServer listenFromServerThread = new ListenFromServer(socket);
			listenFromServerThread.start();
			
			beginTyping(socket);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void beginTyping(Socket socket) {
		
		try {
			
			outputStream = socket.getOutputStream();
			printWriter = new PrintWriter(outputStream, true);
			
			while (true) {
				
				receivedMessage = scanner.nextLine();
				printWriter.println(receivedMessage);
				printWriter.flush();
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
