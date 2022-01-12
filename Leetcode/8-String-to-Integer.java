/*
* @source https://leetcode.com/problems/string-to-integer-atoi/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.12
*/

class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0 || (s.length() == 1 && !(s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' < 9)))
            return 0;
        boolean isPositive = true;
        StringBuilder numStr = new StringBuilder();
        try {
            s = s.trim();
            for (int i = 0, n = s.length(); i < n; i++) {
                char curCh = s.charAt(i);
                if (i == 0 && (curCh == '-' || curCh == '+')) {
                    isPositive = curCh == '+';
                }  else if (curCh == '.') {
                    if (i == 0) return 0;
                    return isPositive ? Integer.parseInt(numStr.toString()) : -Integer.parseInt(numStr.toString());
                } else  {
                    if (curCh - '0' == 0 && numStr.length() == 0)
                        continue;
                    if(curCh - '0' >= 0 && curCh - '0' <= 9)
                        numStr.append(curCh);
                    else
                        break;
                }
            }
            if (numStr.length() == 0)   return 0;
            return isPositive ? Integer.parseInt(numStr.toString()) : -Integer.parseInt(numStr.toString());
        } catch(Exception e) {
            return isPositive ? Integer.MAX_VALUE : -Integer.MIN_VALUE;
        }
    }
}
