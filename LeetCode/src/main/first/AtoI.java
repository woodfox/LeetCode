package first;


public class AtoI {
	public static int atoi(String s){
		double d = atoiDouble(s);
		if(d > 0 && d > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else if(d < 0 && d < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}else {
			return (int)d;
		}
	}
	
	public static double atoiDouble(String s){
		if(s == null){
			return 0;
		}
		s = s.trim();
		if(s.length() == 0){
			return 0;
		}
		
		long r = 0;
		int sign = 1;
		if(s.charAt(0) == '-'){
			sign = -1;
			s = s.substring(1);
		}else if(s.charAt(0) == '+'){
    	    s = s.substring(1);   
		}
		
		String[] p = s.split("e");
		if(p.length > 2){
			return 0;
		}else if(p.length == 2){
			double num = atoiDouble(p[0]);
			int pow = (int)atoiDouble(p[1]);
			return sign * num * Math.pow(10, pow);
		}else{
			String[] t = s.split("\\.");
			if(t.length > 2){
				return 0;
			}else if(t.length == 2){
				int num = (int)atoiDouble(t[0]);
				int digits = (int)atoiDouble(t[1]);
				if(digits < 0){
					return 0;
				}
				
				return sign * (num + digits * Math.pow(10, -1*t[1].length()));
			}else{
				for(int j=0;j<s.length();j++){
					char c = s.charAt(j);
					if(c >= '0' && c <= '9'){
						r = r*10 + (c - '0');
					}else{
						break;
					}
				}
				return sign*r;
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println("Expected 0, Actual:" + (int)atoi(""));
		System.out.println("Expected 0, Actual:" + (int)atoi(null));
		System.out.println("Expected 0, Actual:" + (int)atoi("00"));
		System.out.println("Expected 1, Actual:" + (int)atoi("1"));
		System.out.println("Expected -1, Actual:" + (int)atoi("-1"));
		System.out.println("Expected 1234, Actual:" + (int)atoi("1234"));
		System.out.println("Expected -1234, Actual:" + (int)atoi("-1234"));
		System.out.println("Expected 1234, Actual:" + (int)atoi("1234.5678"));
		System.out.println("Expected -1234, Actual:" + (int)atoi("-1234.5678"));
		System.out.println("Expected -123456, Actual:" + (int)atoi("-1234.5678e2"));
		System.out.println("Expected 12, Actual:" + (int)atoi("1234.5678e-2"));
		System.out.println("Expected -1234000, Actual:" + (int)atoi("-1234e3"));
		System.out.println("Expected -12, Actual:" + (int)atoi("-12345e-3"));
		System.out.println("Expected -12340, Actual:" + (int)atoi("-0.1234e5"));
		System.out.println("Expected 2147483648, Actual:" + (int)atoi("2147483648"));
		System.out.println("Expected 2147483647, Actual:" + (int)atoi("2147483647"));
		System.out.println("Expected 12, Actual:" + (int)atoi("12a"));
	}
}
