package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Baglanti {
	private  Socket socket;
	private  BufferedReader input;
	private  PrintWriter output;
	
	public Baglanti(String serverIp,int port) throws UnknownHostException, IOException, ClassNotFoundException {
		socket=new Socket(serverIp,port);
		input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		output=new PrintWriter(socket.getOutputStream(),true);
		String serverMesaj=input.readLine();
		System.out.println("[Server] :  "+serverMesaj);
	}

	public BufferedReader getInput() {
		return input;
	}

	public PrintWriter getOutput() {
		return output;
	}
	
	
	
}
