package other;

/**
 * Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

 The number in each subarray should be contiguous.

 Return the largest sum.
 */
public class MaximumSubArrayIII {
    /**
     * For max sum of k subarrays in range [0,i], it could be reduced by left[k-1] + rightMax
     *
     * dp(i,j) = max(dp[x][j-1] + rightMax(x+1, j))
     *  0<=j<=k, 0<=i<=n-j
     *
     *  Time: O(k*n^2)
     */
    public int maxSubArray(int[] nums, int k) {
        int n = nums.length;
        int[][] d = new int[n+1][k+1];
        for (int j = 1; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                d[i][j] = Integer.MIN_VALUE;
                int max = Integer.MIN_VALUE;
                int localMax = 0;
                for (int m = i-1; m >= j-1; m--) {
                    localMax = Math.max(0, localMax) + nums[m];
                    max = Math.max(localMax, max);
                    d[i][j] = Math.max(d[i][j], d[m][j-1] + max);
                }
            }
        }
        return d[n][k];
    }
}
