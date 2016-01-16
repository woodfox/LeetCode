package second;

public class EditDistance {
    public int minDistance(String s, String t) {
        if(s == null || t == null){
            return -1;
        }
        
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }else if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                    int replace = 1;
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        replace = 0;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + replace);
                }
            }
        }
        
        return dp[m][n];
    }
}
