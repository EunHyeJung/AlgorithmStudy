import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < caseCnt; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(getNumOfCaes(n));
		}

	}

	public static int getNumOfCaes(int n) {
		if (n <= 3) {
			return n == 1 ? 1 : (n == 2) ? 2 : 4;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

}
