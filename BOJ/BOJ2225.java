import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* @source https://www.acmicpc.net/problem/2225
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.21
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);

		int[][] dp = new int[n + 1][k + 1];

		Arrays.fill(dp[0], 1);

		for (int i = 1; i <= n; i++) {
			for (int c = 1; c <= k; c++) {
				for (int j = 0; j <= i; j++) {
					dp[i][c] += dp[i - j][c - 1];
					dp[i][c] %= 1000000000;
				}
			}
		}
		System.out.println(dp[n][k]);
	}

}
