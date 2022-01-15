/*
* @source https://leetcode.com/problems/get-maximum-in-generated-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.15
*/
class Solution {
    public int getMaximumGenerated(int n) {
        if (n  < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int res = 1;
        for(int i = 1; i <= n/2 ; i ++) {
            int j = i * 2;
            dp[j] = dp[i];
            res = Math.max(res, dp[j]);
            if (j < n) {
                dp[j + 1] = dp[i] + dp[i + 1];
                res = Math.max(res, dp[j + 1]);
            }
        }

        return res;
    }
}
