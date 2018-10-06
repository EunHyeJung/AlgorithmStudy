import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/2824
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.06
*/
public class Main {
	public static void main(String[] args) {
		try {
			GCDFinder gcdFinder = new GCDFinder();
			gcdFinder.printGCD();
		} catch (IOException e) {

		}
	}

}

class GCDFinder {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Map<Integer, Integer> primeFactorOfA;
	private Map<Integer, Integer> primeFactorOfB;

	public GCDFinder() throws IOException {
		this.primeFactorOfA = new HashMap<>();
		this.primeFactorOfB = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			getPrimeFactor('A', Integer.parseInt(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			getPrimeFactor('B', Integer.parseInt(st.nextToken()));
		}
	}

	public void printGCD() {
		long gcd = 1;
		boolean isOver = false;
		for (int primeFactor : primeFactorOfA.keySet()) {
			if (primeFactorOfB.containsKey(primeFactor)) {
				int e = Math.min(primeFactorOfA.get(primeFactor), primeFactorOfB.get(primeFactor));
				while (e-- > 0) {
					gcd *= primeFactor;
					while (gcd / 1000000000 > 0) {
						gcd %= 1000000000;
						isOver = true;
					}
				}

			}
		}
		if (!isOver) {
			System.out.println(gcd);
			return;
		}
		System.out.println(String.format("%09d", gcd));

	}

	public void getPrimeFactor(char type, int n) {

		switch (type) {
		case 'A': {
			for (int p = 2; p * p <= n; p++) {
				while (n % p == 0) {
					primeFactorOfA.put(p, primeFactorOfA.getOrDefault(p, 0) + 1);
					n /= p;
				}
			}
			if (n > 0) {
				primeFactorOfA.put(n, primeFactorOfA.getOrDefault(n, 0) + 1);
			}
			break;
		}
		case 'B': {
			for (int p = 2; p * p <= n; p++) {
				while (n % p == 0) {
					primeFactorOfB.put(p, primeFactorOfB.getOrDefault(p, 0) + 1);
					n /= p;
				}
			}
			if (n > 0) {
				primeFactorOfB.put(n, primeFactorOfB.getOrDefault(n, 0) + 1);
			}
			break;
		}
		}
	}

}
