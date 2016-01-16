package first;
public class CountAndSay {
	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1) {
			return "1";
		}

		String s = countAndSay(n - 1);
		int count = 0;
		char pre = ' ';
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (pre == ' ') {
				pre = s.charAt(i);
				count = 1;
			} else if (pre == s.charAt(i)) {
				count++;
			} else {
				sb.append(count);
				sb.append(pre);
				pre = s.charAt(i);
				count = 1;
			}
		}
		if (count > 0) {
			sb.append(count);
			sb.append(pre);
		}
		return sb.toString();
	}

}
