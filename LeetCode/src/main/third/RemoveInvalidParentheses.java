package third;

import java.util.*;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Examples:
 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]
 */
public class RemoveInvalidParentheses {
    /**
     * BFS: try to delete ( or ), and continue if the rating is better.
     *
     * Use rating fucntion to check if new string has fewer difference between left and right parentheses!
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> r = new ArrayList();
        if (s == null) return r;

        Set<String> visited = new HashSet<String>();
        LinkedList<String> q = new LinkedList();
        q.add(s);

        while(!q.isEmpty()) {
            String t = q.poll();
            if(visited.contains(t)) continue;
            visited.add(t);

            int rating = calc(t);
            if(rating == 0) {
                r.add(t);
            } else {
                for(int i=0;i<t.length();i++) {
                    char c = t.charAt(i);
                    if(c == '(' || c == ')') {
                        String a = t.substring(0, i) + t.substring(i+1);
                        if(calc(a) < rating) {
                            q.add(a);
                        }
                    }
                }
            }
        }

        return r;
    }

    /**
     * DFS: delete ( or ), and contineu if its rating is better than before.
     */
    public List<String> removeInvalidParentheses_dfs(String s) {
        List<String> r = new ArrayList();
        if (s == null) return r;

        Set<String> visited = new HashSet<String>();
        dfs(s, visited, r);
        return r;
    }

    private void dfs(String s, Set<String> visited, List<String> r) {
        if(visited.contains(s)) return;
        visited.add(s);
        int diff = calc(s);

        if(calc(s) == 0) {
            r.add(s);
        } else {
            for(int i=0;i<s.length();i++){
                String t = s.substring(0, i) + s.substring(i+1);
                // Only consider better solutions
                if(calc(t) < diff) {
                    dfs(t, visited, r);
                }
            }
        }
    }

    /**
     * Evaluate the difference between left and right parentheses.
     */
    private int calc(String s) {
        int l = 0;
        int r = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') l++;
            else if(c == ')') l--;

            if(l < 0) {
                r++;
                l = 0;
            }
        }

        return l+r;
    }

    /**
     * First get the total characters to delete by comparing left and right parentheses.
     * Then backtrack to try all combinations.
     *
     * Use visited set to improve performance and avoid Time Limit Exceeded!
     *
     * Time: f(n) = C(k, n) = n!/((n-k)!*k!)
     */
    public List<String> removeInvalidParentheses_complicated(String s) {
        List<String> r = new ArrayList();
        if(s == null) return r;

        int l = 0;
        int diff = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') l++;
            else if(c == ')') l--;

            if(l<0) {
                diff++;
                l = 0;
            }
        }
        diff += l;

        StringBuffer sb = new StringBuffer(s);
        Set<String> visited = new HashSet();
        backtrack(sb, 0, 0, diff, visited, r);

        return r;
    }

    private void backtrack(StringBuffer sb, int p, int l, int count, Set<String> visited, List<String> r) {
        // Cut edges to avoid doing duplicated work
        if(visited.contains(sb.toString())) return;
        visited.add(sb.toString());

        if(count == 0) {
            if(isValid(sb)) {
                r.add(sb.toString());
            }
        } else {
            for(int i=p;i<sb.length();i++){
                char c = sb.charAt(i);
                if(c == '(') {
                    // Keep it
                    backtrack(sb, i+1, l+1, count, visited, r);

                    // Remove it
                    sb.deleteCharAt(i);
                    backtrack(sb, i, l, count-1, visited, r);
                    sb.insert(i, c);
                } else if(c == ')') {
                    // Remove it
                    sb.deleteCharAt(i);
                    backtrack(sb, i, l, count-1, visited, r);
                    sb.insert(i, c);

                    // keep it if left total > 0
                    if(l > 0) {
                        backtrack(sb, i+1, l-1, count, visited, r);
                    }
                } else {
                    // Keep other characters
                    backtrack(sb, i+1, l, count, visited, r);
                }
            }
        }
    }

    private boolean isValid(StringBuffer sb) {
        int l = 0;
        for(char c : sb.toString().toCharArray()) {
            if(c == '(') {
                l++;
            } else if(c == ')') {
                l--;
            }
            if(l < 0) return false;
        }

        return l == 0;
    }

}
