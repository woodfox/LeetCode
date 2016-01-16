package second;

public class MaxSubArray {
    public int maxSubArray(int[] a) {
        int n = a.length;
        if(n == 0){
            return 0;
        }
        
        int[] dp = new int[n];
        dp[0] = a[0];
        int max = a[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1], 0) + a[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
