package third;

public class MultiplyString {
    public String multiply(String num1, String num2) {
        if(isEmpty(num1) || isEmpty(num2)) return "";

        num1 = trimLeftZero(num1);
        num2 = trimLeftZero(num2);
        return multiplyString(num2, num1);
    }

    String multiplyString(String num1, String num2){
        String sum = "0";
        for(int i=num2.length()-1;i>=0;i--){
            String sub = multiplyDigit(num1, num2.charAt(i), num2.length() -1 - i);
            sum = addString(sum, sub);
        }
        return trimLeftZero(sum);
    }

    String multiplyDigit(String num, char c, int zeros) {
        int multipler = c - '0';
        if(multipler == 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        int addOn = 0;
        for(int i=num.length()-1;i>=0;i--){
            int t = num.charAt(i) - '0';
            int sum = t * multipler + addOn;
            addOn = sum / 10;
            sb.append(sum % 10);
        }
        if(addOn > 0) sb.append(addOn);

        for(int i=0;i<zeros;i++){
            sb.insert(0, '0');
        }

        return sb.reverse().toString();
    }

    String addString(String s, String t) {
        StringBuffer sb = new StringBuffer();
        int addOn = 0;
        int pos = 0;
        while(pos < s.length() || pos < t.length() || addOn > 0){
            int a = getCharValue(s, pos);
            int b = getCharValue(t, pos);
            int sum = a + b + addOn;
            addOn = sum / 10;
            sb.append(sum % 10);
            pos++;
        }

        return sb.reverse().toString();
    }

    int getCharValue(String s, int pos) {
        if(pos < s.length()){
            return s.charAt(s.length() - pos - 1) - '0';
        }else{
            return 0;
        }
    }

    boolean isEmpty(String s ) {
        return s == null || s.length() == 0;
    }

    String trimLeftZero(String s) {
        char[] a = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        int pos = 0;
        while(pos < a.length && a[pos] == '0') pos++;
        while(pos < a.length) {
            sb.append(a[pos]);
            pos++;
        }
        if(sb.length() == 0) sb.append("0");

        return sb.toString();
    }
}
