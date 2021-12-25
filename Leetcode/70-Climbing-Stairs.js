/*
* @source https://leetcode.com/problems/climbing-stairs/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.25
*/
var climbStairs = function(n) {
    if (n == 1 || n == 2) {
        return n;
    }
    dp = new Array();
    dp.push(0);
    dp.push(1);
    dp.push(2);
    for(let i = 3; i <= n; i++) {
        dp.push(dp[i-2] + dp[i-1]);
    }
    return dp[n];
};
