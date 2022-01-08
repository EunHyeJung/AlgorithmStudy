
/*
* @source https://leetcode.com/problems/container-with-most-water/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.08
*/
class Solution {
    public int fib(int n) {
        if (n < 2)  return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
