package other;

public class CoinInLineII {
    /**
     * DP[i] is the max value that first player can get from 0 to I.
     *
     * DP[i] = max(a[i] + min(DP[i+1+1], DP[i+1+2]),
     *             a[i]+a[i+1]+min(DP[i+2+1],DP[i+2+2])
     *
     * Reference: http://www.mamicode.com/info-detail-1114851.html
     */
    public boolean firstWillWin(int[] a) {
        int n = a.length;
        if(n<=2) return true;

        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = a[n-1];
        dp[n-2] = a[n-1] + a[n-2];
        dp[n-3] = a[n-2] + a[n-3];  //Why?
        for(int i=n-4;i>=0;i--){
            dp[i] = a[i] + Math.min(dp[i+1+1], dp[i+1+2]);
            dp[i] = Math.max(dp[i], a[i] + a[i+1] + Math.min(dp[i+2+1], dp[i+2+2]));
        }

        int sum = 0;
        for(int x : a) sum+=x;
        return dp[0] > (sum-dp[0]);
    }
}
