import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
* @source https://www.acmicpc.net/problem/10844
*/
public class Main {
	public static void main(String[] args) {
		try {
			int n = Integer.parseInt(IOUtils.readInput());

			int[][] dp = new int[n + 1][10];
			for (int i = 0; i <= 9; i++) {
				dp[1][i] = 1;
			}
			for (int l = 2; l <= n; l++) {
				for (int i = 0; i <= 9; i++) {
					if (i - 1 >= 0) {
						dp[l][i] += dp[l - 1][i - 1];
					}
					if (i + 1 <= 9) {
						dp[l][i] += dp[l - 1][i + 1];
					}
					dp[l][i] %= 1000000000;

				}

			}

			int res = 0;
			for (int i = 1; i <= 9; i++) {
				res += dp[n][i];
				res %= 1000000000;
			}
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
