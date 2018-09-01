import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		try {
			Lab lab = new Lab();
			lab.init();
			lab.countMaxSafeArea();
		} catch (IOException e) {

		}
	}
}

class Lab {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int[][] DIR = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static final int EMPTY = 0;
	private static final int WALL = 1;
	private static final int VIRUS = 2;

	private static List<Pos> emptyList;
	private int[][] map;
	private boolean[][] chk;
	private int n, m;

	public void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		map = new int[n][m];
		chk = new boolean[n][m];
		emptyList = new ArrayList<>();

		for (int y = 0; y < n; y++) {
			inputs = br.readLine().split(" ");
			for (int x = 0; x < m; x++) {
				map[y][x] = Integer.parseInt(inputs[x]);
				if (map[y][x] == EMPTY) {
					emptyList.add(new Pos(y, x));
				}
			}
		}
	}

	public void countMaxSafeArea() throws IOException {

		int safeAreaCnt = 0;
		int emptyCnt = emptyList.size();
		for (int i = 0; i < emptyCnt; i++) {
			for (int j = i + 1; j < emptyCnt; j++) {
				for (int k = j + 1; k < emptyCnt; k++) {
					Pos pos1 = emptyList.get(i);
					Pos pos2 = emptyList.get(j);
					Pos pos3 = emptyList.get(k);
					install(pos1, pos2, pos3);
					chk = new boolean[n][m];
					checkVirus();
					safeAreaCnt = Math.max(safeAreaCnt, countSafeArea());
					restore(pos1, pos2, pos3);
				}
			}
		}

		bw.write(safeAreaCnt + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	public int countSafeArea() {
		int cnt = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (map[y][x] == WALL || chk[y][x]) {
					cnt += 1;
				}
			}
		}
		return n * m - cnt;
	}

	public void checkVirus() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (map[y][x] == VIRUS) {
					spreadVirus(new Pos(y, x));
				}
			}
		}
	}

	public boolean isAccssible(int y, int x) {
		if (y < 0 || x < 0 || y > n - 1 || x > m - 1) {
			return false;
		}
		return map[y][x] != WALL;
	}

	public void spreadVirus(Pos pos) {
		Queue<Pos> virusQueue = new LinkedList<Pos>();
		virusQueue.add(pos);
		chk[pos.getY()][pos.getX()] = true;

		while (!virusQueue.isEmpty()) {
			Pos curPos = virusQueue.poll();
			int curY = curPos.getY();
			int curX = curPos.getX();
			for (int i = 0; i < DIR.length; i++) {
				int nextY = curY + DIR[i][0];
				int nextX = curX + DIR[i][1];
				if (isAccssible(nextY, nextX) && !chk[nextY][nextX]) {
					chk[nextY][nextX] = true;
					virusQueue.add(new Pos(nextY, nextX));
				}
			}
		}
	}

	public boolean isPossibleInstallation(int y, int x) {
		if (y < 0 || x < 0 || y > n - 1 || x > m - 1) {
			return false;
		}
		return map[y][x] == EMPTY;
	}

	public void restore(Pos pos1, Pos pos2, Pos pos3) {
		map[pos1.getY()][pos1.getX()] = EMPTY;
		map[pos2.getY()][pos2.getX()] = EMPTY;
		map[pos3.getY()][pos3.getX()] = EMPTY;
	}

	public void install(Pos pos1, Pos pos2, Pos pos3) {
		map[pos1.getY()][pos1.getX()] = WALL;
		map[pos2.getY()][pos2.getX()] = WALL;
		map[pos3.getY()][pos3.getX()] = WALL;
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
