/*
* @source https://leetcode.com/problems/unique-paths/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.19
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for(int i = 0; i< m; i++)
            dp[i][0] = 1;

        for(int i = 1; i <m; i++) {
            for(int j = 1; j< n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
