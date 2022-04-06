/*
* @source https://leetcode.com/problems/find-the-duplicate-number/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.06
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] numsChk = new boolean[n + 1];
        for(int num : nums) {
            if (numsChk[num]) {
                return num;
            }
            numsChk[num] = true;
        }
        return 0;
    }
}
