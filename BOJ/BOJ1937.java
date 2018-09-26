import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* @source https://www.acmicpc.net/problem/1937
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.26
*/
public class Main {

	public static void main(String[] args) throws IOException {
		PandaController pandaController = new PandaController();
		int res = pandaController.getDayOfSurvive();
		System.out.println(res);
	}

}

class PandaController {
	private static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private int n;
	private int[][] forest;
	private int[][] dp;

	public PandaController() throws IOException {
		this.init();
	}

	public void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.n = Integer.parseInt(br.readLine());
		this.forest = new int[n][n];
		this.dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				forest[i][j] = Integer.parseInt(inputs[j]);
				dp[i][j] = -1;
			}
		}
	}

	public boolean isAccessible(int y, int x) {
		if (y < 0 || x < 0 || y > n - 1 || x > n - 1) {
			return false;
		}
		return true;
	}

	public int getDayOfSurvive() {
		int maxDay = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				maxDay = Math.max(maxDay, go(y, x));
			}
		}
		return maxDay;
	}


	public int go(int curY, int curX) {
		dp[curY][curX] = 1;
		int surviveDay = 0;
		for (int d = 0; d < DIR.length; d++) {
			int nextY = curY + DIR[d][0];
			int nextX = curX + DIR[d][1];
			if (isAccessible(nextY, nextX) && forest[nextY][nextX] > forest[curY][curX]) {
				if(dp[nextY][nextX] > 0) {
					surviveDay = Math.max(surviveDay, dp[nextY][nextX]);
					continue;
				}
				surviveDay = Math.max(surviveDay, go(nextY, nextX));
			}
		}
		dp[curY][curX] += surviveDay;

		return dp[curY][curX];
	}
}
