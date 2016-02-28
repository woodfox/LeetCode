package third;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color. (at most 2 fence have same color)

 Return the total number of ways you can paint the fence.
 */
public class PaintFence {
    /**
     * For position i,
     *   1. if its color is different with i-1, then there are (k-1)*f(i-1) choices;
     *   2. if its color is same as i-1 but different with i-2, then there are (k-1)*f(i-2) choices;
     */
    int numWays(int n, int k) {
        if(n <= 0 || k <= 0) return 0;
        else if(n == 1) return k;

        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k*k;
        for(int i=2;i<n;i++){
            dp[i] = (k-1)*(dp[i-2] + dp[i-1]);
        }
        return dp[n-1];
    }
}
