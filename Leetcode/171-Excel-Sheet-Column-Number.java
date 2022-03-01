/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.01
*/
class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += ((int) columnTitle.charAt(i) - 64) * (Math.pow(26, n - i - 1));
        }
        res += (int) columnTitle.charAt(n - 1) - 64;
        return res;
    }

}
