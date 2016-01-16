package second;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        s = s.toLowerCase();
        int i=0;
        int j = s.length() - 1;
        while(i< j){
            char c = s.charAt(i);
            if(!isValidChar(c)){
                i++;
                continue;
            }
            char d = s.charAt(j);
            if(!isValidChar(d)){
                j--;
                continue;
            }
            
            if(c != d){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
	
    boolean isValidChar(char c){
        if((c>='a'&& c<='z') || (c>='0'&&c<='9')){
            return true;
        }else{
            return false;
        }
    }
}
