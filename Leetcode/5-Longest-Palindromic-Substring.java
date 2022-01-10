/*
* @source https://leetcode.com/problems/longest-palindromic-substring/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.10
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String maxSubstr = Character.toString(s.charAt(0));
        int n = s.length();
        boolean[][] chk = new boolean[n][n];
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                if (i + k > n - 1) break;
                if (k == 0) {
                    chk[i][i + k] = true;
                } else if (k == 1) {
                    chk[i][i + k] = chk[i + k][i] = s.charAt(i) == s.charAt(i + k);
                    if(chk[i][i + k]) {
                        maxSubstr = s.substring(i, i + k + 1);
                    }
                }
                else {
                    if (i + 1 < n && chk[i + 1][i + k - 1] && s.charAt(i) == s.charAt(i + k)) {
                        chk[i][i + k] = true;
                        maxSubstr = s.substring(i, i + k + 1);
                    }
                }
            }
        }

        return maxSubstr;
    }
}
