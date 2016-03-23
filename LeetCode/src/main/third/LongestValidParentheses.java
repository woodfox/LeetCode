package third;

import java.util.LinkedList;

public class LongestValidParentheses {
    // Merge valid parentheses when adding new character by recursive call to make the logic simpler
    // Time: O(n)
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n==0) return 0;

        LinkedList<Integer> q = new LinkedList();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='('){
                q.add(-1);
            } else {
                insert(q, -2);
            }
        }

        int max = 0;
        for(int x: q){
            max = Math.max(max, x);
        }
        return max;
    }

    private void insert(LinkedList<Integer> q, int x){
        if(q.isEmpty()) q.add(x);
        else if(x==-2){
            int prev = q.getLast();
            if(prev == -1){
                // Merge ()
                q.removeLast();
                insert(q, 2);
            }else if(prev > 0){
                int a = q.removeLast();
                if(!q.isEmpty() && q.getLast() == -1){
                    // Merge (a) to a+1
                    q.removeLast();
                    insert(q, a+2);
                } else {
                    // Restore a
                    q.add(a);
                    q.add(x);
                }
            }
        } else {
            int prev = q.getLast();
            if(prev > 0){
                // Merge valid numbers
                q.removeLast();
                insert(q, prev+x);
            } else {
                q.add(x);
            }
        }
    }

    public int longestValidParentheses_complex(String s) {
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
