/*
* @source https://leetcode.com/problems/rotting-oranges/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.22
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        OrangeManager orangeManager = new OrangeManager(grid);        
        return orangeManager.getRunningTime();
    }
}

class OrangeManager {
    public final int[][] DIR = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public final int FRESH = 1;
    public final int ROTTEN = 2;
    private int[][] grid;
    private int m;
    private int n;
    private boolean[][] checked;
    private int runningTime;

    public OrangeManager(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.checked = new boolean[m][n];
    }

    public int getRunningTime() {
        this.checkOrange();
        for(int y = 0; y < m; y++) {
            for(int x = 0; x <n; x++) {
                if (this.grid[y][x] == FRESH)
                    return -1;
            }
        }
        return this.runningTime;
    }

    public void checkOrange() {
        Queue<Cell> queue = new LinkedList<>();
        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if (grid[y][x] == ROTTEN && !checked[y][x]) {
                    checked[y][x] = true;
                    queue.add(new Cell(y, x, 0));
                }
            }
        }
        findAdjacentFreshOrange(queue);
    }

    public void findAdjacentFreshOrange(Queue<Cell> queue)
    {
        while(!queue.isEmpty())
        {
            int curQueueSize = queue.size();
            for (int q = 0; q < curQueueSize; q++) {
                Cell curCell = queue.poll();
                runningTime = curCell.getTime();

                for(int d = 0, dn= DIR.length; d< dn; d++) {
                    int nextY = curCell.getY() + DIR[d][0];
                    int nextX = curCell.getX() + DIR[d][1];
                    if (isAccessible(nextY, nextX) && grid[nextY][nextX] == FRESH) {
                        checked[nextY][nextX] = true;
                        grid[nextY][nextX] = ROTTEN;
                        queue.add(new Cell(nextY, nextX, curCell.getTime() + 1));
                    }
                }
            }
        }
    }


    public boolean isAccessible(int y, int x) {
        if (y < 0 || x < 0 || y > m-1 || x > n-1 || checked[y][x]) {
            return false;
        }
        return true;
    }

}

class Cell {
    private int y;
    private int x;
    private int time;

    public Cell(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getTime() {
        return time;
    }
}
