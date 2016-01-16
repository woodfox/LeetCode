package second;

import java.util.LinkedList;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        LinkedList<Character> l = new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                l.add(c);
            }else if(l.isEmpty()){
                return false;
            }else{
                char d = l.removeLast();
                if(!compare(c, d)){
                    return false;
                }
            }
        }
        return l.isEmpty();
    }
    
    boolean compare(char c, char d){
        return (d == '(' && c == ')')
             ||(d == '{' && c == '}')
             ||(d == '[' && c == ']');
    }
}
