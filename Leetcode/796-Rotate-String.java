/*
* @source https://leetcode.com/problems/rotate-string/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.26
*/
class Solution {
    public boolean rotateString(String s, String goal) {
        for (int i = 0, n = s.length(); i < n; i++) {
            StringBuilder sb = new StringBuilder(s.substring(i, n));
            sb.append(s.substring(0, i));
           if (sb.toString().equals(goal))
               return true;
        }
        return false;
    }
}
