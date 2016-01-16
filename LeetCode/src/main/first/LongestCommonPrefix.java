package first;
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (a.length == 0) {
			return "";
		} else if (a.length == 1) {
			return a[0];
		}

		int n = a.length;
		int i = 0;
		int m = a[0].length();
		boolean flag = true;

		while (i < m) {
			char c = a[0].charAt(i);
			for (int j = 1; j < n; j++) {
				if (i >= a[j].length()) {
					flag = false;
				} else if (c != a[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
			i++;
		}

		if (i == 0) {
			return "";
		} else {
			return a[0].substring(0, i);
		}
	}
}
