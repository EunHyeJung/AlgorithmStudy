/*
* @source https://leetcode.com/problems/find-common-characters/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.02
*/
class Solution {
    public int countPrimes(int n) {
        int cnt = 0;
        if (n < 2)  return cnt;
        boolean[] chk = new boolean[n + 1];
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (chk[i])
                continue;
            for (int j = 2; i * j < n; j++) {
                chk[i * j] = true;
            }
        }
        for (int i = 2; i < n; i++) {
            if (!chk[i])
                cnt += 1;
        }
        return cnt;
    }
}
