package third;

public class StringToInteger {
    public int atoi(String s) {
        if(s == null || s.trim().length() == 0) return 0;
        s = s.trim();
        int flag = 1;
        if(s.charAt(0) == '-') {
            flag = -1;
            s = s.substring(1);
        }else if(s.charAt(0) == '+') {
            s = s.substring(1);
        }
        double r = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c < '0' || c > '9'){
                break;
            }
            r = r * 10 + (c - '0');
        }
        r = r * flag;
        if(r > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(r < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)r;
        }
    }
}
