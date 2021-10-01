package server.kriptografi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import server.Baglanti;


public class Dh extends Thread {
	private Baglanti baglanti;
	private int gizliSayi;
	private int anahtar;
	private Random rand=new Random();
	

	public Dh(Baglanti baglanti) {
		this.baglanti = baglanti;
	}
	
	@Override
	public void run() {
		try {
			anahtarDegisimi();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void anahtarDegisimi() throws IOException, InterruptedException {
		//baglantidan streamleri alma
		PrintWriter output=baglanti.getOutput();
		BufferedReader input=baglanti.getInput();
		// server g ve p asal sayısını belirliyor
		int g = 5;
		int p = RandomPrime.randomPrime(Integer.MAX_VALUE / 2, Integer.MAX_VALUE);
		
		//server p'den küçük bir gizli sayı belirliyor
		gizliSayi = 2 + rand.nextInt(p);
		//server client'a göndermek için s sayısını hesaplıyor
		int s=(int)Math.pow(g, gizliSayi)%p;
		//server output stream'i ile  p g ve s sayısını client'a gönderiyor
		output.println(p);
		output.println(g);
		output.println(s);
		System.out.println("[Server] : > "+"p = "+p+", g = "+g+", s = "+s+", gizliSayi = "+gizliSayi+" (Bu sayı sadece server'ın konsoluna yazıldı)");
		Thread.sleep(5000);
		
		//server client'tan r sayısını alıyor
		int r=Integer.parseInt(input.readLine());
		System.out.println("[Client] :  "+" r = "+r);
		
		//server client'tan aldığı r, kendi gizli sayısı ve p ile anahtarı hesaplıyor. 
		anahtar=(int)Math.pow(r,gizliSayi)%p;
	}

	public int getAnahtar() {
		return anahtar;
	}


}
