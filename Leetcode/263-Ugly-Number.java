/*
* @source https://leetcode.com/problems/ugly-number/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.02
*/
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;
        return n == 1;
    }
}

