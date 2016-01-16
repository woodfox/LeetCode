package first;
import java.util.ArrayList;
import java.util.HashMap;

public class ConcatenationOfWords {
	public ArrayList<Integer> findSubstring(String s, String[] l) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> r = new ArrayList<Integer>();
		int n = l.length;
		if (n == 0) {
			return r;
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			Integer count = map.get(l[i]);
			if (count == null) {
				count = 0;
			}
			map.put(l[i], count + 1);
		}
		int m = s.length();
		int x = l[0].length();
		for (int i = 0; i <= m - x * n; i++) {
			HashMap<String, Integer> current = new HashMap<String, Integer>();
			int j = 0;
			for (; j < n; j++) {
				String t = s.substring(i + j * x, i + j * x + x);
				if (map.get(t) == null) {
					break;
				}
				Integer count = current.get(t);
				if (count == null) {
					count = 0;
				}
				current.put(t, count + 1);
				if (current.get(t) > map.get(t)) {
					break;
				}
			}
			if (j == n) {
				r.add(i);
			}
		}
		return r;
	}

	// Time Limit Exceeded error for large data set!!
	public ArrayList<Integer> findSubstring2(String s, String[] l) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> r = new ArrayList<Integer>();
		if (l.length == 0) {
			return r;
		}
		int x = l.length;
		int n = l[0].length();
		int m = s.length();
		if (m < n * x) {
			return r;
		}

		long[] sum = new long[m - n * x + 1];
		for (int i = m - n * x; i < m; i++) {
			sum[m - n * x] += s.charAt(i);
		}
		for (int i = m - n * x - 1; i >= 0; i--) {
			sum[i] = sum[i + 1] + s.charAt(i) - s.charAt(i + n * x);
		}
		long p = 0;
		for (String t : l) {
			for (int i = 0; i < n; i++) {
				p += t.charAt(i);
			}
		}

		for (int i = 0; i <= m - n * x; i++) {
			if (sum[i] == p) {
				if (containAll(s, i, l)) {
					r.add(i);
				}
			}
		}
		return r;
	}

	boolean containAll(String s, int start, String[] l) {
		int n = l[0].length();
		int x = l.length;
		boolean[] f = new boolean[x];
		for (int i = 0; i < x; i++) {
			int j = start + i * n;
			boolean found = false;
			String t = s.substring(j, j + n);
			for (int k = 0; k < x; k++) {
				if (!f[k] && t.equals(l[k])) {
					f[k] = true;
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ConcatenationOfWords c = new ConcatenationOfWords();
		String[] l = { "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba" };
		String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
		ArrayList<Integer> result = c.findSubstring(s, l);
		System.out.println(result);
	}
}
