import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try {
            DummyGame dummyGame = new DummyGame();
            dummyGame.playGame();
        } catch (IOException e) {

        }
    }


}

/*
* @source https://www.acmicpc.net/problem/3190
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.15
*/
class DummyGame {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final char LEFT = 'L';
    private static final char RIGHT = 'D';
    private static final int BLANK = 0;
    private static final int APPLE = 1;
    private Queue<Command> cmdQueue;
    private int n;
    private int[][] board;

    public DummyGame() throws IOException {
        this.n = Integer.parseInt(br.readLine());
        this.board = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = APPLE;
        }
        cmdQueue = new LinkedList<>();
        int l = Integer.parseInt(br.readLine());
        while (l-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cmdQueue.add(new Command(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }
    }

    public void playGame() {
        int sec = 0;
        int[][] chk = new int[n][n]; // y,x에서 뱀의 머리가 위치했던 시간(sec)

        int snakeLength = 1;
        Pos snakeHead = new Pos(0, 0, 1);
        chk[0][0] = 0;

        while (true) {
            System.out.println(sec + " : " + snakeHead.getY() + ", " + snakeHead.getX() + " | DIR : " + snakeHead.getDir() + " | LENGTH : " + snakeLength);
            sec += 1;
            int nextY = snakeHead.getY() + DIR[snakeHead.getDir()][0];
            int nextX = snakeHead.getX() + DIR[snakeHead.getDir()][1];
            // 벽에 부딪히는 경우 게임 종료
            if (!isAccessible(nextY, nextX)) {
                break;
            }
            // 뱀의 자신의 몸과 부딪히는 경우
            if (sec > snakeLength && sec - snakeLength <= chk[nextY][nextX]) {
                break;
            }
            // 사과가 있으면 사과를 먹자
            if (board[nextY][nextX] == APPLE) {
                board[nextY][nextX] = BLANK;
                snakeLength += 1;
            }
            if (!cmdQueue.isEmpty() && cmdQueue.peek().getSec() == sec) {
                int dirCmd = cmdQueue.poll().getDir();
                int curDir = snakeHead.getDir();
                switch (dirCmd) {
                    case LEFT: {
                        int nextDir = curDir - 1 < 0 ? 3 : curDir - 1;
                        snakeHead.setDir(nextDir);
                        break;
                    }
                    case RIGHT: {
                        int nextDir = curDir + 1 > 3 ? 0 : curDir + 1;
                        snakeHead.setDir(nextDir);
                        break;
                    }
                }
            }

            snakeHead.setY(nextY);
            snakeHead.setX(nextX);
            chk[nextY][nextX] = sec;
        }
        System.out.println(sec);
    }

    public boolean isAccessible(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }
}

class Command {
    private int sec;
    private char dir;

    public Command(int sec, char dir) {
        this.sec = sec;
        this.dir = dir;
    }

    public int getSec() {
        return sec;
    }

    public char getDir() {
        return dir;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
