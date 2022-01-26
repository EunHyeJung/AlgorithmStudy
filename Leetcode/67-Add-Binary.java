/*
* @source https://leetcode.com/problems/add-binary/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.24
*/
class Solution {
    public String addBinary(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (aIdx >= 0 && bIdx >= 0) {
            int sum  = (a.charAt(aIdx) - '0') + (b.charAt(bIdx) - '0') + carry;
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
            aIdx -= 1;
            bIdx -= 1;
        }
        while(aIdx >= 0) {
            int sum = a.charAt(aIdx) - '0' + carry;
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
            aIdx -= 1;
        }
        while(bIdx >= 0) {
            int sum = b.charAt(bIdx) - '0' + carry;
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
            bIdx -= 1;
        }

        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
