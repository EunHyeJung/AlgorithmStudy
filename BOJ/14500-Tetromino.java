import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 14500. 테트로미노
 * @author EunHyeJung 
 * @email ehye826@gmail.com
 * @date 2018.06.28
 * @link https://www.acmicpc.net/problem/14500
 * 
 */
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		Tetromino tetromino = new Tetromino(n, m, board);
		int res = tetromino.getMaxSum();
		System.out.println(res);
	}

}

class Tetromino {
	private static final String[] TYPE = { "I", "O", "T", "SZ", "JL" };
	private int[][] board;
	private int n;
	private int m;

	public Tetromino(int n, int m, int[][] board) {
		this.n = n;
		this.m = m;
		this.board = board;
	}

	public int getMaxSum() {
		int maxSum = Integer.MIN_VALUE;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				for (int t = 0, numOfTypes = TYPE.length; t < numOfTypes; t++) {
					maxSum = Math.max(getSum(TYPE[t], y, x), maxSum);
				}

			}
		}

		return maxSum;
	}

	public int getSum(String type, int y, int x) {
		int sum = 0;
		switch (type) {
		case "I": {
			try {
				sum = board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y + 3][x];
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				sum = Math.max(board[y][x] + board[y][x + 1] + board[y][x + 2] + board[y][x + 3], sum);

			} catch (IndexOutOfBoundsException e) {
			}
			return sum;
		}
		case "O": {
			try {
				sum = board[y][x] + board[y + 1][x] + board[y][x + 1] + board[y + 1][x + 1];
			} catch (IndexOutOfBoundsException e) {

			}
			return sum;
		}
		case "T": {
			try {
				sum = board[y][x] + board[y][x + 1] + board[y][x + 2] + board[y + 1][x + 1];
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				sum = Math.max(board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y + 1][x + 1], sum);
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				sum = Math.max(board[y][x] + board[y][x + 1] + board[y][x + 2] + board[y - 1][x + 1], sum);
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				sum = Math.max(board[y][x] + board[y + 1][x - 1] + board[y + 1][x] + board[y + 2][x], sum);
			} catch (IndexOutOfBoundsException e) {
			}
			return sum;
		}

		case "SZ": {
			try {
				sum = board[y][x] + board[y + 1][x] + board[y + 1][x + 1] + board[y + 2][x + 1];
			} catch (IndexOutOfBoundsException e) {
			}

			try {
				sum = Math.max(board[y][x] + board[y + 1][x - 1] + board[y + 1][x] + board[y + 2][x - 1], sum);
			} catch (IndexOutOfBoundsException e) {

			}
			try {
				sum = Math.max(board[y][x] + board[y][x + 1] + board[y + 1][x + 1] + board[y + 1][x + 2], sum);
			} catch (IndexOutOfBoundsException e) {

			}
			try {
				sum = Math.max(board[y][x] + board[y][x + 1] + board[y - 1][x + 1] + board[y - 1][x + 2], sum);
			} catch (IndexOutOfBoundsException e) {
			}
			return sum;
		}
		case "JL": {
			try {
				sum = board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y + 2][x + 1];
				sum = Math.max(board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y][x + 1], sum);
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				sum = Math.max(board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y + 2][x - 1], sum);
				sum = Math.max(board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y][x - 1], sum);
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				sum = Math.max(board[y][x] + board[y + 1][x] + board[y + 1][x + 1] + board[y + 1][x + 2], sum);
				sum = Math.max(board[y][x] + board[y][x + 1] + board[y][x + 2] + board[y + 1][x + 2], sum);
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				sum = Math.max(board[y][x] + board[y][x + 1] + board[y][x + 2] + board[y - 1][x + 2], sum);
				sum = Math.max(board[y][x] + board[y - 1][x] + board[y - 1][x + 1] + board[y - 1][x + 2], sum);
			} catch (IndexOutOfBoundsException e) {
			}
			return sum;
		}
		}
		return sum;

	}

}