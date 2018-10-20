import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @source https://www.acmicpc.net/problem/3085
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.10.20
 */
public class Main {
    public static void main(String[] args) {
        try {
            CandyGame candyGame = new CandyGame();
            System.out.println(candyGame.playGame());

        } catch (IOException e) {

        }
    }

}

class CandyGame {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int n;
    private char[][] board;


    public CandyGame() throws IOException {
        this.n = Integer.parseInt(br.readLine());
        this.board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }
    }

    public int getCandyCnt(int i, int j) {
        int cnt = 1;
        int maXCnt = 0;
        int y = i - 1;
        while (y >= 0 && board[y][j] == board[i][j]) {
            y--;
            cnt++;
        }
        y = i + 1;
        while (y < n && board[y][j] == board[i][j]) {
            y++;
            cnt++;
        }
        maXCnt = Math.max(cnt, maXCnt);
        int x = j - 1;
        cnt = 1;
        while (x >= 0 && board[i][x] == board[i][j]) {
            x--;
            cnt++;
        }
        x = j + 1;
        while (x < n && board[i][x] == board[i][j]) {
            x++;
            cnt++;
        }
        maXCnt = Math.max(cnt, maXCnt);
        return maXCnt;
    }

    public void swap(int i, int j, int k, int l) {
        char tmp = board[i][j];
        board[i][j] = board[k][l];
        board[k][l] = tmp;
    }

    public int playGame() {
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 가로로 캔디 교환
                if (j + 1 < n) {
                    swap(i, j, i, j + 1);
                    maxCnt = Math.max(getCandyCnt(i, j), maxCnt);
                    maxCnt = Math.max(getCandyCnt(i, j + 1), maxCnt);
                    swap(i, j, i, j + 1);
                }
                // 세로로 캔디 교환
                if (i + 1 < n) {
                    swap(i, j, i + 1, j);
                    maxCnt = Math.max(getCandyCnt(i, j), maxCnt);
                    maxCnt = Math.max(getCandyCnt(i + 1, j), maxCnt);
                    swap(i, j, i + 1, j);
                }

            }
        }
        return maxCnt;
    }

}
