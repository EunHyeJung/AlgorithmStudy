/*
* @source https://leetcode.com/problems/coin-change/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.26
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = 0;
        if (amount == 0)
            return res;
        int[] dp = new int[amount + 1];
        int n = coins.length;
        Arrays.sort(coins);
        if (amount < coins[0])
            return  -1;

        for (int i = 0; i < n && coins[i] <= amount; i++) {
            dp[coins[i]] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 1) continue;
            dp[i] = Integer.MAX_VALUE;
            if (i < coins[0])   continue;
            for (int j = 0; j < n && coins[j] < i; j++) {
                if (dp[coins[j]] != Integer.MAX_VALUE && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[coins[j]] + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE || dp[amount] == 0 ? -1 : dp[amount];
    }
}
