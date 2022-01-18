/*
* @source https://leetcode.com/problems/jump-game/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.17
*/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        
        int maxI = nums[0];
        for(int i = 1 ; i < n; i++) {
            if (i > maxI)   return false;
            maxI = Math.max(maxI, i + nums[i]);
        }
        return true;
    }
}
