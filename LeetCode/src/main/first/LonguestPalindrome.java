package first;
public class LonguestPalindrome {
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() <= 1) {
			return s;
		}

		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int max = 0;
		int start = 0;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n - k; i++) {
				int j = i + k;
				if (k == 0) {
					dp[i][j] = true;
				} else if (k == 1) {
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
				}
				if (dp[i][j] && j - i + 1 > max) {
					max = j - i + 1;
					start = i;
				}
			}
		}
		return s.substring(start, start + max);
	}
}
