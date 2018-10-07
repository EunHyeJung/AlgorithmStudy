import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
* @source https://www.acmicpc.net/problem/4355
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.07
*/
public class Solution {
	public static void main(String[] args) {
		try {
			CoPrimeFinder coPrimeFinder = new CoPrimeFinder();
			coPrimeFinder.findCoPrimeCnt();
		} catch (IOException e) {

		}
	}

}

class CoPrimeFinder {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Map<Integer, Map<Integer, Integer>> primeFactorOfN;

	public CoPrimeFinder() {
		primeFactorOfN = new HashMap<Integer, Map<Integer, Integer>>();
	}

	public void findCoPrimeCnt() throws IOException {
		int n = 0;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			getPrimeFactor(n);
			int cnt = 1;
			Map<Integer, Integer> primeFactor = primeFactorOfN.get(n);
			for (int m : primeFactor.keySet()) {
				int e = primeFactor.get(m);
				cnt *= (Math.pow(m, e) - Math.pow(m, e - 1));
			}
			System.out.println(cnt);
		}
	}

	public void getPrimeFactor(int n) {
		Map<Integer, Integer> primeFactor = new HashMap<>();
		int tmpN = n;
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				if (primeFactorOfN.containsKey(n)) {
					Map<Integer, Integer> map = (primeFactorOfN.get(n));
					for (int m : map.keySet()) {
						primeFactor.put(m, primeFactor.getOrDefault(i, 0) + map.get(m));
					}
					primeFactorOfN.put(tmpN, primeFactor);
					return;
				}
				primeFactor.put(i, primeFactor.getOrDefault(i, 0) + 1);
				
				n /= i;
			}
		}
		if (n > 1) {
			primeFactor.put(n, primeFactor.getOrDefault(n, 0) + 1);
		}
		primeFactorOfN.put(tmpN, primeFactor);
	}
}
