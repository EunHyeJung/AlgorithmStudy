import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* @source https://www.acmicpc.net/problem/2011
* @name EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.28
*/
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int res = getNumOfCase(input);
		System.out.println(res);

	}

	public static int getNumOfCase(char[] input) {
		int n = input.length;
		if (n < 2 || input[0] == '0') {
			return input[0] == '0' ? 0 : 1;
		}

		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		int prev = input[0] - '0';
		for (int i = 2; i <= n; i++) {
			int cur = input[i - 1] - '0';
			if (cur == 0 && (prev != 1 && prev != 2)) {
				return 0;
			}
			dp[i] = cur == 0 ? dp[i - 2] : dp[i - 1];
			if ((prev == 1 && cur > 0) || (prev == 2 && (cur >= 1 && cur <= 6))) {
				dp[i] += dp[i - 2];
			}
			prev = cur;
			dp[i] %= 1000000;
		}
		return dp[n];
	}
}
