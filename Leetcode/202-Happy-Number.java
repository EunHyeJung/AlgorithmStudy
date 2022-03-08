/*
* @source https://leetcode.com/problems/happy-number/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.08
*/
class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> chkMap = new HashMap<>();
        while (true) {
            int squareSum = 0;
            while (n > 0) {
                squareSum += Math.pow((n % 10), 2);
                n /= 10;
            }
            if (chkMap.containsKey(squareSum))
                break;
            if (squareSum == 1)
                return true;
            chkMap.put(squareSum, true);
            n = squareSum;
        }
        return false;
    }
}
