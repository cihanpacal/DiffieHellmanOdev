package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Baglanti {
	private ServerSocket serverSocket;
	private PrintWriter output;
	private BufferedReader input;
	
	public Baglanti(int port) throws IOException {
		serverSocket=new ServerSocket(port);
	}
	
	public void baglantiBekleme() throws IOException {
		System.out.print("[Server] : > ");
		System.out.println("Bağlanti için bekleniyor...");
		
		Socket client=serverSocket.accept();
		
		output=new PrintWriter(client.getOutputStream(),true);
		input=new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		String serverMesaj="Bağlantı gerçekleşti...";
		output.println(serverMesaj);
		System.out.print("[Server] : > ");
		System.out.println(serverMesaj);
	}
	
	public PrintWriter getOutput() {
		return output;
	}

	public BufferedReader getInput() {
		return input;
	}
	
	
	
}
	
	
