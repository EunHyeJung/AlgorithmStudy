
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/3184
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.13
*/
public class Main {
    public static void main(String[] args) {
        try {
            AnimalBattle animalBattle = new AnimalBattle();
            animalBattle.printNumOfSurvivals();
        } catch (IOException e) {
        }
    }
}

class AnimalBattle {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final char SHEEP = 'o';
    private static final char WOLF = 'v';
    private static final char FENCE = '#';
    private int r;
    private int c;
    private char[][] yard;
    private int numOfSurvivalSheep;
    private int numOfSurvivalWolves;
    private Queue<Pos> fightPoints;
    private boolean[][] chk;


    public AnimalBattle() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        this.r = Integer.parseInt(st.nextToken());
        this.c = Integer.parseInt(st.nextToken());
        this.yard = new char[r][c];
        this.chk = new boolean[r][c];
        this.fightPoints = new LinkedList<>();
        this.numOfSurvivalSheep = 0;
        this.numOfSurvivalWolves = 0;

        for (int y = 0; y < r; y++) {
            String yardInfo = br.readLine();
            for (int x = 0; x < c; x++) {
                yard[y][x] = yardInfo.charAt(x);
                if (yard[y][x] == SHEEP || yard[y][x] == WOLF) {
                    fightPoints.add(new Pos(y, x));
                }
            }
        }
    }

    public boolean isAccessible(int y, int x) {
        if (y < 0 || x < 0 || y > r - 1 || x > c - 1) {
            return false;
        }
        return !chk[y][x] && yard[y][x] != FENCE;
    }

    public void printNumOfSurvivals() {
        while (!fightPoints.isEmpty()) {
            Pos fightPoint = fightPoints.poll();
            if (chk[fightPoint.getY()][fightPoint.getX()]) {
                continue;
            }
            fight(fightPoint);
        }
        System.out.println(numOfSurvivalSheep + " " + numOfSurvivalWolves);
    }

    public void fight(Pos fightPoint) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(fightPoint);
        chk[fightPoint.getY()][fightPoint.getX()] = true;
        int numOfSheep = 0;
        int numOfWolves = 0;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            int y = pos.getY();
            int x = pos.getX();
            if (yard[y][x] == SHEEP) {
                numOfSheep += 1;
            } else if (yard[y][x] == WOLF) {
                numOfWolves += 1;
            }
            for (int d = 0, dn = DIR.length; d < dn; d++) {
                int nextY = y + DIR[d][0];
                int nextX = x + DIR[d][1];
                if (isAccessible(nextY, nextX)) {
                    chk[nextY][nextX] = true;
                    queue.add(new Pos(nextY, nextX));
                }
            }
        }

        if (numOfSheep > numOfWolves) {
            numOfSurvivalSheep += numOfSheep;
        } else {
            numOfSurvivalWolves += numOfWolves;
        }
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
