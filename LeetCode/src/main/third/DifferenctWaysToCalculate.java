package third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]


 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]
 */
public class DifferenctWaysToCalculate {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> q = new ArrayList();
        List<Character> ops = new ArrayList();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                ops.add(c);
                i++;
            } else {
                int r = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    r = r*10 + (s.charAt(i) - '0');
                    i++;
                }
                q.add(r);
            }
        }

        List<Integer> r = backtrack(q, ops);
        Collections.sort(r);

        return r;
    }

    private List<Integer> backtrack(List<Integer> q, List<Character> ops) {
        List<Integer> r = new ArrayList<Integer>();
        if(ops.isEmpty()) {
            r.add(q.get(0));
        } else {
            int m = q.size();
            int n = ops.size();
            for(int i=0;i<ops.size();i++) {
                // Evaluate operator i as the first level
                char c = ops.get(i);
                List<Integer> left = backtrack(q.subList(0, i+1), ops.subList(0,i));
                List<Integer> right = backtrack(q.subList(i+1, m), ops.subList(i+1, n));
                for(int x: left) {
                    for(int y: right) {
                        r.add(calc(c, x, y));
                    }
                }
            }
        }
        return r;
    }

    private int calc(char c, int a, int b) {
        if (c == '+') {
            return a+b;
        } else if(c == '-') {
            return a-b;
        } else {
            return a*b;
        }
    }
}
