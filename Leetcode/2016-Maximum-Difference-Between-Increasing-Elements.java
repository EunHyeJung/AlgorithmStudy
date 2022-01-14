/*
* @source https://leetcode.com/problems/maximum-difference-between-increasing-elements/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.14
*/
class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minNum = nums[0];
        for(int i = 1, n = nums.length; i < n; i++) {
            if (nums[i] > minNum)
                maxDiff = Math.max(nums[i] - minNum, maxDiff);
            else
                minNum = Math.min(minNum, nums[i]);
        }
        return maxDiff;
    }
}
