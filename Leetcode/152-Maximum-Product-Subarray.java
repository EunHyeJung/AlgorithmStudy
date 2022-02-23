/*
* @source https://leetcode.com/problems/maximum-product-subarray/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.23
*/
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int product = 0;

        for(int i = 0; i < n; i ++) {
            product = nums[i];
            res = Math.max(res,  product);
            for (int j = i + 1; j < n; j++) {
                product *= nums[j];
                res = Math.max(res, product);
            }
        }

        return res;
    }
}
