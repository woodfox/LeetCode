package second;

public class MaxRectangle {
    public int maximalRectangle(char[][] a) {
        int m = a.length;
        if(m == 0){
            return 0;
        }
        int n = a[0].length;
        if(n == 0){
            return 0;
        }
        
        int max = 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] > '0'){
                    if(j > 0){
                        dp[i][j] = dp[i][j-1] + 1;
                    }else{
                        dp[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int w = dp[i][j];
                for(int k=i;k>=0;k--){
                    w = Math.min(w, dp[k][j]);
                    if(w == 0){
                        break;
                    }
                    max = Math.max(max, w*(i-k+1));
                }
            }
        }
        return max;
    }
}
