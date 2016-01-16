package first;

public class PalindromeNumber {
	public static boolean isPalindrome(int a){
		if(a < 0){
			return false;
		}
		
		int p = 1;
		//it would be faster to use a/p >= 10 instead of p*10 <= a
		while(a/p >= 10){
			p = p*10;
		}
		
		while(a > 9){
			int first = a/p;
			int last = a%10;
			if(first != last){
				return false;
			}
			a = a%p/10;
			p = p/100;
		}
		return true;
	}
	
	public static boolean isPalindromeByString(int a){
		String s = "" + a;
		int i = 0;
		int j = s.length() - 1;
		while(i < j){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		System.out.println("Expected true, Actual:" + isPalindrome(1000110001));
	}
}
