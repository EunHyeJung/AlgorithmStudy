/*
* @source https://leetcode.com/problems/sqrtx/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.07
*/
class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int left = 0, right = 46340;
        int mid = 0 ;
        while (left < right) {
            mid = (left + right) / 2;
            if (mid * mid == x)
                return mid;
            else if (mid * mid > x)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right * right > x ? right - 1 : right;
    }
}
