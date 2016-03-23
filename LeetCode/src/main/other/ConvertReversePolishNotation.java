package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given an expression string array, return the Reverse Polish notation of this expression.
   (It may have parentheses, need to remove the parentheses)

 For the expression [3 - 4 + 5] (which denote by ["3", "-", "4", "+", "5"]),
 return [3 4 - 5 +] (which denote by ["3", "4", "-", "5", "+"])
 */
public class ConvertReversePolishNotation {
    /**
     * Use LinkedList to cache the operator (it will save at most two operators with +- and /*)
     *   1. If number is found, if last operator is * or /, save into result
     *   2. If + or / is found, if there are cached operator, save cached operator into result
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        ArrayList<String> r = new ArrayList();

        int n = expression.length;
        if(n==0) return r;

        LinkedList<String> ops = new LinkedList();
        int i = 0;
        while(i<n) {
            String s = expression[i];
            if(s.equals("+") || s.equals("-")){
                // Previous + or - should be handled first before later + or -
                if(!ops.isEmpty()) {
                    r.add(ops.removeFirst());
                }
                ops.add(s);
                i++;
            } else if(s.equals("*") || s.equals("/")) {
                ops.add(s);
                i++;
            } else {
                if(s.equals("(")) {
                    int j = i+1;
                    int count = 1;
                    while(j<n) {
                        String t = expression[j];
                        if(t.equals("(")) count++;
                        else if(t.equals(")")) count--;

                        if(count==0) break;
                        j++;
                    }

                    r.addAll(convertToRPN(Arrays.copyOfRange(expression, i + 1, j)));
                    i = j+1;
                } else {
                    r.add(s);
                    i++;
                }
                if(!ops.isEmpty()) {
                    String t = ops.getLast();
                    // * / is handled as high priority
                    if(t.equals("*") || t.equals("/")) {
                        r.add(ops.removeLast());
                    }
                }
            }
        }

        // At last it may have cached operator - or +
        if(!ops.isEmpty()) r.add(ops.removeFirst());

        return r;
    }
}
