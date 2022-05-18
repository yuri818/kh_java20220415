package com.day21;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void server() {
		int port = 3000;
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			
			while(true) {
				Socket client = server.accept();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
