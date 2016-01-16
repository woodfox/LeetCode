package second;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int p =s.length()-1;
        while(p >= 0 && s.charAt(p) == ' '){
            p--;
        }
        int count = 0;
        while(p >= 0 && s.charAt(p) != ' '){
            count++;
            p--;
        }
        return count;
    }
}
