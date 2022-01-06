/*
* @source https://leetcode.com/problems/container-with-most-water/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.06
*/
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n == 1) return height[0];

        int l = 0, r = n - 1;
        int width = 0;
        int maxWater = 0;

        while(l < r) {
            width = r - l;
            maxWater = Math.max(maxWater, Math.min(height[l], height[r]) * width);
            if (height[l] > height[r]) {
                r --;
            } else {
                l ++;
            }
        }
        return maxWater;
    }
}
