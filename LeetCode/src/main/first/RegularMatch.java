package first;

public class RegularMatch {
	public static boolean isMatch(String s, String p){
		if(s == null && p == null){
			return true;
		}else if(s == null || p == null){
			return false;
		}
		String t = p.replace("*", "");
		boolean[] starts = new boolean[t.length()];
		int pos = 0;
		for(int i=0;i<p.length();i++){
			if(i < p.length() -1 && p.charAt(i+1) == '*'){
				starts[pos] = true;
				i++;
			}
			pos++;
		}
		
		int m = s.length();
		int n = t.length();
		boolean[][] dp = new boolean[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i == 0 && j == 0){
					dp[i][j] = true;
				}else if(j == 0){
					dp[i][j] = false;
				}else if(i == 0){
					dp[i][j] = dp[i][j-1] && starts[j-1];
				}else{
					char c = t.charAt(j-1);
					if(c == '.'){
						if(!starts[j-1]){
							dp[i][j] = dp[i-1][j-1];
						}else{
							dp[i][j] = dp[i-1][j] || dp[i][j-1];
						}
					}else if(starts[j-1]){
						dp[i][j] = dp[i][j-1] || (dp[i-1][j] && c == s.charAt(i-1));
					}else{
						dp[i][j] = dp[i-1][j-1] && c == s.charAt(i-1);
					}
				}
			}
		}
		
		return dp[m][n];
	}
	
	public static void main(String[] args){		
		System.out.println("Expected false, Actual:" + isMatch("aa", "a"));
		System.out.println("Expected true, Actual:" + isMatch("aa", "aa"));
		System.out.println("Expected false, Actual:" + isMatch("aaa", "aa"));
		System.out.println("Expected true, Actual:" + isMatch("aa", "a*"));
		System.out.println("Expected true, Actual:" + isMatch("aa", ".*"));
		System.out.println("Expected true, Actual:" + isMatch("ab", ".*"));
		System.out.println("Expected true, Actual:" + isMatch("aab", "c*a*b"));
		System.out.println("Expected true, Actual:" + isMatch("aaaaaa", "aa*"));
		System.out.println("Expected true, Actual:" + isMatch("ab", "a*c*b*"));
		System.out.println("Expected true, Actual:" + isMatch("aaaaabbbbccccc", "a*b*c*"));
		System.out.println("Expected true, Actual:" + isMatch("aaadddddddddbbbbbbccc", "a.*c"));
		System.out.println("Expected false, Actual:" + isMatch("aaaddddddbbbbbbccc", "a.*d"));
	}
}
