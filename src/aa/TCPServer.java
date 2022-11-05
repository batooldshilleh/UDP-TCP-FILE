package aa;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
class TCPServer extends fileReader {
	
	public static void main(String argv[]) throws Exception
	
	{
		String clientSentence;
		
		ArrayList<String> Result=new ArrayList<String>();
		
		try (ServerSocket welcomeSocket = new ServerSocket(8808)) {
			
		    while(true) {
		    	
		    Socket connectionSocket = welcomeSocket.accept();
		    
		    BufferedReader inFromClient =
		    		
		    new BufferedReader(new
		    		
		    InputStreamReader(connectionSocket.getInputStream()));
		    
		    DataOutputStream outToClient =
		    		
		    new DataOutputStream(connectionSocket.getOutputStream());
		    
		    clientSentence = inFromClient.readLine();
		    
		    Result =readFile(clientSentence);  
		    
		    for(int i=0; i<=5;i++) {
		    	outToClient.writeBytes(Result.get(i));
		    
		    
		    
		    outToClient.close();
		    
		    inFromClient.close();
		    
		    connectionSocket.close();
		    }
		    
		    }
		}
	}
}