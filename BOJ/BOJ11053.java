import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
* @source https://www.acmicpc.net/problem/11053
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

		int[] dp = new int[n];
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
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
