import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) {
		try {
			HorseController horseController = new HorseController();
			horseController.init();
			horseController.getMaxMovingCell();
		} catch (IOException e) {

		}
	}

}

class HorseController {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int[][] DIR = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private int R, C;
	private int[][] map;
	private int[][] mark;
	private int maxCnt;

	public void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		R = Integer.parseInt(inputs[0]);
		C = Integer.parseInt(inputs[1]);
		map = new int[R][C];
		mark = new int[R][C];

		for (int i = 0; i < R; i++) {
			String mapInfo = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = mapInfo.charAt(j) - 65;
			}
		}
		maxCnt = 0;
	}

	public void getMaxMovingCell() throws IOException {
		Pos pos = new Pos(0, 0);
		boolean[][] visited = new boolean[R][C];
		boolean[] alphaChk = new boolean[26];
		visited[pos.getY()][pos.getX()] = true;
		alphaChk[map[pos.getY()][pos.getX()]] = true;
		mark[pos.getY()][pos.getX()] = 1;
		moveHorse(pos, visited, alphaChk, 1);

		bw.write(maxCnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public boolean isAccessible(int y, int x) {
		if (y < 0 || x < 0 || y > R - 1 || x > C - 1) {
			return false;
		}
		return true;
	}

	public void moveHorse(Pos pos, boolean[][] visited, boolean[] alphaChk, int depth) {
		maxCnt = Math.max(depth, maxCnt);
		for (int d = 0; d < DIR.length; d++) {
			int nextY = pos.getY() + DIR[d][0];
			int nextX = pos.getX() + DIR[d][1];
			if (isAccessible(nextY, nextX) && !visited[nextY][nextX] && !alphaChk[map[nextY][nextX]]) {
				visited[nextY][nextX] = true;
				alphaChk[map[nextY][nextX]] = true;
				moveHorse(new Pos(nextY, nextX), visited, alphaChk, depth + 1);

				alphaChk[map[nextY][nextX]] = false;
				visited[nextY][nextX] = false;
			}
		}
	}

}

class Pos {
	private int y;
	private int x;

	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
}
