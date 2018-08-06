import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * BOJ 1780. 종이의 개수
 * @author EunHyeJung 
 * @email ehye826@gmail.com
 * @date 2018.08.06
 * @link https://www.acmicpc.net/problem/1780
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		PaperCounter paperCounter = new PaperCounter();
		paperCounter.inputDate();
		int[] res = paperCounter.getCount();
		for (int cnt : res) {
			IOUtil.bw.write(cnt + "\n");
		}

		IOUtil.bw.flush();
	}
}

class IOUtil {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}

class PaperCounter {
	private int[][] board;
	private int n;
	private int[] count;

	public void inputDate() throws IOException {
		this.n = Integer.parseInt(IOUtil.br.readLine());

		this.board = new int[n][n];
		for (int y = 0; y < n; y++) {
			String[] inputs = IOUtil.br.readLine().split(" ");
			for (int x = 0; x < n; x++) {
				board[y][x] = Integer.parseInt(inputs[x]);
			}
		}
		this.count = new int[3];
	}

	public int[] getCount() {
		explore(0, 0, n);
		return this.count;
	}

	public void explore(int i, int j, int n) {
		for (int y = i; y < (i + n); y++) {
			for (int x = j; x < (j + n); x++) {
				if (board[i][j] != board[y][x]) {
					explore(i, j, n / 3);
					explore(i, j + n / 3, n / 3);
					explore(i, j + n / 3 * 2, n / 3);
					explore(i + n / 3, j, n / 3);
					explore(i + n / 3, j + n / 3, n / 3);
					explore(i + n / 3, j + n / 3 * 2, n / 3);
					explore(i + n / 3 * 2, j, n / 3);
					explore(i + n / 3 * 2, j + n / 3, n / 3);
					explore(i + n / 3 * 2, j + n / 3 * 2, n / 3);
					return;
				}
			}
		}

		this.count[board[i][j] + 1] += 1;

	}
}
