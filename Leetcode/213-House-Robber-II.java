/*
* @source https://leetcode.com/problems/house-robber-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.09
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        if (n == 1)
            return res;
        else if (n == 2)
            return Math.max(res, nums[1]);

        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[1][0] = Math.max(nums[0], nums[1]);
        dp[1][1] = nums[1];


        for (int i = 2; i < n; i++) {
            if (i != n -1)
                dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 1][1]);

            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
}
