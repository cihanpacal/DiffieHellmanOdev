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
		// server g ve p asal say�s�n� belirliyor
		int g = 5;
		int p = RandomPrime.randomPrime(Integer.MAX_VALUE / 2, Integer.MAX_VALUE);
		
		//server p'den k���k bir gizli say� belirliyor
		gizliSayi = 2 + rand.nextInt(p);
		//server client'a g�ndermek i�in s say�s�n� hesapl�yor
		int s=(int)Math.pow(g, gizliSayi)%p;
		//server output stream'i ile  p g ve s say�s�n� client'a g�nderiyor
		output.println(p);
		output.println(g);
		output.println(s);
		System.out.println("[Server] : > "+"p = "+p+", g = "+g+", s = "+s+", gizliSayi = "+gizliSayi+" (Bu say� sadece server'�n konsoluna yaz�ld�)");
		Thread.sleep(5000);
		
		//server client'tan r say�s�n� al�yor
		int r=Integer.parseInt(input.readLine());
		System.out.println("[Client] :  "+" r = "+r);
		
		//server client'tan ald��� r, kendi gizli say�s� ve p ile anahtar� hesapl�yor. 
		anahtar=(int)Math.pow(r,gizliSayi)%p;
	}

	public int getAnahtar() {
		return anahtar;
	}


}
