package second;

import java.util.LinkedList;

public class EvaluateNotation {
    public int evalRPN(String[] a) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        for(String s:a){
            if(isOperator(s)){
                if(l.size() < 2){
                    return 0;
                }
                int y = l.removeLast();
                int x = l.removeLast();
                l.add(operator(s, x, y));
            }else{
                l.add(Integer.parseInt(s));
            }
        }
        
        if(l.size() != 1){
            return 0;
        }else{
            return l.peekFirst();
        }
    }
    
    boolean isOperator(String s){
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }
    
    int operator(String s, int x, int y){
        if("+".equals(s)){
            return x+y;
        }else if("-".equals(s)){
            return x-y;
        }else if("*".equals(s)){
            return x*y;
        }else if("/".equals(s)){
            if(y == 0){
                return 0;
            }else{
                return x/y;
            }
        }else{
        	return 0;
        }
    }
}
