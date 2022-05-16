/*
* @source https://leetcode.com/problems/shortest-path-in-binary-matrix/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.05.16
*/
class Solution {
    public final int CLEAR_PATH = 0;
    public final int[][] DIR = {{ -1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    private boolean[][] chk;
    private int n;
    private Queue<Cell> queue;

    private void init(int n) {
        this.n = n;
        this.chk = new boolean[n][n];
        this.queue = new LinkedList<>();
    }

    public boolean isAccessible(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != CLEAR_PATH)
            return -1;

        int n = grid.length;
        init(n);

        chk[0][0] = true;
        queue.add(new Cell(0, 0, 1));

        while (!queue.isEmpty()) {
            Cell curCell = queue.poll();
            if (curCell.getY() == n - 1 && curCell.getX() == n - 1)
                return curCell.getStep();
            for (int d = 0, dn = DIR.length; d < dn; d++) {
                int nextY = curCell.getY() + DIR[d][0];
                int nextX = curCell.getX() + DIR[d][1];
                if (!isAccessible(nextY, nextX) || grid[nextY][nextX] != CLEAR_PATH || chk[nextY][nextX])
                    continue;

                chk[nextY][nextX] = true;
                queue.add(new Cell(nextY, nextX, curCell.getStep() + 1));
            }
        }

        return -1;
    }
}

class Cell {
    private int y;
    private int x;
    private int step;

    public Cell(int y, int x, int step) {
        this.y = y;
        this.x = x;
        this.step = step;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getStep() {
        return step;
    }
}
