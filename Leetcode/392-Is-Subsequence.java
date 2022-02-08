/**
 * @author EunHyeJung 
 * @email ehye826@gmail.com
 * @date 2022.02.08
 * @link https://leetcode.com/problems/is-subsequence/
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();              

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
            }
            j += 1;
        }

        return i == n;        
    }
}
