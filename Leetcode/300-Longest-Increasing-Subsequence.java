/*
* @source https://leetcode.com/problems/longest-increasing-subsequence/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.24
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
