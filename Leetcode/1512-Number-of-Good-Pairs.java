/*
* @source https://leetcode.com/problems/number-of-good-pairs/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.06
*/
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodsPairsCnt = 0;
        
        for (int i = 0, n = nums.length; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    goodsPairsCnt += 1;
            }
        }
        return goodsPairsCnt;
    }
}
