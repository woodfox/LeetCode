package second;

public class PalindromePartitionII {
	//Time Limited Exceeded!!
	public int minCut(String s) {
	        if(s == null || s.length() == 0){
	            return 0;
	        }
	        
	        int n = s.length();
	        boolean[][] dp = new boolean[n][n];
	        for(int k=0;k<n;k++){
	            for(int i=0;i+k<n;i++){
	                int j = i+k;
	                if(i == j){
	                    dp[i][j] = true;
	                }else if(i == j-1){
	                    dp[i][j] = (s.charAt(i) == s.charAt(j));
	                }else{
	                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
	                }
	            }
	        }
	        
	        int[][] min = new int[n][n];
	        for(int l=0;l<n;l++){
	            for(int i=0;i+l<n;i++){
	                int j = i+l;
	                if(dp[i][j]){
	                    min[i][j] = 0;
	                }else{
	                    min[i][j] = Integer.MAX_VALUE;
	                    for(int k=i;k<j;k++){
	                        min[i][j] = Math.min(min[i][j], min[i][k]+min[k+1][j]+1);
	                    }
	                }
	            }
	        }
	        
	        return min[0][n-1];
	    }
}
