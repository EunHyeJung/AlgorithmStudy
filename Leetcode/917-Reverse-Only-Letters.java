/*
* @source https://leetcode.com/problems/reverse-only-letters/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.18
*/
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chArrs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (!Character.isLetter(chArrs[l])) {
                l += 1;
            } else if (!Character.isLetter(chArrs[r])) {
                r -= 1;
            } else {
                char tmp = chArrs[l];
                chArrs[l] = chArrs[r];
                chArrs[r] = tmp;
                l += 1;
                r -= 1;
            }
        }
        return new String(chArrs);
    }
}
