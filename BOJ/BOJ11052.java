import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) {
		try {
			int n = Integer.parseInt(IOUtils.readInput());

			String[] inputs = IOUtils.readInput().split(" ");
			int[] cost = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				cost[i] = Integer.parseInt(inputs[i - 1]);
			}
			int res = getMaxCardCnt(cost, n);
			IOUtils.writeOutput(res);

		} catch (IOException e) {

		}
	}

	public static int getMaxCardCnt(int[] cost, int n) {
		int[] dp = new int[n + 1];
		dp[1] = cost[1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], cost[j] + dp[i - j]);
			}
		}

		return dp[n];
	}

	public static int getMaxScore(int[][] sticker, int n) {
		int maxScore = 0;
		int[][] dp = new int[2][n];

		dp[0][0] = sticker[0][0];
		dp[0][1] = sticker[0][1];

		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.max(sticker[0][i] + dp[1][i - 1], dp[0][i - 1] + dp[1][i]);
			dp[1][i] = Math.max(sticker[1][i] + dp[0][i - 1], dp[1][i - 1] + dp[0][i]);
			System.out.println(dp[0][i] + " : " + dp[1][i]);
		}

		return maxScore;
	}

}

class IOUtils {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void writeOutput(int output) throws IOException {
		bw.write(output + "\n");
		bw.flush();
	}
}
