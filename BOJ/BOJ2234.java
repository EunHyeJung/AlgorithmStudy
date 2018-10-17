import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* @source https://www.acmicpc.net/problem/2234
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.17
*/
public class Main {
    public static void main(String[] args) {
        try {
            Castle castle = new Castle();
            castle.printCastleInfo();
        } catch (IOException e) {
        }
    }
}

class Castle {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] DIR = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private static final int NOT_CHECKED = 0;
    private int n, m;
    private int[][] room;
    private int[][] chk;
    private Map<Integer, Integer> castleInfo; // 방넘버, 방의 넓이
    private int maxRoomArea; // 방의 최대 넓이
    private int maxRoomAreaByWallRemove; // 벽을 제거했을때 가장 넓은 넓이

    public Castle() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        this.n = Integer.parseInt(st.nextToken());
        this.m = Integer.parseInt(st.nextToken());
        this.room = new int[m][n];
        this.chk = new int[m][n];
        this.castleInfo = new HashMap<>();
        this.maxRoomArea = 0;
        this.maxRoomAreaByWallRemove = 0;
        this.initRoomState();
    }

    public void initRoomState() throws IOException {
        StringTokenizer st = null;
        for (int y = 0; y < m; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < n; x++) {
                room[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public boolean isAccessible(int y, int x) {
        return y >= 0 && x >= 0 && y < m && x < n;
    }

    public void conquer() {
        int roomNo = 1;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (chk[y][x] == NOT_CHECKED) {
                    castleInfo.put(roomNo, getRoomArea(y, x, roomNo));
                    roomNo++;
                }
            }
        }
    }

    public int getRoomArea(int y, int x, int roomNo) {
        int area = 1;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(y, x));
        chk[y][x] = roomNo;

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            int curY = curPos.getY();
            int curX = curPos.getX();

            for (int d = 0, dn = DIR.length; d < dn; d++) {
                int nextY = curY + DIR[d][0];
                int nextX = curX + DIR[d][1];
                if (isAccessible(nextY, nextX) && chk[nextY][nextX] == NOT_CHECKED && ((room[curY][curX] & (1 << d)) == 0)) {
                    chk[nextY][nextX] = roomNo;
                    queue.add(new Pos(nextY, nextX));
                    area += 1;
                }
            }
        }
        maxRoomArea = Math.max(area, maxRoomArea);
        return area;
    }

    public void removeOneWall() {
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                for (int d = 0, dn = DIR.length; d < dn; d++) {
                    int nextY = y + DIR[d][0];
                    int nextX = x + DIR[d][1];
                    // 다음방향으로 접근이 가능하고 벽이 있다면
                    if (isAccessible(nextY, nextX) && ((room[y][x] & (1 << d)) > 0)) {
                        if (chk[y][x] != chk[nextY][nextX]) {
                            maxRoomAreaByWallRemove = Math.max(castleInfo.get(chk[y][x]) + castleInfo.get(chk[nextY][nextX]), maxRoomAreaByWallRemove);
                        }
                    }
                }
            }
        }
    }

    public void printCastleInfo() {
        this.conquer();
        this.removeOneWall();

        StringBuffer res = new StringBuffer();
        res.append(castleInfo.size() + "\n");
        res.append(maxRoomArea + "\n");
        res.append(maxRoomAreaByWallRemove);
        System.out.println(res);
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
