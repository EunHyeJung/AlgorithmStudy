/*
* @source https://leetcode.com/problems/find-peak-element/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.01
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1)   return 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        return nums[0] > nums[n - 1] ? 0 : n - 1;
    }
}
