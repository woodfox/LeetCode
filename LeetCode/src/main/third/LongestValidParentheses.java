package third;

import java.util.LinkedList;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;

        LinkedList<Integer> list = new LinkedList<Integer>();
        for(char c : s.toCharArray()){
            list.addLast(c - ')');
        }
        LinkedList<Integer> result = merge(list);

        int max = 0;
        for(int t : result) {
            max = Math.max(max, t);
        }
        return max;
    }

    private LinkedList<Integer> merge(LinkedList<Integer> list){
        LinkedList<Integer> result = new LinkedList<Integer>();

        for(int t : list){
            if(isLeftParentheses(t)){
                push(result, t);
            }else if(isRightParentheses(t)) {
                int prev = pop(result);
                if(isLeftParentheses(prev)){
                    // case ()
                    push(result, 2);
                }else if(prev > 0) {
                    int left = pop(result);
                    if(isLeftParentheses(left)){
                        // case (6)
                        push(result, prev + 2);
                    }else{
                        // others such as )6)
                        push(result, left);
                        push(result, prev);
                        push(result, t);
                    }
                }else{
                    // other cass such as ))
                    push(result, prev);
                    push(result, t);
                }
            }else{
                int prev = pop(result);
                if(prev > 0){
                    // Merge two numbers
                    int count = prev + t;
                    push(result, count);
                }else{
                    push(result, prev);
                    push(result, t);
                }
            }
        }

        if(result.size() == list.size()){
            return result;
        }else{
            return merge(result);
        }
    }

    private boolean isLeftParentheses(int t){
        return t == '(' - ')';
    }

    private boolean isRightParentheses(int t){
        return t == ')' - ')';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private void push(LinkedList<Integer> list, int t) {
        if(t != Integer.MIN_VALUE){
            list.addLast(t);
        }
    }

    private int pop(LinkedList<Integer> list){
        if(list.isEmpty()){
            return Integer.MIN_VALUE;
        }else{
            return list.removeLast();
        }
    }
}
