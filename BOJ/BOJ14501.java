import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			int t = Integer.parseInt(inputs[0]);
			int p = Integer.parseInt(inputs[1]);

			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
			if (i + t <= n) {
				dp[i + t] = Math.max(dp[i + t], dp[i] + p);
			}

		}
		System.out.println(dp[n]);
	}

}
