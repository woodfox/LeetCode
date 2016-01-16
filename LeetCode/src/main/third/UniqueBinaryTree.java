package third;

public class UniqueBinaryTree {
    /**
     * f(n) = | 1 if n = 0
     *        | Sum(f(i)*f(n-1-i), i=0..n-1
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}
