package aa;
import java.io.*;
import java.net.*;

	class TCPClient  {
	    
		public static void main(String argv[]) 
		{
		
			System.out.println("Hi there! You can now start sending requests to the server.");
			
			try {
				
			    while (true) {
			    	
			String sentence;
			
			String modifiedSentence;
			
			BufferedReader inFromUser =
					
			new BufferedReader(new InputStreamReader(System.in));
			
			Socket clientSocket = new Socket("192.168.10.102",8808);
			
			DataOutputStream outToServer =
					
			new DataOutputStream(clientSocket.getOutputStream());
			
			BufferedReader inFromServer =
					
			new BufferedReader(new
					
			InputStreamReader(clientSocket.getInputStream()));
			
			sentence = inFromUser.readLine();
			
			outToServer.writeBytes(sentence + '\n');
			
			modifiedSentence = inFromServer.readLine();
			
			System.out.println(modifiedSentence);
			
			clientSocket.close();
			
			    }
			    
			}
			
			catch (Exception e) {
				
			    e.printStackTrace();
			}
		}
	}
