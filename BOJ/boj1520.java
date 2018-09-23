import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
* @source https://www.acmicpc.net/problem/1520
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.23
*/
public class Main {
	public static void main(String[] args) throws IOException {
		Downhill downhill = new Downhill();
		IOUtils.writeOutput(downhill.getPathCnt());

	}
}

class Downhill {
	private static final int[][] DIR = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private int[][] map; // map[y][x] : y,x에서의 높이값을 가짐
	private int[][] dp; // dp[y][x] : y,x에서 시작해서 m,n으로 가는 내리막길개수
	private int m, n;

	public Downhill() throws IOException {
		this.init();
	}

	public void init() throws IOException {
		String[] inputs = IOUtils.readInput().split(" ");
		this.m = Integer.parseInt(inputs[0]);
		this.n = Integer.parseInt(inputs[1]);

		this.map = new int[m][n];
		this.dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			inputs = IOUtils.readInput().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
				dp[i][j] = -1;
			}
		}
	}

	public boolean isAccessible(int y, int x) {
		if (y < 0 || x < 0 || y > m - 1 || x > n - 1) {
			return false;
		}
		return true;
	}

	public int go(int curY, int curX) {
		if (curY == m - 1 && curX == n - 1) {
			return 1;
		}
		dp[curY][curX] = 0;
		for (int d = 0; d < DIR.length; d++) {
			int nextY = curY + DIR[d][0];
			int nextX = curX + DIR[d][1];

			if (isAccessible(nextY, nextX) && map[curY][curX] > map[nextY][nextX]) {
				if (dp[nextY][nextX] >= 0) {
					dp[curY][curX] += dp[nextY][nextX];
				} else {
					dp[curY][curX] += go(nextY, nextX);
				}
			}
		}
		return dp[curY][curX];
	}

	public int getPathCnt() {
		go(0, 0);
		//System.out.println("TOTAL_TMP : " + tmp);
		return dp[0][0];
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

	public static void writeOutput(String output) throws IOException {
		bw.write(output + "\n");
		bw.flush();
	}

	public static void closeResource() throws IOException {
		br.close();
		bw.close();
	}
}
