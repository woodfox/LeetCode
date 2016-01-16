package first;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
        	return true;
        }
        String t = s.toLowerCase();
        int i = 0;
        int j = t.length() -1;
        while(i < j){
        	if(!isValidChar(t.charAt(i))){
        		i++;
        		continue;
        	}
        	if(!isValidChar(t.charAt(j))){
        		j--;
        		continue;
        	}
        	if(t.charAt(i) != t.charAt(j)){
        		return false;
        	}
        	i++;
        	j--;
        }
        return true;
    }
    
    boolean isValidChar(char c){
    	return (c >='a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    
    public static void main(String[] args) {
    	ValidPalindrome v = new ValidPalindrome();
    	System.out.println("Excepted true:" + v.isPalindrome(null));
    	System.out.println("Excepted true:" + v.isPalindrome(""));
    	System.out.println("Excepted true:" + v.isPalindrome("aba"));
    	System.out.println("Excepted true:" + v.isPalindrome("abcdcba"));
    	System.out.println("Excepted true:" + v.isPalindrome("A man, a plan, a canal: Panama"));
    	System.out.println("Excepted false:" + v.isPalindrome("race a car"));
    	System.out.println("Excepted false:" + v.isPalindrome("asdfsadfsadfsadfksjdfljsdkfjsakfjdsfjidsfdslkfjdskfjdskfjsdkfjsdlkfjsdkfjkdsljfdsklfjdskfjsadlkfjsadflkjdsaflksf"));
    }
}
