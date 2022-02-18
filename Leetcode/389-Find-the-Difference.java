/*
* @source https://leetcode.com/problems/find-the-difference/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.18
*/
class Solution {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0)
            return t.charAt(0);
        char[] sChArr = s.toCharArray();
        char[] tChArr = t.toCharArray();
        Arrays.sort(sChArr);
        Arrays.sort(tChArr);
        for (int i = 0, n = tChArr.length; i < n - 1; i++) {
            if (sChArr[i] != tChArr[i])
                return tChArr[i];
        }
        return tChArr[t.length() - 1];
    }
}
