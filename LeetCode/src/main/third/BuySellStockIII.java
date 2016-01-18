package third;

public class BuySellStockIII {
    /**
     * Given a position, calculate the max profit on the left and right using dp.
     * Time: O(n)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) {
            return 0;
        }

        // Calculate the maximum profit of first trade on the left of position i (inclusive)
        int min = prices[0];
        int[] first = new int[n];
        first[0] = 0;
        for(int i=1;i<n;i++) {
            first[i] = Math.max(first[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        // Calculate the minimum profit of second trade on the right of position i (inclusive)
        int max = prices[n-1];
        int[] second = new int[n];
        second[n-1] = 0;
        for(int i=n-2;i>=0;i--) {
            second[i] = Math.max(second[i+1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        // Get max sum of two trades (should consider only one trade as well)
        int profit = first[n-1];
        for(int i=1;i<n-2;i++) {
            int sum = first[i] + second[i+1];
            profit = Math.max(profit, sum);
        }

        return profit;
    }
}
