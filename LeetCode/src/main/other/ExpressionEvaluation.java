package other;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an expression string array, return the final result of this expression

 Example
 For the expression 2*6-(23+7)/(1+2), input is



 return 2

 Note
 The expression contains only integer, +, -, *, /, (, ).
 */
public class ExpressionEvaluation {
    public int evaluateExpression(List<String> l) {
        int n = l.size();
        LinkedList<Integer> nums = new LinkedList<Integer>();
        LinkedList<String> ops = new LinkedList<String>();
        int i = 0;
        while(i<n){
            String s = l.get(i);
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                ops.add(s);
                i++;
            } else if(s.equals("(")){
                int count =1;
                i++;
                int j = i;
                while(j<n && count>0){
                    String t = l.get(j);
                    if("(".equals(t)){
                        count++;
                    }else if(")".equals(t)){
                        count--;
                    }
                    j++;
                }
                int x = evaluateExpression(l.subList(i, j-1));
                addAndEvaluate(nums, ops, x);
                i=j;
            } else {
                int x = Integer.parseInt(s);
                addAndEvaluate(nums, ops, x);
                i++;
            }
        }

        while(!ops.isEmpty()){
            String op = ops.removeFirst();
            int a = nums.removeFirst();
            int b = nums.removeFirst();
            nums.addFirst(calc(a, b, op));
        }
        return nums.getFirst();
    }

    private void addAndEvaluate(LinkedList<Integer> nums, LinkedList<String> ops, int x) {
        if(!ops.isEmpty() && (ops.getLast().equals("*")||ops.getLast().equals("/"))){
            String op = ops.removeLast();
            int a = nums.removeLast();
            nums.add(calc(a, x, op));
        } else {
            nums.add(x);
        }
    }

    private int calc(int a, int b, String op){
        if(op.equals("+")) return a+b;
        else if(op.equals("-")) return a-b;
        else if(op.equals("*")) return a*b;
        else return a/b;
    }
}
