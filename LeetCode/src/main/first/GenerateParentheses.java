package first;
import java.util.ArrayList;

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<String>> f = new ArrayList<ArrayList<String>>();
		for (int i = 0; i <= n; i++) {
			f.add(new ArrayList<String>());
			if (i == 0) {
				f.get(i).add("");
			} else if (i == 1) {
				f.get(i).add("()");
			} else {
				for (int j = 0; j <= i - 1; j++) {
					for (String s : f.get(j)) {
						for (String t : f.get(i - 1 - j)) {
							f.get(i).add("(" + s + ")" + t);
						}
					}
				}
			}
		}

		return f.get(n);
	}
}
