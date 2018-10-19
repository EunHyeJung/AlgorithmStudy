import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @source https://www.acmicpc.net/problem/13459
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.10.19
 */
public class Main {
    public static void main(String[] args) {
        try {
            MarbleGame marbleGame = new MarbleGame();
            IOUtils.printOutput(marbleGame.playGame());
        } catch (IOException e) {

        }
    }
}

class MarbleGame {
    private static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final char BLANK = '.', WALL = '#';
    private static final char RED = 'R', BLUE = 'B';
    private int n, m;
    private char[][] map;
    private Point holePos;
    private Point redStPos, blueStPos;
    private int[][][][] chk;

    public MarbleGame() throws IOException {
        StringTokenizer st = new StringTokenizer(IOUtils.readInput(), " ");
        this.n = Integer.parseInt(st.nextToken());
        this.m = Integer.parseInt(st.nextToken());
        this.map = new char[n][m];
        this.initMap();
        this.chk = new int[n][m][n][m];  // redY, redX, blueY, blueX
    }

    public void initMap() throws IOException {
        for (int y = 0; y < n; y++) {
            String input = IOUtils.readInput();
            for (int x = 0; x < m; x++) {
                map[y][x] = input.charAt(x);
                if (map[y][x] == 'O') {
                    this.holePos = new Point(y, x);
                } else if (map[y][x] == RED) {
                    this.redStPos = new Point(y, x);
                    map[y][x] = BLANK;
                } else if (map[y][x] == BLUE) {
                    this.blueStPos = new Point(y, x);
                    map[y][x] = BLANK;
                }
            }
        }
    }

    public boolean isAccessible(int y, int x) {
        if (y < 0 || x < 0 || y > n - 1 || x > m - 1) {
            return false;
        }
        return (map[y][x] == BLANK || isHole(y, x));
    }

    public boolean isHole(int y, int x) {
        return holePos.getY() == y && holePos.getX() == x;
    }

    public Point moveMarbles(Point red, Point blue, char type, int d) {
        if (type == 'R') {
            int nextY = red.getY() + DIR[d][0];
            int nextX = red.getX() + DIR[d][1];
            while (isAccessible(nextY, nextX) && (isHole(nextY, nextX) || !(blue.getY() == nextY && blue.getX() == nextX))) {
                red.setPos(nextY, nextX);
                nextY += DIR[d][0];
                nextX += DIR[d][1];
                if (isHole(red.getY(), red.getX())) {
                    return red;
                }
            }
            return red;
        } else {
            int nextY = blue.getY() + DIR[d][0];
            int nextX = blue.getX() + DIR[d][1];
            while (isAccessible(nextY, nextX) && (isHole(nextY, nextX) || !(red.getY() == nextY && red.getX() == nextX))) {
                blue.setPos(nextY, nextX);
                nextY += DIR[d][0];
                nextX += DIR[d][1];
                if (isHole(blue.getY(), blue.getX())) {
                    return blue;
                }
            }
        }
        return blue;
    }


    // 구슬 굴리는 함수
    // 굴릴 방향에 다른 색의 구슬이 있다면 그 구슬 먼저 굴리고 굴러갈 수있음
    // 빨강, 파랑 구슬 중 어느것이 앞서 있는지 확인필요.
    public Points leanBoard(Point redPos, Point bluePos, int d) {
        if (redPos.getY() == bluePos.getY() && (d == 1 || d == 3)) {
            if (redPos.getX() > bluePos.getX()) {
                if (d == 1) { // 빨간 구슬 부터
                    redPos = moveMarbles(redPos, bluePos, RED, d);
                    bluePos = moveMarbles(redPos, bluePos, BLUE, d);
                } else { // d == 3, 파란구슬 부터
                    bluePos = moveMarbles(redPos, bluePos, BLUE, d);
                    redPos = moveMarbles(redPos, bluePos, RED, d);
                }
            } else {
                if (d == 1) { // 파란구슬부터
                    bluePos = moveMarbles(redPos, bluePos, BLUE, d);
                    redPos = moveMarbles(redPos, bluePos, RED, d);
                } else { // d == 3, 빨간구슬부터 굴러주자
                    redPos = moveMarbles(redPos, bluePos, RED, d);
                    bluePos = moveMarbles(redPos, bluePos, BLUE, d);
                }
            }
        } else if (redPos.getX() == bluePos.getX() && (d == 0 || d == 2)) {
            if (redPos.getY() > bluePos.getY()) {
                if (d == 0) { //파란 구슬 부터
                    bluePos = moveMarbles(redPos, bluePos, BLUE, d);
                    redPos = moveMarbles(redPos, bluePos, RED, d);
                } else { // d == 2, 빨간 구슬 부터
                    redPos = moveMarbles(redPos, bluePos, RED, d);
                    bluePos = moveMarbles(redPos, bluePos, BLUE, d);
                }
            } else { // redPos.getY() < blusPos.getY()
                if (d == 0) { // 빨간구슬부터
                    redPos = moveMarbles(redPos, bluePos, RED, d);
                    bluePos = moveMarbles(redPos, bluePos, BLUE, d);
                } else { // d == 2, 파란 구슬부터 굴러주자
                    bluePos = moveMarbles(redPos, bluePos, BLUE, d);
                    redPos = moveMarbles(redPos, bluePos, RED, d);
                }
            }
        } else { // 구슬 굴리는 순서 상관없음
            redPos = moveMarbles(redPos, bluePos, RED, d);
            bluePos = moveMarbles(redPos, bluePos, BLUE, d);
        }
        return new Points(redPos, bluePos); // 구슬을 굴리고 난 후의 최종 위치 return
    }

    public boolean isSamePos(Point curPos, Point nextPos) {
        return curPos.getY() == nextPos.getY() && curPos.getX() == nextPos.getX();
    }

    public int playGame() {
        Queue<Points> queue = new LinkedList<>();
        queue.add(new Points(redStPos, blueStPos));
        int turn = Integer.MAX_VALUE;


        while (!queue.isEmpty()) {
            Points marblePoints = queue.poll();
            Point red = marblePoints.getRedPos();
            Point blue = marblePoints.getBluePos();

            if (isHole(red.getY(), red.getX()) && !isHole(blue.getY(), blue.getX())) {
                turn = Math.min(chk[red.getY()][red.getX()][blue.getY()][blue.getX()], turn);
                continue;
            }

            // 위, 아래, 가로, 세로 4방향 구슬 돌리기
            for (int d = 0, dn = DIR.length; d < dn; d++) {
                Points nextMarblePoints = leanBoard(new Point(red.getY(), red.getX()), new Point(blue.getY(), blue.getX()), d);
                Point nextRed = nextMarblePoints.getRedPos();
                Point nextBlue = nextMarblePoints.getBluePos();
                if (isHole(nextBlue.getY(), nextBlue.getX())) {
                    continue;
                }
                if (chk[nextRed.getY()][nextRed.getX()][nextBlue.getY()][nextBlue.getX()] == 0 && !(isSamePos(red, nextRed) && isSamePos(blue, nextBlue))) {
                    chk[nextRed.getY()][nextRed.getX()][nextBlue.getY()][nextBlue.getX()] = chk[red.getY()][red.getX()][blue.getY()][blue.getX()] + 1;
                    queue.add(new Points(nextRed, nextBlue));
                }
            }
        }
        return turn > 10 ? 0 : 1;
    }
}

class Points {
    private Point redPos;
    private Point bluePos;

    public Points(Point redPos, Point bluePos) {
        this.redPos = redPos;
        this.bluePos = bluePos;
    }

    public Point getBluePos() {
        return bluePos;
    }

    public Point getRedPos() {
        return redPos;
    }
}

class Point {
    private int y;
    private int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setPos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}


class IOUtils {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static String readInput() throws IOException {
        return br.readLine();
    }

    public static void printOutput(int output) throws IOException {
        bw.write(output + "\n");
        bw.flush();
    }
}
