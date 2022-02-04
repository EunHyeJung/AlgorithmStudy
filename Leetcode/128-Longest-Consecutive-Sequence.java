/*
* @source https://leetcode.com/problems/longest-consecutive-sequence/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.04
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)   return 0;
        Arrays.sort(nums);
        int res = 0;
        int len = 1;
        for(int i = 1, n = nums.length; i < n; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] - nums[i - 1] == 1) {
                len += 1;
            } else {
                res = Math.max(len, res);
                len = 1;
            }
        }
        return Math.max(len, res);
    }
}
