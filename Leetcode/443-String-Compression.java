/*
* @source https://leetcode.com/problems/string-compression/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.15
*/
class Solution {
   public int compress(char[] chars) {
        int n = chars.length;
        if (n == 1) return n;

        int i = 0, j = i + 1, k = 0;
        boolean isCompressed = false;
        while(true) {
            if (i >= n) break;
            chars[k++] = chars[i];
            while(j < n && chars[i] == chars[j]) {
                j += 1;
                isCompressed = true;
            }

            if (isCompressed) {
                String cntStr = Integer.toString(j - i);
                for (int si = 0, sn = cntStr.length(); si < sn; si++) {
                    chars[k++] = cntStr.charAt(si);
                }
            }
            i = j;
            j = i + 1;
            isCompressed = false;
        }

        return k;
    }
}
