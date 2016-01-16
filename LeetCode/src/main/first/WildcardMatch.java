package first;
import java.util.Arrays;


public class WildcardMatch {
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p == null || p.length() == 0) {
			return (s.length() == 0);
		}
		String[] t = p.split("\\*");
		for (int i = 0; i < t.length; i++) {
			if (t[i] == null || t[i].length() == 0) {
				continue;
			}else if(s.length() < t[i].length()){
				return false;
			}
			
			if(i > 0 && i == t.length-1 && !p.endsWith("*")){
				s = s.substring(s.length() - t[i].length());
			}
			
			int index = find(s, t[i]);
			if (index == -1) {
				return false;
			} else if (i == 0 && index != 0) {
				return false;
			}
			s = s.substring(index + t[i].length());
		}
		
		//Still some part of s is not matched
		if(s.length() > 0 && !p.endsWith("*")){
			return false;
		}
		return true;
	}

	int find(String s, String p) {
		for (int i = 0; i <= s.length() - p.length(); i++) {
			int j = 0;
			for (; j < p.length(); j++) {
				if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i + j)) {
					continue;
				} else {
					break;
				}
			}

			if (j == p.length()) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		WildcardMatch w = new WildcardMatch();
		System.out.println(w.isMatch("aa", "a"));
		System.out.println(w.isMatch("aa", "?*"));
		System.out.println(w.isMatch("aa", "*?"));
		System.out.println(Arrays.toString("?*".split("\\*")));
	}

	/*
	 * Time complexity: O(m*n) But this will throw Memory Limit Exceeded for
	 * large data set!!
	 */
	public boolean isMatch2(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = s.length();
		int n = p.length();
		if (m == 0 && n == 0) {
			return true;
		} else if (n == 0) {
			return false;
		}

		boolean[][] f = new boolean[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 && j == 0) {
					f[i][j] = true;
				} else if (j == 0) {
					f[i][j] = false;
				} else if (i == 0) {
					f[i][j] = f[i][j - 1] && (p.charAt(j - 1) == '*');
				} else {
					char c = p.charAt(j - 1);
					if (c != '*' && c != '?') {
						f[i][j] = (c == s.charAt(i - 1) && f[i - 1][j - 1]);
					} else if (c == '*') {
						// f[i][j] = false;
						// for (int x = 0; x <= i; x++) {
						// if (f[x][j - 1]) {
						// f[i][j] = true;
						// break;
						// }
						// }
						f[i][j] = f[i - 1][j] || f[i][j - 1];
					} else {
						f[i][j] = f[i - 1][j - 1];
					}
				}
			}
		}

		return f[m][n];
	}

}
