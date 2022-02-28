/*
* @source https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.28
*/
class Solution {
    private int[][] dp;
    private int longestLen = 0;

    public void explore(int[][] matrix, int y, int x, int m, int n) {
        longestLen = Math.max(dp[y][x], longestLen);

        if (y + 1 < m && matrix[y + 1][x] > matrix[y][x] && dp[y + 1][x] < dp[y][x] + 1) {
            dp[y + 1][x] = dp[y][x] + 1;
            explore(matrix, y + 1, x, m, n);
        }
        if (x + 1 < n && matrix[y][x + 1] > matrix[y][x] && dp[y][x + 1] < dp[y][x] + 1) {
            dp[y][x + 1] = dp[y][x] + 1;
            explore(matrix, y, x + 1, m, n);
        }
        if (y - 1 >= 0 && matrix[y - 1][x] > matrix[y][x] && dp[y - 1][x] < dp[y][x] + 1) {
            dp[y - 1][x] = dp[y][x] + 1;
            explore(matrix, y - 1, x, m, n);
        }
        if (x - 1 >= 0 && matrix[y][x - 1] > matrix[y][x] && dp[y][x - 1] < dp[y][x] + 1) {
            dp[y][x - 1] = dp[y][x] + 1;
            explore(matrix, y, x - 1, m, n);
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.dp = new int[m][n];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (dp[y][x] > 0)   continue;
                dp[y][x] = 1;
                explore(matrix, y, x, m, n);

            }
        }

        return longestLen;
    }
}
