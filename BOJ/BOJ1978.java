import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/1978
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.06
*/
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			if (isPrime(Integer.parseInt(st.nextToken()))) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}

	public static boolean isPrime(int num) {
			if (num < 2) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
