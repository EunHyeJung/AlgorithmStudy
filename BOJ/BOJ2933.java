import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Battle battle = new Battle();
            battle.printCaveState();
        } catch (IOException e) {
        }
    }
}

/*
* @source https://www.acmicpc.net/problem/2933
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.16
*/
class Battle {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final char MINERAL = 'x';
    private static final char BLANK = '.';
    private int r, c;
    private char[][] cave;

    public Battle() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        this.r = Integer.parseInt(st.nextToken());
        this.c = Integer.parseInt(st.nextToken());
        this.cave = new char[r][c];
        this.initCave();
    }

    public void initCave() throws IOException {
        for (int y = 0; y < r; y++) {
            String input = br.readLine();
            for (int x = 0; x < c; x++) {
                cave[y][x] = input.charAt(x);
            }
        }
    }

    public void throwStick() throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int turn = 1; turn <= n; turn++) {
            int stickHeight = r - Integer.parseInt(st.nextToken());
            int x = 0;
            if (turn % 2 == 1) { // 왼쪽에서 오른쪽으로
                while (x < c && cave[stickHeight][x] != MINERAL) {
                    x += 1;
                }
                if (x >= c) { // 막대기 던진 높이에 미네랄 없으면 동굴 상태 변화가 없음
                    continue;
                }
            } else { // 오른쪽에서 왼쪽으로
                x = c - 1;
                while (x >= 0 && cave[stickHeight][x] != MINERAL) {
                    x -= 1;
                }
                if (x < 0) { // // 막대기 던진 높이에 미네랄 없으면 동굴 상태 변화가 없음
                    continue;
                }
            }
            // 동굴 상태 업데이트
            updateCaveState(stickHeight, x);
        }
    }

    public void updateCaveState(int targetY, int targetX) { // 제거되는 미네랄의 좌표값
        cave[targetY][targetX] = BLANK; // 타겟 미네랄 제거
        // 인접한 미네랄 확인
        for (int d = 0, dn = DIR.length; d < dn; d++) {
            int nearY = targetY + DIR[d][0];
            int nearX = targetX + DIR[d][1];

            // 인접한 미네랄 존재
            if (isAccessible(nearY, nearX) && cave[nearY][nearX] == MINERAL && nearY != r - 1) {
                if (simulate(nearY, nearX)) {
                    return;
                }
            }
        }
    }

    public boolean simulate(int y, int x) {
        boolean[][] chk = new boolean[r][c];
        Queue<Pos> queue = new LinkedList<>();
        Queue<Pos> candidates = new LinkedList<>();
        queue.add(new Pos(y, x));
        candidates.add(new Pos(y, x));
        chk[y][x] = true;
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            for (int d = 0, dn = DIR.length; d < dn; d++) {
                int nearY = pos.getY() + DIR[d][0];
                int nearX = pos.getX() + DIR[d][1];

                if (isAccessible(nearY, nearX) && !chk[nearY][nearX] && cave[nearY][nearX] == MINERAL) {
                    if (nearY == r - 1) {
                        return false;
                    }
                    chk[nearY][nearX] = true;
                    queue.add(new Pos(nearY, nearX));
                    candidates.add(new Pos(nearY, nearX));
                }
            }
        }

        Queue<Pos> targets = new PriorityQueue<>();
        int count = candidates.size();
        while (count > 0) {
            Pos pos = candidates.poll();
            int curY = pos.getY() + 1;
            boolean flag = true;
            while (curY < r) {
                if (chk[curY][pos.getX()]) {
                    flag = false;
                    break;
                }
                curY += 1;
            }
            if (flag) {
                candidates.add(pos);
            } else {
                targets.add(pos);
            }
            count -= 1;
        }

        int step = Integer.MAX_VALUE;
        while (!candidates.isEmpty()) {
            Pos pos = candidates.poll();
            int curY = pos.getY();
            while (curY + 1 < r && cave[curY + 1][pos.getX()] == BLANK) {
                curY += 1;
            }
            step = Math.min(curY - pos.getY(), step);
            targets.add(pos);
        }
        while (!targets.isEmpty()) {
            Pos pos = targets.poll();
            int curY = pos.getY();
            int curX = pos.getX();
            cave[curY][curX] = BLANK;
            cave[curY + step][curX] = MINERAL;

        }
        return true;
    }

    public boolean isAccessible(int y, int x) {
        return y >= 0 && x >= 0 && y < r && x < c;
    }

    public void printCaveState() throws IOException {
        throwStick();
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                System.out.print(cave[y][x]);
            }
            System.out.println();
        }

    }
}

class Pos implements Comparable<Pos> {
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


    @Override
    public int compareTo(Pos o) {
        return o.getY() - this.y;
    }
}
