/*
* @source https://leetcode.com/problems/triangle/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.12
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> curRow = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + curRow.get(0);
            int m = curRow.size();
            for (int j = 1; j < m - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + curRow.get(j);
            }
            dp[i][m - 1] =  dp[i - 1][m - 2] + curRow.get(m - 1);
            
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }

        return res;
    }
}
