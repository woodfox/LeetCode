package second;

public class DistinctSubSequence {
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return 0;
        }
        
        int m = s.length();
        int n = t.length();
        if(m == 0 || n == 0){
            return 0;
        }        
        
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0] = 1;
        }
        for(int j=1;j<=n;j++){
            for(int i=j;i<=m;i++){
                dp[i][j] = dp[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        
        return dp[m][n];
    }
}
