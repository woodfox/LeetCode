package first;
public class DistinctSubsequence {
	public int numDistinct(String s, String t) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = i + 1; j <= n; j++) {
				dp[i][j] = 0;
			}
			dp[i][0] = 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= i && j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args){
		DistinctSubsequence d = new DistinctSubsequence();
		System.out.println(d.numDistinct("a", "b"));
	}
}
