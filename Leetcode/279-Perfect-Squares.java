/*
* @source https://leetcode.com/problems/perfect-squares/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.07
*/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int k = 1; k * k <= i; k++) {
                dp[i] = Math.min(1 + dp[i - k * k], dp[i]);
            }
        }

        return dp[n];
    }
}
