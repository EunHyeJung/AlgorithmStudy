/*
* @source https://leetcode.com/problems/number-of-islands/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.31
*/
class Solution {
    final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final char LAND = '1';
    boolean[][] chk; 
    int m;
    int n;
        
    public int numIslands(char[][] grid) {
        this.m = grid.length; 
        this.n = grid[0].length;
        this.chk = new boolean[m][n];
        
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if (grid[i][j] == LAND && !chk[i][j]) {
                  cnt += 1;
                  chk[i][j] = true;  
                  check(grid, i, j);  
                }
            }
        }
        
        return cnt;
    }
    
    public boolean check(char[][] grid, int y, int x) {
        if (grid[y][x] != LAND)    return false;
        for (int d = 0; d < DIR.length; d++) {
            int nextY = y + DIR[d][0];
            int nextX = x + DIR[d][1];
            if (isAccessible(nextY, nextX) && grid[nextY][nextX] == LAND) {
                chk[nextY][nextX] = true;
                check(grid, nextY, nextX);
            }
        }
        return true;
    }
    public boolean isAccessible(int y, int x) {
        if (y < 0 || x < 0 || y > m - 1 || x > n - 1 || chk[y][x])   
            return false;
        return true;
    }
}
