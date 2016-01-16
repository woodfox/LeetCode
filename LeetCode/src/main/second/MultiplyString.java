package second;

public class MultiplyString {
    public String multiply(String s, String t) {
        if(s == null || t == null){
            return null;
        }else if(s.equals("0") || t.equals("0")){
            return "0";
        }
        
        int m = s.length();
        int n = t.length();
        if(m < n){
            return multiply(t, s);
        }
        
        StringBuffer sb = new StringBuffer(s);
        String r = "0";
        for(int i=n-1;i>=0;i--){
            int k = t.charAt(i) - '0';
            String tmp = multiplyDigit(sb.toString(), k);
            r = addString(r, tmp);
            sb.append("0");
        }
        return r;
    }
    
    String multiplyDigit(String s, int k){
        if(k == 0){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        int added = 0;
        for(int i=s.length()-1;i>=0;i--){
            int d = s.charAt(i) - '0';
            d = d*k + added;
            sb.append(d%10);
            added = d/10;
        }
        if(added > 0){
            sb.append(added);
        }
        sb.reverse();
        return sb.toString();
    }
    
    String addString(String s, String t){
        int m = s.length();
        int n = t.length();
        int i = m-1;
        int j = n-1;
        StringBuffer sb = new StringBuffer();
        int added = 0;
        while(i >= 0 || j >= 0){
            int a = 0;
            if(i >= 0){
                a = s.charAt(i) - '0';
            }
            int b = 0;
            if(j >= 0){
                b = t.charAt(j) - '0';
            }
            int r = a+b+added;
            sb.append(r%10);
            added = r/10;
            i--;
            j--;
        }
        if(added > 0){
            sb.append(added);
        }
        sb.reverse();
        return sb.toString();
    }
}
