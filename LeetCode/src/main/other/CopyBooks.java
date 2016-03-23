package other;

public class CopyBooks {
    /**
     * Greedy way doesn't work! E.g,  1,1,1,1,1,1 with k = 2
     *
     * For i people and j books, find the minimal time: try to copy last t books for jth people
     * dp[i][j] = min(max(dp[i-1][t-1] + sum(a[t-1]),  i=<t<=j)
     * while  i<=j
     *
     * Reference: http://sidbai.github.io/2015/07/25/Copy-Books/
     *
     * Time: O(k*n*n)
     */
    public int copyBooks(int[] a, int k) {
        if(a.length==0 || k==0) return 0;

        int n = a.length;
        k = Math.min(k, n);
        int[][] dp = new int[k+1][n+1];
        for(int i=0;i<=k;i++){
            for(int j=i;j<=n;j++){
                if(j==0){
                    dp[i][j] = 0;
                } else if(i==0){
                    dp[i][j] = Integer.MAX_VALUE;
                } else{
                    dp[i][j] = Integer.MAX_VALUE;
                    int sum = 0;
                    for(int t=i;t<=j;t++) {
                        sum += a[t-1];
                    }
                    for(int t=i;t<=j;t++) {
                        if(dp[i-1][t-1] == Integer.MAX_VALUE) break;

                        int max = Math.max(dp[i-1][t-1], sum);
                        dp[i][j] = Math.min(dp[i][j], max);
                        sum -= a[t-1];
                    }
                }
            }
        }

        return dp[k][n];
    }

    /**
     * Brute force
     */
    int time = Integer.MAX_VALUE;
    public int copyBooks_slow(int[] a, int k) {
        if(a.length==0 || k==0) return 0;
        k = Math.min(k, a.length);

        time = Integer.MAX_VALUE;
        backtrack(a, 0, 0, k);
        return time;
    }

    private void backtrack(int[] a, int p, int max, int k){
        if(k==0){
            if(p == a.length){
                time = Math.min(time, max);
            }
        }else{
            int sum = 0;
            for(int i=p;i<=a.length-k;i++){
                sum += a[i];
                backtrack(a, i+1, Math.max(max, sum), k-1);
            }
        }
    }
}
