/*
* @source https://leetcode.com/problems/max-consecutive-ones/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.29
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 0) {
                maxCount = Math.max(count, maxCount);
                count = 0;
                continue;
            }
            count += 1;
        }

        return Math.max(count, maxCount);
    }
}
