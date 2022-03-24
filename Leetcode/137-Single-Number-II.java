/*
* @source https://leetcode.com/problems/single-number-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.03.24
*/
class Solution {
  public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 1;
        int res = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (cnt != 3)
                    return nums[i - 1];
                cnt = 1;
            } else {
                cnt += 1;
            }
            
        }
        return nums[n - 1];
    }
}
