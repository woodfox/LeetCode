package third;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]
 */
public class BuySellStockWithColldown {

    /**
     * DP to calculate max profit.
     *
     * buy[i] = max(buy[i-1], sell[i-2] - price[i]
     * sell[i] = max(sell[i-1], buy[i-1] + price[i]
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int[] buy = new int[n+1];
        int[] sell = new int[n+1];
        buy[1] = -prices[0];
        sell[1] = 0;
        for(int i=2;i<=n;i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i-1]);

            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i-1]);
        }

        return sell[n];
    }
}
