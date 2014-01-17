package second;

import java.util.ArrayList;

public class PalindromePartition {
	public ArrayList<ArrayList<String>> partition(String s) {
	        ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();
	        if(s == null){
	            return r;
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
	        
	        backtrack(s, dp, 0, new ArrayList<String>(), r);
	        return r;
	    }

	private void backtrack(String s, boolean[][] dp, int p, ArrayList<String> sub,
			ArrayList<ArrayList<String>> r) {
		if (p >= dp.length) {
			r.add(new ArrayList<String>(sub));
		} else {
			for (int i = p; i < dp.length; i++) {
				if (dp[p][i]) {
					sub.add(s.substring(p, i + 1));
					backtrack(s, dp, i + 1, sub, r);
					sub.remove(sub.size() - 1);
				}
			}
		}
	}
}
