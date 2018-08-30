import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) {
		try {
			SlopeInstaller slopeInstaller = new SlopeInstaller();
			slopeInstaller.init();
			slopeInstaller.countRoad();
		} catch (IOException e) {

		}

	}
}

class SlopeInstaller {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private int[][] board;
	private int n;
	private int length;
	private int roadCnt;

	public void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		this.n = Integer.parseInt(inputs[0]);
		this.board = new int[n][n];
		this.length = Integer.parseInt(inputs[1]);
		for (int y = 0; y < n; y++) {
			inputs = br.readLine().split(" ");
			for (int x = 0; x < n; x++) {
				board[y][x] = Integer.parseInt(inputs[x]);  
			}
		}
		this.roadCnt = 0;
	}

	public boolean isAccessable(int y, int x) {
		if (y < 0 || x < 0 || y > n - 1 || x > n - 1) {
			return false;
		}
		return true;
	}

	public void checkHorizontal() {
		for (int y = 0; y < n; y++) {
			boolean[] chk = new boolean[n];
			int x = 1;
			while (x < n) {
				if (board[y][x - 1] != board[y][x]) {
					if (board[y][x - 1] > board[y][x]) {
						if (!isAccessable(y, x - 1 + length) || (board[y][x - 1 + length] + 1 != board[y][x - 1])) {
							break;
						} else {
							boolean flag = false;
							int z = x;
							while (z <= x - 1 + length) {
								if (chk[z]) {
									flag = true;
									break;
								}
								chk[z++] = true;
							}
							if (flag) {
								break;
							}
						}
					} else {
						if (!isAccessable(y, x - length) || (board[y][x - length] + 1 != board[y][x])) {
							break;
						} else {
							boolean flag = false;
							int z = x - 1;
							while (z >= x - length) {
								if (chk[z]) {
									flag = true;
									break;
								}
								chk[z--] = true;
							}
							if (flag) {
								break;
							}
						}
					}

				}
				x += 1;
			}
			if (x == n) {
				roadCnt += 1;
			}
		}
	}

	public void checkVertical() {
		for (int x = 0; x < n; x++) {
			boolean[] chk = new boolean[n];
			int y = 1;
			while (y < n) {
				if (board[y - 1][x] != board[y][x]) {
					// 경사로 설치 가능 여부 확인
					if (board[y - 1][x] > board[y][x]) {
						if (!isAccessable(y - 1 + length, x) || (board[y - 1 + length][x] + 1 != board[y - 1][x])) {
							break;
						} else {
							int z = y;
							boolean flag = false;
							while (z <= y - 1 + length) {
								if (chk[z]) {
									flag = true;
									break;
								}
								chk[z++] = true;
							}
							if (flag) {

								break;
							}
						}
					} else {
						if (!isAccessable(y - length, x) || (board[y - length][x] + 1 != board[y][x])) {
							break;
						} else {
							int z = y - 1;
							boolean flag = false;
							while (z >= y - length) {
								if (chk[z]) {
									flag = true;
									break;
								}
								chk[z--] = true;
							}
							if (flag) {
								break;
							}
						}
					}
				}
				y += 1;

			}
			if (y == n) {
				roadCnt += 1;
			}
		}
	}

	public void countRoad() throws IOException {
		checkHorizontal();
		checkVertical();
		bw.write(roadCnt + "\n");
		bw.flush();
	}

}
