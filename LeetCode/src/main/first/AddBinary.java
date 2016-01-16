package first;
public class AddBinary {
	public String addBinary(String s, String t) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i = s.length() - 1;
		int j = t.length() - 1;
		StringBuffer sb = new StringBuffer();
		int addFlag = 0;
		while (i >= 0 || j >= 0) {
			char a = '0';
			if (i >= 0) {
				a = s.charAt(i);
			}
			char b = '0';
			if (j >= 0) {
				b = t.charAt(j);
			}
			int c = (a - '0') + (b - '0') + addFlag;
			addFlag = c / 2;
			sb.append(c % 2);
			i--;
			j--;
		}
		if (addFlag == 1) {
			sb.append(1);
		}
		sb.reverse();
		return sb.toString();
	}
}
