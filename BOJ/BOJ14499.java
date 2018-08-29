import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) {
		try {
			DiceController diceController = new DiceController();
			diceController.init();
			diceController.executeCmd();
		} catch (IOException e) {

		}
	}
}

class DiceController {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int BOTTOM = 1;
	private static final int TOP = 3;
	private static final int EAST = 1, WEST = 2, NORTH = 3, SOUTH = 4;

	private int[] dice;
	private int[][] map;
	private int n, m;
	private Pos dicePos;
	private int k;

	public DiceController() {
		dice = new int[6];
	}

	public void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		dicePos = new Pos(Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]));
		k = Integer.parseInt(inputs[4]);
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}

	public void executeCmd() throws IOException {

		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < k; i++) {
			int dir = Integer.parseInt(inputs[i]);
			switch (dir) {
			case EAST:
				if (rotateForEast()) {
					bw.write(dice[TOP] + "\n");
				}
				break;
			case WEST:
				if (rotateForWest()) {
					bw.write(dice[TOP] + "\n");
				}
				break;
			case NORTH:
				if (rotateForNorth()) {
					bw.write((dice[TOP] + "\n"));
				}
				break;
			case SOUTH:
				if (rotateForSouth()) {
					bw.write(dice[TOP] + "\n");
				}
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public boolean isAccessible(Pos pos) {
		if (pos.getY() < 0 || pos.getX() < 0 || pos.getY() > n - 1 || pos.getX() > m - 1) {
			return false;
		}
		return true;
	}

	public boolean isMapEmpty() {
		return map[dicePos.getY()][dicePos.getX()] == 0;
	}

	public void updateBottom() {
		if (isMapEmpty()) {
			map[dicePos.getY()][dicePos.getX()] = dice[BOTTOM];
		} else {
			dice[BOTTOM] = map[dicePos.getY()][dicePos.getX()];
			map[dicePos.getY()][dicePos.getX()] = 0;
		}
	}

	public boolean rotateForEast() {
		Pos nextPos = new Pos(dicePos.getY(), dicePos.getX() + 1);
		if (!isAccessible(nextPos)) {
			return false;
		}
		dicePos = nextPos;
		swap(1, 5);
		swap(3, 4);
		swap(4, 5);
		updateBottom();
		return true;
	}

	public boolean rotateForWest() {
		Pos nextPos = new Pos(dicePos.getY(), dicePos.getX() - 1);
		if (!isAccessible(nextPos)) {
			return false;
		}
		dicePos = nextPos;
		swap(1, 4);
		swap(3, 5);
		swap(4, 5);
		updateBottom();
		return true;
	}

	public boolean rotateForNorth() {
		Pos nextPos = new Pos(dicePos.getY() - 1, dicePos.getX());
		if (!isAccessible(nextPos)) {
			return false;
		}
		dicePos = nextPos;
		swap(0, 1);
		swap(1, 2);
		swap(2, 3);
		updateBottom();
		return true;
	}

	public boolean rotateForSouth() {
		Pos nextPos = new Pos(dicePos.getY() + 1, dicePos.getX());
		if (!isAccessible(nextPos)) {
			return false;
		}
		dicePos = nextPos;
		swap(0, 3);
		swap(1, 3);
		swap(2, 3);
		updateBottom();
		return true;
	}

	public void swap(int pos1, int pos2) {
		int tmp = dice[pos1];
		dice[pos1] = dice[pos2];
		dice[pos2] = tmp;
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

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}
}
