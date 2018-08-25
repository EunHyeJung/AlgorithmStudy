import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		RobotCleaner robotCleaner = new RobotCleaner();
		robotCleaner.init();
		int res = robotCleaner.cleanRoom();
		System.out.println(res);
	}

}

class RobotCleaner {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static final int[][] DIR = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	public static final int WALL = 1;
	public static final int EMPTY = 0;

	private int n;
	private int m;
	private int[][] room;
	private boolean[][] isCleaned;
	private int cleanedRoomCnt;
	private Robot robot;

	public void init() throws IOException {
		String[] inputs = br.readLine().split(" ");

		this.n = Integer.parseInt(inputs[0]);
		this.m = Integer.parseInt(inputs[1]);
		this.room = new int[n][m];
		this.isCleaned = new boolean[n][m];
		this.cleanedRoomCnt = 0;

		inputs = br.readLine().split(" ");
		this.robot = new Robot(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));

		for (int i = 0; i < n; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}

	public boolean isAccessible(int r, int c) {
		if (r < 0 || c < 0 || r > n - 1 || c > m - 1) {
			return false;
		}

		return room[r][c] != WALL;
	}

	public int cleanRoom() {
		isCleaned[robot.getR()][robot.getC()] = true;
		cleanedRoomCnt += 1;
		int rotatedCnt = 0;
		while (true) {
			int curR = robot.getR();
			int curC = robot.getC();
			int curDir = robot.getDir();
			int nextDir = (curDir - 1) < 0 ? 3 : curDir - 1;

			if (isAccessible(curR + DIR[nextDir][0], curC + DIR[nextDir][1])
					&& !isCleaned[curR + DIR[nextDir][0]][curC + DIR[nextDir][1]]) {
				rotatedCnt = 0;
				// 2 -1왼쪽 방향에 청소하지 않는 공간이 존재한느 경우  1
				int nextR = curR + DIR[nextDir][0];
				int nextC = curC + DIR[nextDir][1];

				isCleaned[nextR][nextC] = true;
				cleanedRoomCnt += 1;
				robot = new Robot(nextR, nextC, nextDir);

			} else {
				// 2-2 왼쪽 방향에 청소할 공간이 없다면 회전만함
				rotatedCnt += 1;
				robot = new Robot(curR, curC, nextDir);
			}
			if (rotatedCnt > 4) { // 4방향 히전했으면 뒤로 회전 
				int nextR = curR - DIR[curDir][0];
				int nextC = curC - DIR[curDir][1];
				if (isAccessible(nextR, nextC)) { // 뒤로 백
					robot = new Robot(nextR, nextC, curDir);
					rotatedCnt = 0;
				} else {
					return cleanedRoomCnt;
				}
			}

		}

	}
}

class Robot {
	private int r;
	private int c;
	private int dir;

	public Robot() {

	}

	public Robot(int r, int c, int dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

	public int getDir() {
		return dir;
	}
}
