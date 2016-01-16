package first;
public class LastWordLength {
	public int lengthOfLastWord(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null) {
			return 0;
		}
		s = s.trim();
		int n = s.length();
		if (n == 0) {
			return 0;
		}
		int l = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				break;
			}
			l++;
		}
		return l;
	}
}
