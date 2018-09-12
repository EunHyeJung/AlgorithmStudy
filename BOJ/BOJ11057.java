import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
* @date 2018.09.12
* @source https://www.acmicpc.net/problem/11057
*/
public class Main {
	public static void main(String[] args) {
		try {
			int n = Integer.parseInt(IOUtils.readInput());
			int res = getIncreasingNumsCnt(n);
			IOUtils.writeOutput(res);
		} catch (IOException e) {

		}
	}

	public static int getIncreasingNumsCnt(int n) {
		// dp[L][S] : 길이가  L이고, S로 시작하는 오르막수의 개수
		int[][] dp = new int[n + 1][10];

		// 길이가 1인 경우 초기값 설정
		Arrays.fill(dp[1], 1);

		// S 다음에 올 수 있는 수는 S + 1, S + 2, ..., S + M (S + M <=9)인것을 이용
		for (int l = 2; l <= n; l++) {
			for (int s = 0; s <= 9; s++) {
				for (int m = 0; s + m <= 9; m++) {
					dp[l][s] += dp[l - 1][s + m];
				}

				// 중간에 나눠주지 않으면 오버플로우 발생
				dp[l][s] %= 10007;
			}
		}

		int res = 0;
		for (int s = 0; s <= 9; s++) {
			res += dp[n][s];
			res %= 10007;
		}
		return res;
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
