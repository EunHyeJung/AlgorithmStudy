/*
* @source https://leetcode.com/problems/palindromic-substrings/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.05.22
*/
class Solution {
    private int cnt;

    public int countSubstrings(String s) {
        int n = s.length();
        cnt = n;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j + i <= n; j++) {
                if (isPalindrome(s.substring(j, j + i))) {
                    cnt += 1;
                }
            }
        }

        return cnt;
    }
    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0, m = s.length() / 2; i < m; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        }

        return true;
    }

}
