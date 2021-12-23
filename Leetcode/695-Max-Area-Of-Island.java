/*
* @source https://leetcode.com/problems/max-area-of-island/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.23
*/
class Solution {
    public boolean[][] chk = null;
    public int area = 0;
    public int m = 0;
    public int n = 0;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        chk = new boolean[m][n];
        int maxArea = 0;

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if (grid[y][x] == 1 && !chk[y][x]) {
                    area = 0;
                    getArea(grid, y, x);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public void getArea(int[][] grid, int y, int x) {
        if (y < 0 || x < 0 || y > m - 1 || x > n - 1 || chk[y][x] || grid[y][x] == 0) {
            return;
        }
        chk[y][x] = true;
        area += 1;

        getArea(grid, y-1, x);
        getArea(grid, y+1, x);
        getArea(grid, y, x -1);
        getArea(grid, y, x +1);
    }
}
