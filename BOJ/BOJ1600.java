import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try {
            MonkeyController monkeyController = new MonkeyController();
            System.out.println(monkeyController.getMinMovingCnt());
        } catch (IOException e) {

        }
    }


}

class MonkeyController {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int[][] HORSE_DIR = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    private static final int BOX = 1;
    private int k;
    private int w, h;
    private int[][] board;
    private int[][][] chk; // y, x 위치에 올떄까지 k번 횟수가 남았을때 최소 움직인 동작수

    public MonkeyController() throws IOException {
        this.k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        this.w = Integer.parseInt(st.nextToken());
        this.h = Integer.parseInt(st.nextToken());
        this.board = new int[h][w];
        this.chk = new int[h][w][k + 1];
        this.initMap();
    }

    public void initMap() throws IOException {
        for (int y = 0; y < h; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < w; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public boolean isAccessible(int y, int x) {
        return y >= 0 && x >= 0 && y < h && x < w && board[y][x] != BOX;
    }


    public void moveMonkey() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, k));
        chk[0][0][k] = 0;

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            int curY = curPos.getY();
            int curX = curPos.getX();
            int curK = curPos.getK();

            for (int d = 0, dn = DIR.length; d < dn; d++) {
                int nextY = curY + DIR[d][0];
                int nextX = curX + DIR[d][1];
                if (isAccessible(nextY, nextX)) {
                    if (chk[nextY][nextX][curK] == 0 || chk[nextY][nextX][curK] > chk[curY][curX][curK] + 1) {
                        chk[nextY][nextX][curK] = chk[curY][curX][curK] + 1;
                        queue.add(new Pos(nextY, nextX, curK));
                    }
                }
            }
            if (curK > 0) {
                for (int d = 0, dn = HORSE_DIR.length; d < dn; d++) {
                    int nextY = curY + HORSE_DIR[d][0];
                    int nextX = curX + HORSE_DIR[d][1];
                    if (isAccessible(nextY, nextX)) {
                        if (chk[nextY][nextX][curK - 1] == 0 || chk[nextY][nextX][curK - 1] > chk[curY][curX][curK] + 1) {
                            chk[nextY][nextX][curK - 1] = chk[curY][curX][curK] + 1;
                            queue.add(new Pos(nextY, nextX, curK - 1));
                        }
                    }
                }
            }
        }
    }

    public int getMinMovingCnt() {
        moveMonkey();

        int minCnt = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (chk[h - 1][w - 1][i] > 0) {
                minCnt = Math.min(chk[h - 1][w - 1][i], minCnt);
            }
        }
        return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
    }
}

class Pos {
    private int y;
    private int x;
    private int k;

    public Pos(int y, int x, int k) {
        this.y = y;
        this.x = x;
        this.k = k;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getK() {
        return k;
    }
}
