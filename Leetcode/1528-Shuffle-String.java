/*
* @source https://leetcode.com/problems/shuffle-string/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.14
*/
class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] chArr = new char[n];

        for (int i = 0; i < n; i++) {
            chArr[indices[i]] = s.charAt(i);
        }

        return new String(chArr);
    }
}
