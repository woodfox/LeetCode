package third;

import java.util.Stack;

public class ValidateParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                char left = 'X';
                if(!stack.isEmpty()){
                    left = stack.pop();
                }
                // Danger: be careful of order! Define a better name
                if(!isEqual(left, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isEqual(char left, char right) {
        return (left == '(' && right == ')')
                || (left == '{' && right == '}')
                || (left == '[' && right == ']');
    }
}
