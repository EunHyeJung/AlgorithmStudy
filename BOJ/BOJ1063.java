import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) {
		try {
			Chess chess = new Chess();
			chess.moveKing();
			chess.printOutput();
		} catch (IOException e) {

		}
	}
}

class Chess {
	private static final int[][] DIR = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };
	private final int N = 8;

	private enum MOVING_DIR {
		T, RT, R, RB, B, LB, L, LT
	};

	private Pos king;
	private Pos stone;
	private int cmdCnt;

	public Chess() throws IOException {
		this.init();

	}

	public void init() throws IOException {
		String[] inputs = IOUtils.readInput().split(" ");
		king = new Pos(N - (inputs[0].charAt(1) - '0'), (inputs[0].charAt(0) - 65));
		stone = new Pos(N - (inputs[1].charAt(1) - '0'), (inputs[1].charAt(0) - 65));
		this.cmdCnt = Integer.parseInt(inputs[2]);
	}

	public void moveKing() throws IOException {
		for (int c = 0; c < cmdCnt; c++) {
			String cmd = IOUtils.readInput();
			int cmdDir = MOVING_DIR.valueOf(cmd).ordinal();
			Pos nextKingPos = new Pos(king.getY() + DIR[cmdDir][0], king.getX() + DIR[cmdDir][1]);

			// 킹의 이동가능 여부 확인, 이동불가능하면 다음명령 진행
			if (!isAccessible(nextKingPos)) {
				continue;
			}
			// 킹과 돌이 만나는지 확인
			if (isMeetStone(nextKingPos)) {
				Pos nextStonePos = new Pos(stone.getY() + DIR[cmdDir][0], stone.getX() + DIR[cmdDir][1]);
				// 돌을 이동시킬 수 없으면 킹도 이동못시킴. 다음 명령 진행  
				if (!isAccessible(nextStonePos)) {
					continue;
				}
				stone = nextStonePos;
				king = nextKingPos;
			} else {
				king = nextKingPos;
			}
		}
	}

	public boolean isMeetStone(Pos pos) {
		return pos.getY() == stone.getY() && pos.getX() == stone.getX();
	}

	public boolean isAccessible(Pos pos) {
		if (pos.getX() < 0 || pos.getY() < 0 || pos.getX() > N - 1 || pos.getY() > N - 1) {
			return false;
		}
		return true;
	}

	public void printOutput() throws IOException {
		IOUtils.writeOutput((char) (65 + king.getX()) + "" + (N - king.getY()) + "\n");
		IOUtils.writeOutput((char) (65 + stone.getX()) + "" + (N - stone.getY()) + "\n");
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

class IOUtils {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void writeOutput(String input) throws IOException {
		bw.write(input);
		bw.flush();
	}

}
