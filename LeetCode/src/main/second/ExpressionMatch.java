package second;

public class ExpressionMatch {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int m = s.length();
        String t = p.replaceAll("\\*", "");
        int n = t.length();
        boolean[] star = new boolean[n];
        int j = 0;
        for(int i=0;i<m;i++){
            if(j < p.length()-1 && p.charAt(j+1) == '*'){
                star[i] = true;
                j++;
            }
            j++;
        }
        
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(j=0;j<=n;j++){
                if(i==0&&j==0){
                    dp[i][j] = true;
                }else if(j==0){
                    dp[i][j] = false;
                }else if(i==0){
                    dp[i][j] = star[j-1]&&dp[i][j-1];
                }else if(star[j-1]){
                    dp[i][j] = dp[i][j-1];
                    if(check(s.charAt(i-1), t.charAt(j-1))){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else{
                    dp[i][j] = dp[i-1][j-1] && check(s.charAt(i-1), t.charAt(j-1));
                }
            }
        }
        return dp[m][n];
    }
    
    boolean check(char c, char d){
        return d == '.' || c == d;
    }
}
