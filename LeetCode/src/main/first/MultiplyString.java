package first;
public class MultiplyString {
    public String multiply(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (a.equals("0") || b.equals("0")) {
            return "0";
        }
        
        int m = a.length();
        int n = b.length();
        if (m < n) {
            return multiply(b, a);
        }
        
        String sum = "";
        for (int i = n - 1; i >= 0; i--) {
            char d = b.charAt(i);
            String t = multiplyDigit(a, d, n - 1 - i);
            sum = addString(sum, t);
        }
        return trim(sum);
    }
    
    String multiplyDigit(String s, char d, int shiftLen) {
        int x = d - '0';
        StringBuffer sb = new StringBuffer();
        int addNum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int y = c - '0';
            int sum = x * y + addNum;
            addNum = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }
        if (addNum > 0) {
            sb.append(addNum);
        }
        sb.reverse();
        for (int i = 0; i < shiftLen; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
    
    String addString(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        
        StringBuffer sb = new StringBuffer();
        int addNum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int d1 = 0;
            int d2 = 0;
            if (i >= 0) {
                d1 = a.charAt(i) - '0';
            }
            if (j >= 0) {
                d2 = b.charAt(j) - '0';
            }
            
            int sum = d1 + d2 + addNum;
            addNum = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (addNum > 0) {
            sb.append(addNum);
        }
        sb.reverse();
        return sb.toString();
    }
    
    String trim(String s) {
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && !flag) {
                continue;
            }
            flag = true;
            sb.append(s.charAt(i));
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
    
}
