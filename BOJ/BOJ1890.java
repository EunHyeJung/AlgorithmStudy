import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/1890
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.01
*/
public class Main {
	public static void main(String[] args) throws IOException {
		JumpGame jumpGame = new JumpGame();
		System.out.println(jumpGame.getCntOfCase());
	}
}

class JumpGame {
	public static final int[][] DIR = { { 1, 0 }, { 0, 1 } };
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	private int n;
	private int[][] map;
	private long[][] dp;

	public JumpGame() throws IOException {
		this.n = Integer.parseInt(br.readLine());
		this.map = new int[n][n];
		this.dp = new long[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public long getCntOfCase() {
		jump();
		return dp[n - 1][n - 1];
	}

	public void jump() {
		dp[0][0] = 1;

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (map[y][x] == 0) {
					continue;
				}
				if (isAccessible(y + map[y][x])) {
					dp[y + map[y][x]][x] += dp[y][x];
				}
				if (isAccessible(x + map[y][x])) {
					dp[y][x + map[y][x]] += dp[y][x];
				}

			}
		}
	}

	public boolean isAccessible(int pos) {
		return pos < n;
	}
}
