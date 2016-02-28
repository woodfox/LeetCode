package third;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }

        Set<String> operators = new HashSet<String>(Arrays.asList("+","-","*","/"));
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(String s : tokens) {
            if(operators.contains(s)) {
                calculate(queue, s);
            } else {
                int value = Integer.parseInt(s);
                queue.add(value);
            }
        }

        return queue.removeFirst();
    }

    private void calculate(LinkedList<Integer> queue, String operator) {
        if(queue.size() < 2) {
            throw new RuntimeException("Less than 2 elements left before calculation");
        }

        int b = queue.removeLast();
        int a = queue.removeLast();
        int c = 0;
        if("+".equals(operator)){
            c = a + b;
        } else if("-".equals(operator)){
            c = a - b;
        } else if("*".equals(operator)) {
            c = a * b;
        } else {
            c = a / b;
        }

        queue.addLast(c);
    }
}
