package third;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again)
 */
public class BuySellStockIV {
    /**
     * dp(i, k) = max(dp(j, k-1) + a[i] - a[j]), 0 <= j < i, min is minimal within [j,i]
     *          = a[i] + max(dp(j,k-1)-a[j]), so that we can get localMax in one loop
     *
     * Time: O(n*k)   Space: O(n*k)
     */
    public int maxProfit(int k, int[] a) {
        int n = a.length;
        if(n<=1) return 0;

        if(k >= n) {
            return maxProfitWithoutLimit(a);
        }

        int[][] dp = new int[n][k+1];
        for(int j=1;j<=k;j++){
            int localMax = dp[0][j-1]-a[0];
            for(int i=1;i<n;i++){
                dp[i][j] = Math.max(dp[i-1][j], localMax + a[i]);
                localMax = Math.max(localMax, dp[i][j-1]-a[i]);
            }
        }

        return dp[n-1][k];
    }

    /**
     * For position i with j trades, the max profit would be:
     *  1. max profit of position i-1 with j trade, plus p[i]-p[i-1], if the value before i-1 is already increasing; OR
     *  2. max profit of position i-1 with j-1 trade, plus max(p[i]-p[i-1], 0) if the value is decreasing before i-1,
     *     but starts to increase from i-1 to i;
     *
     * local[i,j] is the max profits from (0..i) with j trades, and must sell on position i;
     * global[i,j] is the max profits from (0..i) with j trades (doesn't reqire selling on pos i);
     *
     * local(i,j) = max(global(i-1,j-1) + abs(diff),  local(i-1,j)+diff)
     * global(i,j) = max(global(i-1,j), local(i,j))
     */
    public int maxProfit_complex(int k, int[] p) {
        if (p.length <= 1 || k == 0) {
            return 0;
        }

        int n = p.length;
        if(k >= n) {
            return maxProfitWithoutLimit(p);
        }

        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for(int i=1;i<n;i++) {
            int diff = p[i] - p[i-1];
            for(int j=k;j>=1;j--) {
                local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }

        return global[k];
    }

    private int maxProfitWithoutLimit(int[] p) {
        int profit = 0;
        for(int i=1;i<p.length;i++) {
            if(p[i] > p[i-1]) {
                profit += p[i]-p[i-1];
            }
        }

        return profit;
    }

    /**
     * DP to calculate max profit for 1,2...k trades.
     *
     * For 0<=j<=k,  0<=i<n :
     * dp(i,j) = | 0   if j == 0 or i >= n-1
     *           | max(dp[i+1][j],   // do not buy on p[i]
     *                 max(p[x]-p[i]+dp[x+1][j-1])  //i<x<n, find position x to sell that profit is max
     *             )
     *
     * Time: O(k*n^2)
     * Space:O(nk)
     */
    public int maxProfit_slow(int k, int[] p) {
        if(p.length <= 1 || k == 0) {
            return 0;
        }

        int n = p.length;
        int[][] dp = new int[n+1][k+1];
        for(int j=0;j<=k;j++) {
            for(int i=n;i>=0;i--) {
                if(j == 0 || i >= n-1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i+1][j];
                    for(int x=i+1;x<n;x++) {
                        dp[i][j] = Math.max(dp[i][j], p[x]-p[i]+dp[x+1][j-1]);
                    }
                }
            }
        }

        int max = 0;
        for(int i=0;i<n;i++) {
            max = Math.max(max, dp[i][k]);
        }
        return max;
    }

    /**
     * dp(i, k) = max(dp(j, k-1) + a[i] - min), 0 <= j < i, min is minimal within [j,i]
     *
     * Time: O(n*n*k)   Space: O(n*k)
     */
    public int maxProfit_slow2(int k, int[] a) {
        int n = a.length;
        if(n<=1) return 0;

        if(k >= n) {
            return maxProfitWithoutLimit(a);
        }

        int[][] dp = new int[n][k+1];
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = dp[i-1][j];
                int min = a[i];
                for(int x=i-1;x>=0;x--){
                    min = Math.min(min, a[x]);
                    dp[i][j] = Math.max(dp[i][j], dp[x][j-1] + a[i] - min);
                }
            }
        }

        return dp[n-1][k];
    }

    public int maxProfit_lessSpace(int k, int[] a) {
        int n = a.length;
        if(n<=1) return 0;

        if(k >= n) {
            return maxProfitWithoutLimit(a);
        }

        int[] dp = new int[n];
        for(int j=1;j<=k;j++){
            // Need to keep dp[] unchanged for old values with j-1
            int[] newDp = new int[n];
            for(int i=1;i<n;i++){
                newDp[i] = newDp[i-1];
                int min = a[i];
                for(int x=i-1;x>=0;x--){
                    min = Math.min(min, a[x]);
                    newDp[i] = Math.max(newDp[i], dp[x] + a[i] - min);
                }
            }
            dp = newDp;
        }

        return dp[n-1];
    }
}
