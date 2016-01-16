package first;

public class ReverseInteger {
	public static int reverseInt(int x){
		int sign = 1;
		if(x < 0){
			sign = -1;
			x = x*-1;
		}
		int r = 0;
		while(x > 0){
			int digit = x%10;
			x = x/10;
			r = r*10 + digit;
		}
		
		return r*sign;
	}
	
	public static void main(String[] args){
		System.out.println("Expected 1, Actual:" + reverseInt(1));
		System.out.println("Expected 321, Actual:" + reverseInt(123));
		System.out.println("Expected -4321, Actual:" + reverseInt(-1234));
		System.out.println("Expected 1, Actual:" + reverseInt(10));
		System.out.println("Expected 1, Actual:" + reverseInt(100));
		System.out.println("Expected -1, Actual:" + reverseInt(-1000));
		System.out.println("Expected 5001, Actual:" + reverseInt(1005));
	}
}
