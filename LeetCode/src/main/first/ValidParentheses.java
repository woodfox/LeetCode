package first;
import java.util.LinkedList;

public class ValidParentheses {
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		LinkedList<Character> q = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				q.add(c);
			} else if (c == ')') {
				if (q.isEmpty() || q.removeLast() != '(') {
					return false;
				}
			} else if (c == '}') {
				if (q.isEmpty() || q.removeLast() != '{') {
					return false;
				}
			} else if (c == ']') {
				if (q.isEmpty() || q.removeLast() != '[') {
					return false;
				}
			}
		}

		if (!q.isEmpty()) {
			return false;
		}
		return true;
	}

}
