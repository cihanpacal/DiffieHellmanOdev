package client.kriptografi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import client.Baglanti;

public class Dh extends Thread {
	private Baglanti baglanti;
	private int gizliSayi;
	private int anahtar;
	private Random rand = new Random();

	public Dh(Baglanti baglanti) {
		this.baglanti = baglanti;
	}
	
	@Override
	public void run() {
		try {
			anahtarDegisimi();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void anahtarDegisimi() throws ClassNotFoundException, IOException, InterruptedException {
		BufferedReader input=baglanti.getInput();
		PrintWriter output=baglanti.getOutput();
		
		int p=Integer.parseInt(input.readLine());
		int g=Integer.parseInt(input.readLine());
		int s=Integer.parseInt(input.readLine());
		System.out.println("[Server] :  "+"p = "+p+", g = "+g+", s = "+s);
		
		Thread.sleep(5000);
		gizliSayi=2+rand.nextInt(p);
		int r=(int)Math.pow(g,gizliSayi);
		output.println(r);
		System.out.println("[Client] : >"+" r = "+r+", gizliSayi = "+gizliSayi+" (Bu sayý sadece client'ýn konsoluna yazýldý) ");
		Thread.sleep(5000);
		anahtar=(int)Math.pow(s,gizliSayi)%p;
		
	}

	public int getAnahtar() {
		return anahtar;
	}	
	
	
}
