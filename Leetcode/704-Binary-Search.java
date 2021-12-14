/*
* @source https://leetcode.com/problems/binary-search/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.14
*/
class Solution {
    public int search(int[] nums, int target) {
        int st = 0, end = nums.length -1;
        int idx = (st + end) / 2;
        
        while(st <= end) {
            idx = (st + end) / 2;
            if (nums[idx] == target) {
                return idx;
            } else if (nums[idx] > target) {
                end = idx - 1;
            } else if (nums[idx] < target) {
                st = idx + 1;
            }
        }
        
        return -1;
    }
}
