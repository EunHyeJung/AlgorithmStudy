/**
 * Leetcode. 121. Best Time to Buy and Sell Stoc
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2021.12.05
 * @link https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

var maxProfit = function(prices) {
    lowestPrices = [];
    prices.forEach(function(price, idx) {
      if (lowestPrices.length == 0)
        lowestPrices.push(price);
      else {
        let previousPrice = lowestPrices[idx - 1];
        if (previousPrice > price)
          lowestPrices.push(price);
        else
          lowestPrices.push(previousPrice);
      }
    });
    let profit = 0;
    lowestPrices.forEach(function(lowestPrice, idx) {
      if (profit < prices[idx] - lowestPrice)
        profit = prices[idx] - lowestPrice;
    });
    return profit;
};
