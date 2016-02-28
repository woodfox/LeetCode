package third;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 */
public class BuySellStock {
    // Time: O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) {
            return 0;
        }

        // Highest prices that could sell from position i (inclusive)
        int[] dp = new int[n];
        dp[n-1] = prices[n-1];
        for(int i=n-2;i>=0;i--) {
            dp[i] = Math.max(prices[i], dp[i+1]);
        }

        int profit = 0;
        for(int i=0;i<n-1;i++) {
            int diff = dp[i+1] - prices[i];
            profit = Math.max(profit, diff);
        }
        return profit;
    }

    // Slow version with time O(n^2)
    public int maxProfit_slow(int[] prices) {
        int n = prices.length;
        if(n < 2) {
            return 0;
        }

        int profit = 0;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int diff = prices[j] - prices[i];
                profit = Math.max(profit, diff);
            }
        }

        return profit;
    }
}
