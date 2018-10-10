import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/1726
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.10
*/
public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Robot robot = new Robot();
            int minCmdCnt = robot.getMinCmdCnt();
            System.out.println(minCmdCnt);
        } catch (IOException e) {

        }
    }
}

class Robot {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int DN = 4;
    public static final int BLANK = 0;
    private int m, n;
    private int[][] map;
    private int[][][] chk; // y,x에서 dir방향을 바라보도록하는 최소명령횟수
    private Pos stPos;
    private Pos destPos;

    public Robot() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        this.m = Integer.parseInt(st.nextToken());
        this.n = Integer.parseInt(st.nextToken());
        this.map = new int[m][n];
        this.chk = new int[m][n][DN];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                Arrays.fill(chk[y][x], Integer.MAX_VALUE);
            }
        }
        this.initMap();
        st = new StringTokenizer(br.readLine(), " ");
        int[] tmp = {0, 2, 1, 3};
        stPos = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, tmp[Integer.parseInt(st.nextToken()) - 1]);
        st = new StringTokenizer(br.readLine(), " ");
        destPos = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, tmp[Integer.parseInt(st.nextToken()) - 1]);
    }

    public void initMap() throws IOException {
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public boolean isAccessible(int nextY, int nextX, int curY, int curX) {

        if (nextY < 0 || nextX < 0 || nextY > m - 1 || nextX > n - 1) {
            return false;
        }
        int maxY = Math.max(nextY, curY);
        int minY = Math.min(nextY, curY);
        int maxX = Math.max(nextX, curX);
        int minX = Math.min(nextX, curX);
        for (int y = minY; y < maxY; y++) {
            if (map[y][curX] != BLANK) {
                return false;
            }
        }
        for (int x = minX; x <= maxX; x++) {
            if (map[curY][x] != BLANK) {
                return false;
            }
        }
        return true;
    }

    public int getMinCmdCnt() {
        moveRobot();
        return chk[destPos.getY()][destPos.getX()][destPos.getDir()];
    }

    public void moveRobot() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(stPos);
        chk[stPos.getY()][stPos.getX()][stPos.getDir()] = 0;

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            int curY = curPos.getY();
            int curX = curPos.getX();
            int curDir = curPos.getDir();
            // 지금 방향에서 왼쪽 혹은 오른쪽으로 이동
            // 왼쪽
            int nextDir = (curDir - 1) < 0 ? DN - 1 : curDir - 1;
            if (chk[curY][curX][nextDir] > chk[curY][curX][curDir] + 1) {
                chk[curY][curX][nextDir] = chk[curY][curX][curDir] + 1;
                queue.add(new Pos(curY, curX, nextDir));
            }
            // 오른쪽
            nextDir = (curDir + 1) % DN;
            if (chk[curY][curX][nextDir] > chk[curY][curX][curDir] + 1) {
                chk[curY][curX][nextDir] = chk[curY][curX][curDir] + 1;
                queue.add(new Pos(curY, curX, nextDir));
            }
            // go k (k : 1~3)
            for (int k = 1; k <= 3; k++) {
                int nextY = curY + DIR[curDir][0] * k;
                int nextX = curX + DIR[curDir][1] * k;

                if (isAccessible(nextY, nextX, curY, curX) && chk[nextY][nextX][curDir] > chk[curY][curX][curDir] + 1) {
                    chk[nextY][nextX][curDir] = chk[curY][curX][curDir] + 1;
                    queue.add(new Pos(nextY, nextX, curDir));
                }
            }
        }
    }

}

class Pos {
    private int y;
    private int x;
    private int dir;

    public Pos(int y, int x, int dir) {
        this.y = y;
        this.x = x;
        this.dir = dir;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDir() {
        return dir;
    }
}
