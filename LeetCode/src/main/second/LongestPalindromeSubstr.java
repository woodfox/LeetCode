package second;

public class LongestPalindromeSubstr {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String sub = "";
        for(int k=0;k<n;k++){
            for(int i=0;i+k<n;i++){
                int j = i+k;
                if(k == 0){
                    dp[i][j] = true;
                }else if(k == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
                if(dp[i][j] && j-i+1 > sub.length()){
                    sub = s.substring(i, j+1);
                }
            }
        }
        return sub;
    }
}
