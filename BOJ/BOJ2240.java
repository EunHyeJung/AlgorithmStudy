import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/2240
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.02
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

     // dp[t][w][1] : t초이고 w번의 이동 횟수가 남았고 1번의 위치에 있을때 얻을 수 있는 최대의 자두의 개수
     // dp[t][w][1] : t초이고 w번의 이동 횟수가 남았고 2번의 위치에 있을때 얻을 수 있는 최대의 자두의 개수
		int[][][] dp = new int[t + 1][w + 2][3];
		for (int i = 1; i <= t; i++) {
			int pos = Integer.parseInt(br.readLine());
			for (int count = w; count >= 0; count--) {
				dp[i][count][1] = Math.max(dp[i - 1][count][1], dp[i - 1][count + 1][2]) + (pos == 1 ? 1 : 0);
				if (count <= 0) 	continue;
				dp[i][count - 1][2] = Math.max(dp[i - 1][count - 1][2], dp[i - 1][count][1]) + (pos == 2 ? 1 : 0);
			}
		}
		int max = 0;
		for (int count = w; count >= 0; count--) {
			max = Math.max(max, Math.max(dp[t][count][1], dp[t][count][2]));
		}
		System.out.println(max);
	}
}
