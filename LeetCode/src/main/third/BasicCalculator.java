package third;

import java.util.LinkedList;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:
 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 Note: Do not use the eval built-in library function.
 */
public class BasicCalculator {
    /**
     * Use two LinkedList to store numbers and operators (for substring (xxxx), call it iteratively to get the value)
     *
     * Be Careful:
     *  1. Number may have multiple digits!
     *  2. Substring may be like (xxx (xxx) (xxx) )
     */
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        LinkedList<Integer> queue = new LinkedList();
        LinkedList<Character> op = new LinkedList();
        int p = 0;
        while(p < s.length()) {
            char c = s.charAt(p);
            if(c == ' ') {
                p++;
            } else if(c == '(') {
                int k = p+1;
                int left = 1;
                while(k < s.length() && left > 0) {
                    if(s.charAt(k) == ')') {
                        left--;
                    } else if(s.charAt(k) == '(') {
                        left++;
                    }
                    k++;
                }

                // At last k is rightParanthese+1
                queue.add(calculate(s.substring(p+1, k-1)));
                p = k;
            } else if(c == '+' || c == '-'){
                op.add(c);
                p++;
            } else {
                int r = 0;
                while(p < s.length() && s.charAt(p) >= '0' && s.charAt(p) <= '9') {
                    r = r*10 + (s.charAt(p) - '0');
                    p++;
                }
                queue.add(r);
            }
        }

        while(!op.isEmpty()) {
            char o = op.removeFirst();
            int a = queue.removeFirst();
            int b = queue.removeFirst();
            int r = 0;
            if(o == '+') {
                r = a+b;
            } else {
                r= a-b;
            }
            queue.addFirst(r);
        }

        return queue.getFirst();
    }
}
