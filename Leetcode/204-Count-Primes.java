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
        for (int i = 2; i <= n / 2; i++) {
            if (chk[i])
                continue;
            cnt += 1;
            for (int j = 2; i * j < n; j++) {
                chk[i * j] = true;
            }
        }
        for (int i = n / 2 + 1; i < n; i++) {
            if (!chk[i])    cnt += 1;
        }
        return cnt;
    }
}
