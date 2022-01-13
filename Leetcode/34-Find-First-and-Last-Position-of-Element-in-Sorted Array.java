/*
* @source https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.13
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)   return new int[] { -1, -1 };
        int st = 0;
        int end = n - 1;
        int targetPos = -1;
        while(st <= end) {
            int mid = (st + end) / 2;
            if (nums[mid] == target) {
                targetPos = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        st = end = targetPos;
        if (targetPos < 0)
            return new int[] {-1, -1};

        while(st >= 0 && nums[st] == target) {
            st -= 1;
        }
        while(end < n && nums[end] == target) {
            end += 1;
        }
        return new int[] { st + 1, end - 1 };
    }
}
