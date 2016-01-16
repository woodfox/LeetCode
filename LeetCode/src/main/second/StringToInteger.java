package second;

public class StringToInteger {
    public int atoi(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        s = s.trim();
        String[] a = s.split("e");
        double r = 0;
        if(a.length == 1){
            r = aToD(a[0]);
        }else if(a.length == 2){
            double x = aToD(a[0]);
            double y = aToD(a[1]);
            r = (x * Math.pow(10, (int)y));
            //Special case in leetcode
            if((r > 0 && r > Integer.MAX_VALUE) || (r < 0 && r < Integer.MIN_VALUE)){
            	r = x;
            }
        }else{
        	r = 0;
        }
        
        if(r > 0 && r > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(r < 0 && r < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)r;
        }
    }
    
    double aToD(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean flag = true;
        char c = s.charAt(0);
        if(c == '-'){
            flag = false;
        }
        if(c == '-' || c == '+'){
            s = s.substring(1);
        }
        double r = 0;
        String[] a = s.split("\\.");
        if(a.length == 1){
            r = (double)parseInt(s);
        }else if(a.length == 2){
            long x = parseInt(a[0]);
            long y = parseInt(a[1]);
            int n = (""+y).length();
            r = x + Math.pow(10, -1*n)*y;
        }else{
        	return 0;
        }
        
        if(!flag){
            r = r*-1;
        }
        return r;
    }
    
    long parseInt(String s){
        long r = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c > '9' || c < '0'){
                return r;
            }
            r = r*10 + (c-'0');
        }
        return r;
    }
    
    public static void main(String[] args){
    	StringToInteger s = new StringToInteger();
    	System.out.println(s.atoi("-1000"));
    }
}
