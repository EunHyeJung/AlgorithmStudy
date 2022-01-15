/*
* @source https://leetcode.com/problems/maximum-subarray/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.15
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for(int i = 1; i < n; i++) {
            int sum = dp[i - 1] + nums[i];
            dp[i] = sum > nums[i] ? sum : nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
