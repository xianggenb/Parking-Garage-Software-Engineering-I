// Written by: Luke Miller
// Tested by: Luke Miller
// Debugged by: Luke Miller

package simulation;

import java.io.*;
import java.net.*;

public class UDPSend {
  public static void send(String data) {
    try {
    	
      String host = "172.31.208.167";
      int port = 6000;

      byte[] message = data.getBytes();

      // Get the internet address of the specified host
      InetAddress address = InetAddress.getByName(host);

      // Initialize a datagram packet with data and address
      DatagramPacket packet = new DatagramPacket(message, message.length,
          address, port);

      // Create a datagram socket, send the packet through it, close it.
      DatagramSocket dsocket = new DatagramSocket();
      dsocket.send(packet);
      dsocket.close();
    } catch (Exception e) {
      System.err.println(e);
    }
  }
  
  public static void sendVik(String data) {
	    try {
	    	
	      String host = "172.31.225.161";
	      int port = 6000;

	      byte[] message = data.getBytes();

	      // Get the internet address of the specified host
	      InetAddress address = InetAddress.getByName(host);

	      // Initialize a datagram packet with data and address
	      DatagramPacket packet = new DatagramPacket(message, message.length,
	          address, port);

	      // Create a datagram socket, send the packet through it, close it.
	      DatagramSocket dsocket = new DatagramSocket();
	      dsocket.send(packet);
	      dsocket.close();
	    } catch (Exception e) {
	      System.err.println(e);
	    }
	  }
  
  
  
}



