/*
* @source https://leetcode.com/problems/search-in-rotated-sorted-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.05
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)   return -1;
        int left = 0, right = nums.length - 1;
        
        
        int curIdx = -1; 
        while(left <= right) {
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            curIdx = (left + right) / 2;
            if (nums[curIdx] == target) {
                return curIdx;
            } else if (nums[curIdx] > target) {
                if (nums[left] > target) {
                    left += 1;
                } else {
                    right = curIdx - 1;
                }
            } else { // nums[curIdx] < target
                if (nums[right] < target) {
                    right -= 1;
                } else {
                    left = curIdx + 1;
                   
                }
            }
        }
        return -1;
    }
}
