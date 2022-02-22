/*
* @source https://leetcode.com/problems/house-robber/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.22
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i <n; i++) {
            if (dp[i - 2] + nums[i] > dp[i - 1]) {
                dp[i] = dp[i - 2] + nums[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
