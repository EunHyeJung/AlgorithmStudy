/*
* @source https://leetcode.com/problems/find-common-characters/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.28
*/

class Solution {
    public int minDeletions(String s) {
        int res = 0;
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);

        int curCnt = 1;
        boolean[] chk = new boolean[10001];
        for (int i = 1, n = s.length(); i < n; i++) {
            if (chArr[i] != chArr[i - 1]) {
                while (curCnt > 0 && chk[curCnt])  {
                    curCnt -= 1;
                    res += 1;
                }
                chk[curCnt] = true;
                curCnt = 1;
            } else
                curCnt += 1;
        }

        while (curCnt > 0 && chk[curCnt]) {
            curCnt -= 1;
            res += 1;
        }

        return res;
    }
}
