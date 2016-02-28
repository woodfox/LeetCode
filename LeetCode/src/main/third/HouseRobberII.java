package third;

/**
 * Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    /**
     * Remove a[0] or a[n-1] and see what's the max money:
     * f(i) = max(f(i-1),  f(i-2)+a[i])
     *
     */
    public int rob(int[] a) {
        int n = a.length;
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return a[0];
        }

        return Math.max(rob(a, 0, n-2), rob(a, 1, n-1));
    }

    private int rob(int[] a, int start, int end) {
        int n = end-start+1;
        int[] dp = new int[n];
        dp[0] = a[start];
        for(int i=start+1;i<=end;i++) {
            if(i-start >= 2) {
                dp[i-start] = dp[i-start-2] + a[i];
            } else {
                dp[i-start] = a[i];
            }

            dp[i-start] = Math.max(dp[i-start], dp[i-start-1]);
        }

        return dp[end-start];
    }
}
