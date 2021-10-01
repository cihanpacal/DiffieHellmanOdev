package server;

import java.io.IOException;
import server.kriptografi.Dh;;

public class Server{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Baglanti baglanti=new Baglanti(9090);
		baglanti.baglantiBekleme();
		Thread.sleep(15000);
        Dh  dh=new Dh(baglanti);
		dh.start();
		dh.join();
		System.out.println("[Server] : >"+" anahtar = "+dh.getAnahtar());
		Thread.sleep(5000);
	}

}
