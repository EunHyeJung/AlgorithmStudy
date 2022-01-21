/*
* @source https://leetcode.com/problems/reverse-vowels-of-a-string/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.21
*/
class Solution {
    public String reverseVowels(String s) {
        char[] chArr = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while(l < r) {
            while(l < r && !isVowel(chArr[l])) {
                l += 1;
            }
            while(l < r && !isVowel(chArr[r])) {
                r -= 1;
            }
            if (l >= r)
                return new String(chArr);
            char tmp = chArr[l];
            chArr[l] = chArr[r];
            chArr[r] = tmp;
            l += 1;
            r -= 1;
        }
        return new String(chArr);
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
