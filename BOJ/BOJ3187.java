import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = br.readLine().split(" ");
            int r = Integer.parseInt(inputs[0]);
            int c = Integer.parseInt(inputs[1]);

            char[][] map = new char[r][c];

            for (int i = 0; i < r; i++) {
                char[] mapInfo = br.readLine().toCharArray();
                for (int j = 0; j < c; j++) {
                    map[i][j] = mapInfo[j];
                }
            }

            Farm farm = new Farm(r, c, map);
            int[] survival = farm.getSurvival();
            System.out.println(survival[0] + " " + survival[1]);

        } catch (IOException e) {

        }
    }
}

class Farm {
    public final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public final char SHEEP = 'k';
    public final char WOLF = 'v';
    public final char FENCE = '#';
    public final char BLANK = '.';

    private int r;
    private int c;
    private char[][] map;
    private int sheepCnt;
    private int wolfCnt;

    public Farm(int r, int c, char[][] map) {
        this.r = r;
        this.c = c;
        this.map = map;
        this.sheepCnt = 0;
        this.wolfCnt = 0;
    }

    public int[] getSurvival() {
        boolean[][] chk = new boolean[r][c];

        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if ((map[y][x] == WOLF || map[y][x] == SHEEP) && !chk[y][x]) {
                    Queue<Cell> queue = new LinkedList<>();
                    queue.add(new Cell(y, x));
                    chk[y][x] = true;

                    int curSheepCnt = 0;
                    int curWolfCnt = 0;
                    while (!queue.isEmpty()) {
                        Cell curCell = queue.poll();
                        if (map[curCell.getY()][curCell.getX()] == SHEEP) {
                            curSheepCnt += 1;
                        } else if (map[curCell.getY()][curCell.getX()] == WOLF) {
                            curWolfCnt += 1;
                        }

                        for (int d = 0; d < DIR.length; d++) {
                            int nextY = curCell.getY() + DIR[d][0];
                            int nextX = curCell.getX() + DIR[d][1];

                            if (isAccessible(nextY, nextX) && !chk[nextY][nextX] && map[nextY][nextX] != FENCE) {
                                queue.add(new Cell(nextY, nextX));
                                chk[nextY][nextX] = true;
                            }
                        }
                    }
                    if (curSheepCnt > curWolfCnt) {
                        curWolfCnt = 0;
                    } else {
                        curSheepCnt = 0;
                    }

                    wolfCnt += curWolfCnt;
                    sheepCnt += curSheepCnt;
                }
            }
        }

        return new int[]{sheepCnt, wolfCnt};
    }

    public boolean isAccessible(int y, int x) {
        if (y < 0 || x < 0 || y > r - 1 || x > c - 1) {
            return false;
        }
        return true;
    }
}


class Cell {
    private int y;
    private int x;

    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}b
