package second;

import java.util.Set;

public class WordBreak {
	   public boolean wordBreak(String s, Set<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s == null||s.length() == 0){
	            return false;
	        }
	        
	        int n = s.length();
	        boolean[][] dp = new boolean[n][n];
	        for(int k=0;k<n;k++){
	            for(int i=0;i+k<n;i++){
	                int j = i+k;
	                if(dict.contains(s.substring(i, j+1))){
	                    dp[i][j] = true;
	                }else{
	                    for(int x=i;x<j;x++){
	                        if(dp[i][x] && dp[x+1][j]){
	                            dp[i][j] = true;
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	        
	        return dp[0][n-1];
	    }
}
