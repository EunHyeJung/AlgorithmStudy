/*
* @source https://leetcode.com/problems/longest-palindrome/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.31
*/
class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return n;
        Map<Character, Integer> map = new HashMap<>();
        int longestLen = 0;
        for (int i = 0; i < n; i++) {
            char curCh = s.charAt(i);
            int cnt = map.getOrDefault(curCh, 0);
            if (cnt + 1 == 2) {
                map.put(curCh, 0);
                longestLen += 2;
            } else
                map.put(curCh, 1);
        }

        return longestLen != n ? longestLen + 1 : longestLen;
    }
}
