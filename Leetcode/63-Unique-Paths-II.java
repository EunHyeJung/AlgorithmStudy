/*
* @source https://leetcode.com/problems/unique-paths-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.19
*/
class Solution {
    public static final int OBSTACLE = 1;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == OBSTACLE) return 0;
        
        int[][] dp = new int[m][n];
        int cnt = 1;
        for(int i = 0; i <m; i++) {
            cnt = (cnt < 0 || obstacleGrid[i][0] == OBSTACLE) ? -1 : 1;
            dp[i][0] = cnt;
        }
        cnt = 1;
        for(int i = 0; i <n; i++) {
            cnt = (cnt < 0 || obstacleGrid[0][i] == OBSTACLE) ? -1 : 1;
            dp[0][i] = cnt;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == OBSTACLE) {
                    dp[i][j] = -1;
                    continue;
                }
                dp[i][j] += (dp[i - 1][j] > 0 ? dp[i -1][j] : 0);
                dp[i][j] += (dp[i][j - 1] > 0 ? dp[i][j - 1] : 0);
            }
        }
        return dp[m - 1][n - 1] > 0 ? dp[m - 1][n - 1]: 0;
    }
}
