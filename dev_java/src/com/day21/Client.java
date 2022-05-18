package com.day21;

import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public void client() {
		int port = 3000;
		String serverIP = "192.168.20.34";
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			
			Socket socket = new Socket(serverIP, port);
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
}
