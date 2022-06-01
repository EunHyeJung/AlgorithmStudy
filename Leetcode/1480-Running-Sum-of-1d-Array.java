*
* @source https://leetcode.com/problems/running-sum-of-1d-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.01
*/
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
}  
 
