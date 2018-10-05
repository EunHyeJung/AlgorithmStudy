import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/11653
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.05
*/
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		if (n == 1) {
			return;
		}
		for (int p = 2; p * p <= n; p++) {
			while (n % p == 0) {
				sb.append(p + "\n");
				n /= p;
			}
		}
		if(n > 1) {
			sb.append(n + "\n");
		}
