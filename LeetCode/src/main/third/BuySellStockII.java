package third;

public class BuySellStockII {
    // Time: O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) {
            return 0;
        }

        int profit = 0;
        int start = 0;
        while(start < n-1) {
            if(prices[start] >= prices[start+1]) {
                start++;
            } else {
                int end = start + 1;
                while (end + 1 < n && prices[end + 1] >= prices[end]) {
                    end++;
                }

                int diff = prices[end] - prices[start];
                profit += Math.max(diff, 0);

                // Move start to next position
                start = end + 1;
            }
        }

        return profit;
    }
}
