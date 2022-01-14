/*
* @source https://leetcode.com/problems/two-furthest-houses-with-different-colors/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.14
*/
class Solution {
    public int maxDistance(int[] colors) {
        int maxDist = 0;
        for(int i = 0, n = colors.length; i < n; i++) {
            for(int j = n - 1;  j > i ; j--) {
                if (colors[i] != colors[j]) {
                    maxDist = Math.max(j - i, maxDist);
                    break;
                }
            }
        }
        return maxDist;
    }
}
