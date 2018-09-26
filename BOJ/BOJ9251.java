import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* @link https://www.acmicpc.net/problem/9251
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.26
*/
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();

		System.out.println(getLengthOfLCS(str1, str2));
	}

	public static int getLengthOfLCS(char[] str1, char[] str2) {
		int lenOfStr1 = str1.length;
		int lenOfStr2 = str2.length;

		int[][] dp = new int[lenOfStr1 + 1][lenOfStr2 + 1];
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}
		}

		return dp[lenOfStr1][lenOfStr2];
	}
}
