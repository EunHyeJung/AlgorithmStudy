/*
* @source https://leetcode.com/problems/integer-to-roman/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.23
*/
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int idx =0 ;
        while(num > 0) {
            while (num >= nums[idx]) {
                sb.append(romans[idx]);
                num -= nums[idx];
            }
            idx += 1;
        }
        return sb.toString();
    }
}
