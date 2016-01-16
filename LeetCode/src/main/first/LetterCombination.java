package first;
import java.util.ArrayList;

public class LetterCombination {
	final String[] mapping = { "abc", "def", "ghi", "jkl", "mno", "pqrs",
			"tuv", "wxyz" };

	public ArrayList<String> letterCombinations(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> r = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		backtrack(s, 0, sb, r);
		return r;
	}

	void backtrack(String s, int k, StringBuffer sb, ArrayList<String> r) {
		if (k == s.length()) {
			r.add(sb.toString());
		} else {
			int x = s.charAt(k) - '0';
			String candicate = mapping[x - 2];
			for (int i = 0; i < candicate.length(); i++) {
				char c = candicate.charAt(i);
				sb.append(c);
				backtrack(s, k + 1, sb, r);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
