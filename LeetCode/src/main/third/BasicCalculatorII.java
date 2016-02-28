package third;

import java.util.LinkedList;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        LinkedList<Integer> nums = new LinkedList();
        LinkedList<Character> ops = new LinkedList();
        int p = 0;
        while(p < s.length()) {
            char c = s.charAt(p);
            if(c == ' ') {
                p++;
            } else if(c == '+' || c == '-' || c == '*' || c == '/') {
                ops.add(c);
                p++;
            } else {
                int r = 0;
                while(p < s.length() && s.charAt(p) >= '0' && s.charAt(p) <= '9') {
                    r = r*10 + (s.charAt(p) - '0');
                    p++;
                }

                if(!ops.isEmpty()) {
                    char op = ops.getLast();
                    if(op == '*' || op == '/') {
                        // Don't forget to remove operators
                        ops.removeLast();
                        int a = nums.removeLast();
                        if(op == '*') {
                            r = a * r;
                        } else {
                            r = a/r;
                        }
                    }
                }

                nums.add(r);
            }
        }

        while(!ops.isEmpty()) {
            char c = ops.removeFirst();
            int a = nums.removeFirst();
            int b = nums.removeFirst();
            if(c == '+') {
                nums.addFirst(a + b);
            } else {
                nums.addFirst(a-b);
            }
        }

        return nums.getFirst();
    }
}
