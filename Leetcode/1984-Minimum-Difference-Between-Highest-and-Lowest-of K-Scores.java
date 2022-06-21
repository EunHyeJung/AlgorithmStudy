/*
* @source https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.21
*/
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int i = 0;
        int result = Integer.MAX_VALUE;
        while (i + k <= n) {
            int diffScore = nums[i + k - 1] - nums[i];
            if (diffScore < result)
                result = diffScore;


            i += 1;
        }

        return result;
    }
}
