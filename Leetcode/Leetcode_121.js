/**
 * Leetcode. 121. Best Time to Buy and Sell Stoc
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2021.12.05
 * @link https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
var maxProfit = function(prices) {
    let buyPrice = 99999, profit = 0;
    for (let i = 0, n = prices.length; i < n; i++) {
      if (prices[i] < buyPrice) {
        buyPrice = prices[i];
        continue;
      }
      profit = Math.max(prices[i] - buyPrice, profit);
    }
    return profit;
};
