/*
* @source https://leetcode.com/problems/custom-sort-string/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.16
*/
class Solution {
    public String customSortString(String order, String s) {
        int[] charCnt = new int[26];
        for (int i = 0, n = s.length(); i < n; i++) {
            charCnt[(int) s.charAt(i) - 97] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = order.length(); i < n; i++) {
            char ch = order.charAt(i);
            int idx = (int) ch - 97;
            while(charCnt[idx] > 0) {
                sb.append(Character.toString(ch));
                charCnt[idx] -= 1;
            }
        }
        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = s.charAt(i);
            if (charCnt[(int) ch - 97] > 0)
                sb.append(Character.toString(ch));
        }
        return sb.toString();
    }
}
