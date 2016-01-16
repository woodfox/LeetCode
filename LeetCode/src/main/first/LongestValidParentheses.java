package first;
import java.util.LinkedList;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				q.add(-1);
			} else if (!q.isEmpty()) {
				int prev1 = q.removeLast();
				if (prev1 == -1) {
					prev1 = 2;
					q.add(prev1);
				} else if (prev1 > 0) {
					if (!q.isEmpty()) {
						int prev2 = q.removeLast();
						if (prev2 == -1) {
							prev1 += 2;
							q.add(prev1);
						} else {
							q.add(prev2);
							q.add(prev1);
							q.add(-2);
						}
					} else {
						q.add(prev1);
						q.add(-2);
					}
				} else {
					q.add(prev1);
					q.add(-2);
				}
			} else {
				q.add(-2);
			}
			merge(q);
		}

		int max = 0;
		for (int x : q) {
			if (x > max) {
				max = x;
			}
		}
		return max;
	}

	void merge(LinkedList<Integer> q) {
		while (!q.isEmpty()) {
			int prev1 = q.removeLast();
			if (prev1 < 0 || q.isEmpty()) {
				q.add(prev1);
				break;
			} else {
				int prev2 = q.removeLast();
				if (prev2 < 0) {
					q.add(prev2);
					q.add(prev1);
					break;
				} else {
					q.add(prev1 + prev2);
				}
			}
		}
	}

}
