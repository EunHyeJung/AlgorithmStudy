import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) {
		try {
			int n = Integer.parseInt(IOUtils.readInput());
			int[] wine = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				wine[i] = Integer.parseInt(IOUtils.readInput());
			}
			int[][] dp = new int[n + 1][3];
			dp[1][0] = 0;
			dp[1][1] = wine[1];
			dp[1][2] = wine[1];

			for (int i = 2; i <= n; i++) {
				dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
				dp[i][1] = dp[i - 1][0] + wine[i];
				dp[i][2] = dp[i - 1][1] + wine[i];
			}
			int res = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
			IOUtils.writeOutput(res);
		} catch (IOException e) {

		}
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
