package aa;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
class UDPServer extends fileReader {
	
		public static void main(String args[]) throws Exception
		
	{
			
		
			
	try (DatagramSocket serverSocket = new DatagramSocket(7775)) {
		
			byte[] receiveData = new byte[1024];
			
			byte[] sendData;
			
			while(true)
				
			{
				
				try {
					
					DatagramPacket datagramPacket = 
							new DatagramPacket(receiveData, receiveData.length);
					
					serverSocket.receive(datagramPacket); 
					
					InetAddress inetAddress = datagramPacket.getAddress();
					
					int port = datagramPacket.getPort();
					
					String messageFromClient = 
							new String(datagramPacket.getData(), 0, datagramPacket.getLength());
					
					ArrayList<String> Vehicle = new ArrayList<String>();
					
					Vehicle = readFile(messageFromClient);
					if(Vehicle !=null) {
					 for(int i=0; i<=3;i++) {
						 
						 sendData = Vehicle.get(i).getBytes();
						 
					    datagramPacket = new DatagramPacket(sendData, 
					    		sendData.length, inetAddress, port);
					    
					serverSocket.send(datagramPacket);
					
					 }
					 }
					 }
				
				catch (IOException e) {
					
					e.printStackTrace();
					
					break;
					
				}
			} 
			
		} 
	} 
}
