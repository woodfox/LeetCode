package second;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if(x < 0){
    		return false;
    	}
    	
		int p = 1;
		//it would be faster to use a/p >= 10 instead of p*10 <= a
		while(x/p >= 10){
			p = p*10;
		}
		
        while(x > 9){
            int i = x/p;
            int j = x%10;
            if(i != j){
                return false;
            }
            x = x%p;
            x = x/10;
            p = p/100;
        }
        return true;
    }
}
