/*
* @source https://leetcode.com/problems/sum-of-square-numbers/description/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.
*/
class Solution {
   public boolean judgeSquareSum(int num) {
        int left = 0, right = (int) Math.sqrt(num);

        while (left <= right) {
            if (left * left + right * right == num) {
                return true;
            } else if (left * left + right * right > num) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return false;
    }
}
