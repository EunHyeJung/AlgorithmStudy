package _2018_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 7569. 토마토
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.08.07
 * @link https://www.acmicpc.net/problem/7569
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Tomato tomato = new Tomato();
		tomato.init();
		IOUtil.bw.write(tomato.getDay() + "\n");
		IOUtil.bw.flush();
	}
}

class IOUtil {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}

class Tomato {
	public static final int NOT_IN = -1;
	public static final int NOT_RIPEN = 0;
	public static final int RIPEN = 1;
	public static final int[][] DIR = {
			{1, 0, 0},
			{-1, 0, 0},
			{0, 1, 0},
			{0, -1, 0},
			{0, 0, 1},
			{0, 0, -1}
	};
	
	private int m;
	private int n;
	private int h;
	private int[][][] box;
	private int[][][] chk;
	private Queue<Pos> queue;

	public void init() throws IOException {
		String[] inputs = IOUtil.br.readLine().split(" ");
		this.m = Integer.parseInt(inputs[0]);
		this.n = Integer.parseInt(inputs[1]);
		this.h = Integer.parseInt(inputs[2]);
		this.box = new int[m][n][h];
		this.chk = new int[m][n][h];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				inputs = IOUtil.br.readLine().split(" ");
				for (int k = 0; k < m; k++) {
					box[k][j][i] = Integer.parseInt(inputs[k]);
				}
			}
		}

		this.queue = new LinkedList<>();
	}

	public boolean isAccessible(int x, int y, int z) {
		if (x < 0 || y < 0 || z < 0 || x > m - 1 || y > n - 1 || z > h - 1) {
			return false;
		}
		if (chk[x][y][z] > 0 || chk[x][y][z] == -1) {
			return false;
		}
		return true;
	}

	public int getDay() {
		int day = 0;

		int cntOfEmpty = 0;

		for (int z = 0; z < h; z++) {
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if (box[x][y][z] == RIPEN) {
						chk[x][y][z] = 1;
						queue.add(new Pos(x, y, z));
					} else if (box[x][y][z] == NOT_IN) {
						chk[x][y][z] = -1;
						cntOfEmpty += 1;
					}
				}
			}
		}

		if ((queue.size() + cntOfEmpty) == m * n * h) {
			return (day = 0);
		}

		day = explore();

		for (int z = 0; z < h; z++) {
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if (chk[x][y][z] == 0) {
						return (day = -1);
					}
					day = Math.max(day, chk[x][y][z]);
				}
			}
		}

		return day - 1;
	}

	public int explore() {
		int day = 0;
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			int curDay = chk[x][y][z];
			
			for(int d = 0, dn = DIR.length ; d< dn; d++) {
				int nextX = x + DIR[d][0];
				int nextY = y + DIR[d][1];
				int nextZ = z + DIR[d][2];
				
				if(isAccessible(nextX, nextY, nextZ)) {
					chk[nextX][nextY][nextZ] = curDay + 1;
					queue.add(new Pos(nextX, nextY, nextZ));
				}
			}
			
		}
		return day;
	}

}

class Pos {
	private int x; // 가로
	private int y; // 세로
	private int z; // 높이

	public Pos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
}
