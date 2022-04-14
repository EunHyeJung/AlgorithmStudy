/*
* @source https://leetcode.com/problems/power-of-three/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.14
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        int i = 1;
        while (Math.pow(3, i) < n) {
            i += 1;
        }
        return Math.pow(3, i) == n;
    }
}
