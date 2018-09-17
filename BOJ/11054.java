import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
* @source https://www.acmicpc.net/problem/11054
* @author EunHyeJung
* @email ehye826@gmail.com
*/
public class Main {
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(IOUtils.readInput());
		String[] inputs = IOUtils.readInput().split(" ");

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(inputs[i]);

		}

		int[][] dp = new int[n][2];
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[j][0] + 1 > dp[i][0]) {
					dp[i][0] = dp[j][0] + 1;
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			dp[i][1] = 1;
			for (int j = n - 1; j > i; j--) {
				if (nums[i] > nums[j] && dp[j][1] + 1 > dp[i][1]) {
					dp[i][1] = dp[j][1] + 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			maxLength = Math.max(maxLength, dp[i][0] + dp[i][1] - 1);
		}

		IOUtils.writeOutput(maxLength);
	}
}

class IOUtils {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void writeOutput(int output) throws IOException {
		bw.write(output + "\n");
		bw.flush();
	}
}
