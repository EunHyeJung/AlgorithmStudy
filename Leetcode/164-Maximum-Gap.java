/*
* @source https://leetcode.com/problems/maximum-gap/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.28
*/
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        int maxGap = 0;
        if (n < 2)
            return maxGap;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1])
                maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }

        return maxGap;
    }
}
