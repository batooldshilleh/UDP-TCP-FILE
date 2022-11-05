package aa;

import java.io.*;
import java.net.*;
class UDPClient {
	public static void main(String args[]) 
	{
		
		System.out.println("Hi there! You can now start sending datagram packets to the server.");
		
		try {
			
			while (true) {
				
				BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));
				
				DatagramSocket clientSocket = new DatagramSocket();
				
				InetAddress IPAddress = InetAddress.getByName("DESKTOP-391EKB1");
				
				byte[] sendData = new byte[1024];
				
				byte[] receiveData = new byte[1024];
				
				String sentence = inFromUser.readLine();
				
				sendData = sentence.getBytes();
				
				DatagramPacket sendPacket =
				new DatagramPacket(sendData, sendData.length, IPAddress, 7775);
				
				clientSocket.send(sendPacket);
				
				DatagramPacket receivePacket =
				new DatagramPacket(receiveData, receiveData.length);
				
				clientSocket.receive(receivePacket);
				
				String modifiedSentence =
				new String(receivePacket.getData());
				
				System.out.println(modifiedSentence);
				
				clientSocket.close();
				
					}
			
				}
		
				catch (Exception e) {
					
				e.printStackTrace(); 
		}
	}
}

