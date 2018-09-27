import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
* @source https://www.acmicpc.net/problem/2302
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.27
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1]; // dp[i] : n=i일때 가능한 배치방법의 수
		boolean[] vipSeat = new boolean[n + 1];

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			vipSeat[Integer.parseInt(br.readLine())] = true;
		}

		// init
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1];
			if (vipSeat[i] || vipSeat[i - 1]) {
				continue;
			}
			dp[i] += dp[i - 2];
		}

		System.out.println(dp[n]);
	}
}
