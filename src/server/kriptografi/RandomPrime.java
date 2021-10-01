package server.kriptografi;

import java.util.Random;

public class RandomPrime {
	private static Random rand=new Random();
	
	

	public static int randomPrime(int min, int max) {
		if (min < 0)
			throw new IllegalArgumentException("min pozitif sayý olmalý.");
		if (min >= max)
			throw new IllegalArgumentException("min maxtan küçük olmalý.");
		if (!containsPrime(min, max))
			throw new IllegalArgumentException("bu aralýkta asal sayý yok");
		if (rand == null) {
			rand = new Random();
		}
		int out = rand.nextInt(max - min) + min;
		while (!isPrime(out)) {
			out = rand.nextInt(max - min) + min;
		}
		return out;
	}

	private static  boolean containsPrime(int min, int max) {
		if (isPrime(min) || isPrime(max - 1)) {
			return true;
		}
		if (min % 2 == 0) {
			min += 1;
		}
		while (min < max) {
			if (isPrime(min)) {
				return true;
			}
			min += 2;
		}
		return false;
	}

	private static boolean isPrime(int n) {
		// n'nin 2 'nin katý olup olmadýðýný kontrol etme
		if (n % 2 == 0)
			return false;
		// deðilse tek olup olmadýðýný kontrol et
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
