import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/1929
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.06
*/
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		PrimeFinder primeFinder = new PrimeFinder(m, n);
		primeFinder.printPrime();
	}

}

class PrimeFinder {
	private static final int NOT_PRIME = 1;
	private static final int PRIME = 2;
	private int m;
	private int n;
	private int[] primeChk;

	public PrimeFinder(int m, int n) {
		this.m = m;
		this.n = n;
		this.primeChk = new int[n + 1];
		this.findPrime();
	}

	public void findPrime() {
		for (int i = 2; i <= n; i++) {
			if (primeChk[i] == 0) {
				primeChk[i] = PRIME;
				if (i <= (n / i)) {
					for (int j = i * i; j <= n; j += i) {
						primeChk[j] = NOT_PRIME;

					}
				}
			}
		}
	}

	public void printPrime() {
		StringBuffer res = new StringBuffer();
		for (int num = m; num <= n; num++) {
			if (primeChk[num] == PRIME) {
				res.append(num + "\n");
			}
		}
		System.out.println(res);
	}

}
