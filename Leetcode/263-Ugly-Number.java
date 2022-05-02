/*
* @source https://leetcode.com/problems/ugly-number/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.02
*/
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0)  return false;
        if (n == 1) return true;
        int i = 2;
        int m = (int) Math.sqrt(n);
        while(i <= m) {
            while (n % i == 0) {
                if (!(i == 2 || i == 3 || i == 5))
                    return false;
                n /= i;
            }
            i += 1;
        }
        return n == 1 || n % 2 == 0 || n % 3 == 0 || n % 5 == 0;
    }
}
