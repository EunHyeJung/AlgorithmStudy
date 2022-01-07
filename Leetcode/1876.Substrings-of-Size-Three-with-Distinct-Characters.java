/*
* @source https://leetcode.com/problems/3sum-closest/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.07
*/
class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        if (n < 3)  return 0;
        final int k = 3;
        int count = 0;
        for(int i = 0; i + k - 1 < n; i++) {
            if(isDistinctStr(s.substring(i, i + k)))
                count++;
        }
        return count;
    }
    public boolean isDistinctStr(String s)  {
        return (s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2) && s.charAt(1) != s.charAt(2));
    }
}
