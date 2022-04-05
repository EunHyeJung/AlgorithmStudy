/*
* @source https://leetcode.com/problems/count-and-say/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.05
*/
class Solution {
   public String count(int n, int curN, String say) {
        if (curN == n)
            return say;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0, m = say.length(); i < m; i++) {
            if (i > 0 && say.charAt(i) != say.charAt(i - 1)) {
                sb.append(cnt);
                sb.append(say.charAt(i - 1));
                cnt = 1;
            } else
                cnt += 1;
        }
        sb.append(cnt);
        sb.append(say.charAt(say.length() - 1));
        return count(n, curN + 1 , sb.toString());
    }
    public String countAndSay(int n) {
       return count(n, 1, "1");
    }
}
