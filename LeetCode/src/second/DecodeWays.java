package second;

public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c > '0'){
                dp[i] = dp[i+1];
                
                if(i <= n-2 && Integer.parseInt(s.substring(i, i+2)) <= 26){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
