/*
* @source https://leetcode.com/problems/longest-palindromic-substring/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.17
*/
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;
            
            
        boolean[][] dp = new boolean[n][n];
        int st = -1, end = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)
                        && (i - j <= 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                }

                if (dp[i][j]) {
                   if ((st == -1 && end == -1) || i - j + 1 > end - st) {
                       end = i + 1;
                       st = j;
                   }
                }
            }
        }
        return s.substring(st ,end);
    }
}
