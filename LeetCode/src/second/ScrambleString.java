package second;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        int n = s1.length();
        if(s1.equals(s2)){
            return true;
        }
        
        boolean[][][] dp = new boolean[n][n][n+1];
        for(int k=1;k<=n;k++){
            for(int i=0;i+k<=n;i++){
                for(int j=0;j+k<=n;j++){
                    if(k == 1){
                        dp[i][j][k] = (s1.charAt(i) == s2.charAt(j));
                    }else{
                        for(int x = 1;x<k;x++){
                            dp[i][j][k] = (dp[i][j][x] && dp[i+x][j+x][k-x]) || (dp[i][j+k-x][x] && dp[i+x][j][k-x]);
                            if(dp[i][j][k]){
                            	break;
                            }
                        }
                    }
                }
            }
        }
        
        return dp[0][0][n];
    }
    
    public static void main(String[] args){
    	ScrambleString s = new ScrambleString();
    	System.out.println(s.isScramble("abc", "acb"));
    }
}
