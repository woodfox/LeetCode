package second;



public class WildcardMatch {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        
        if(p.length() == 0){
            return s.length() == 0;
        }
        
        String[] a = p.split("\\*");
        int n = a.length;
        String t = s;
        for(int i=0;i<n;i++){
        	if(a[i] == null || a[i].length() == 0){
                continue;
            }
        	
        	if(t.length() < a[i].length()){
            	return false;
            }
            
        	//Find position from end to start for last part
        	if(i>0 && i == n-1 && !p.endsWith("*")){
        		t = t.substring(t.length() - a[i].length());
        	}
        	
            int pos = find(t, a[i]);
            if(pos == -1){
                return false;
            }
            if(i == 0 && pos > 0 && !p.startsWith("*")){
            	return false;
            }
            t = t.substring(pos + a[i].length());
        }
        
        if(t.length() > 0 && !p.endsWith("*")){
            return false;
        }

        return true;
    }
    
    int find(String s, String p){
        int m = s.length();
        int n = p.length();
        for(int i=0;i<=m-n;i++){
            int j;
            for(j=0;j<n;j++){
                char c = p.charAt(j);
                if(c != '?' && s.charAt(i+j) != c){
                    break;
                }
            }
            if(j >= n){
                return i;
            }
        }
        return -1;
    }
    
	//TLE with O(m*n)
    public boolean isMatch2(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = (p.charAt(j-1) == '*') && dp[i][j-1];
                }else if(j==0){
                    dp[i][j] = false;
                }else{
                    char c = p.charAt(j-1);
                    char d = s.charAt(i-1);
                    if(c == '?'){
                        dp[i][j] = dp[i-1][j-1];
                    }else if(c == '*'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }else{
                        dp[i][j] = (c == d) && dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
    
    public static void main(String[] args){
    	WildcardMatch w = new WildcardMatch();
    	System.out.println(w.isMatch("b", "?*?"));
    }
}
