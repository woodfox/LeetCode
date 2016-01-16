package third;

public class InterleaveString {
    /**
     * f(i, j) = | true  if i == 0, j == 0
     *           | s1(0,i) == s3(0,i)  if j == 0
     *           | s2(0,j) == s3(0,j)  if i == 0
     *           | (s1(i-1) == s3(i+j-1) && f(i-1,j))
     *             OR (s2(j-1) == s3(i+j-1) && f)i, j-1)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(s3.length() != m+n) return false;

        boolean[][] dp = new boolean[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j == 0){
                    dp[i][j] = true;
                }else if(j == 0){
                    dp[i][j] = s1.substring(0, i).equals(s3.substring(0, i));
                }else if(i == 0){
                    dp[i][j] = s2.substring(0, j).equals(s3.substring(0, j));
                }else{
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1)) && dp[i-1][j];
                    dp[i][j] = dp[i][j] || ((s2.charAt(j-1) == s3.charAt(i+j-1)) && dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
