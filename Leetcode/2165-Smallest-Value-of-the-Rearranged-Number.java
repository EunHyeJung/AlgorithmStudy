/*
* @source https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.25
*/
class Solution {
        public long getPowLong(int n, int i) {
        long res = 1;
        if (i == 0) return res;
        while (i > 0) {
            res *= 10;
            i -= 1;
        }
        return res;
    }
    public long smallestNumber(long num) {
        boolean isPositive = num > 0;
        num = isPositive ? num : -num;
        List<Integer> numList = new ArrayList<>();
        while(num > 0) {
            numList.add((int) (num % 10));
            num /= 10;
        }
        Collections.sort(numList);

        long res = 0l;
        int n = numList.size();
        int curN = 0;
        if (isPositive) {
            for(int i = 0; i < n; i++) {
                curN = numList.get(i);
                if (curN == 0)
                    continue;
                if (res == 0)
                    res += curN * getPowLong(10, n - 1);
                else
                    res += curN * getPowLong(10, n - i - 1);
            }
        } else {
            for(int i = n - 1; i >= 0; i--) {
                curN = numList.get(i);
                if (i > 0 && numList.get(i - 1) == 0) {
                    res += curN * getPowLong(10, i);
                    break;
                }
                res += curN * getPowLong(10, i);
            }
        }
        return isPositive ? res : -res;
    }
}
