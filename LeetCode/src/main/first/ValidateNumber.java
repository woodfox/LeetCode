package first;
public class ValidateNumber {
	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		boolean eFlag = false;
		boolean fraction = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '.' && c != 'e' && c != '+' && c != '-'
					&& !(c >= '0' && c <= '9')) {
				return false;
			}
			if (c == '.') {
				if (fraction) {
					return false;
				}
				if (eFlag) {
					return false;
				}
				fraction = true;
			} else if (c == 'e') {
				if (eFlag) {
					return false;
				}
				eFlag = true;
			}
		}

		int p = s.indexOf("e");
		if (p == 0 || p == s.length() - 1) {
			return false;
		} else if (p == -1) {
			return validateNumber(s);
		} else {
			return validateNumber(s.substring(0, p))
					&& validateNumber(s.substring(p + 1));
		}
	}

	boolean validateNumber(String s) {
		boolean digits = false;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == '+' || s.charAt(i) == '-') && i > 0) {
				return false;
			}
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				digits = true;
			}
		}
		return digits;
	}
}
