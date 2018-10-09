/*
* @source https://leetcode.com/problems/missing-number/description/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.10
*/
class Solution {
    public  int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}
