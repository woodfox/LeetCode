package second;

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        if(m == 0){
            return 0;
        }
        int n = a[0].length;
        if(n == 0){
            return 0;
        }
        
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1];
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
                }
            }
        }
        return dp[m-1][n-1];
    }
}
