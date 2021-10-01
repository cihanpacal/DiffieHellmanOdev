package client;

import java.io.IOException;
import java.net.UnknownHostException;

import client.kriptografi.Dh;

public class Client {
	
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, UnknownHostException, IOException {
		Baglanti baglanti=new Baglanti("127.0.0.1",9090);
		Dh dh=new Dh(baglanti);
		dh.start();
		dh.join();
		System.out.println("[Client] : >"+" anahtar"+dh.getAnahtar());
		Thread.sleep(1000);
	}

}
