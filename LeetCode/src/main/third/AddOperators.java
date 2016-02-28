package third;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Examples:
 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []
 */
public class AddOperators {
    /**
     * Save prevNum, currNum and string in backtrack, and handle +,- and * differently.
     *
     * Time: f(n)=f(n-1)+f(n-2)+... = O(n!)
     */
    public List<String> addOperators(String s, int t) {
        List<String> r = new ArrayList();
        if(s.length() == 0) return r;

        backtrack(s, 0, 0, 0, "", t, r);
        return r;
    }

    private void backtrack(String s, int p, long prevNum, long currNum, String tmp, int t, List<String> r) {
        if(p >= s.length() && currNum == t) {
            r.add(tmp);
        } else {
            for(int i=p+1;i<=s.length();i++) {
                if(s.charAt(p) == '0' && i>p+1) break;

                long x = Long.parseLong(s.substring(p, i));

                if(tmp.length() > 0) {
                    // For +, currNum=currNum+x, prevNum=x
                    backtrack(s, i, x, currNum + x, tmp + "+" + x, t, r);
                    // For -, currNum=currNum-x, prevNum=-1*x
                    backtrack(s, i, -x, currNum - x, tmp + "-" + x, t, r);
                    // For *, currNum=(currNum-prevNum)+prevNum*x, prevNum=prevNum*x
                    backtrack(s, i, prevNum * x, (currNum - prevNum) + prevNum * x, tmp + "*" + x, t, r);
                }else {
                    backtrack(s, i, x, x, x+"", t, r);
                }
            }
        }
    }

    /**
     * Try all combination of spliting strings, and combine with +,-,*
     * Evalute the combination and add into result if it's equals to target.
     *
     * Be careful:
     *  1. Evaluate * first. Do not use for(int i=0;i<n;i++) since i should not change if current position is * and removed
     */
    public List<String> addOperators_complex(String s, int t) {
        List<Long> sub = new ArrayList();
        List<String> r = new ArrayList();
        if(s.length() == 0) return r;

        backtrack_complex(s, 0, t, sub, r);
        return r;
    }

    private void backtrack_complex(String s, int p, int t, List<Long> sub, List<String> r) {
        if(p >= s.length()) {
            find(sub, t, r);
        } else {
            // Max length of Long number is 19
            for(int i=p+1;i<=s.length()&&i-p<20;i++){
                // If first digit is 0, can not include following digits
                if(s.charAt(p) == '0' && i>p+1) break;

                long x = Long.parseLong(s.substring(p, i));
                sub.add(x);
                backtrack_complex(s, i, t, sub, r);
                sub.remove(sub.size()-1);
            }
        }
    }

    private void find(List<Long> sub, int t, List<String> r) {
        List<Character> ops = new ArrayList();
        tryOps(sub, ops, t, r);
    }

    private void tryOps(List<Long> sub, List<Character> ops, int t, List<String> r) {
        int n = sub.size();
        if(ops.size() == n-1) {
            if(eval(sub, ops) == t) {
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<ops.size();i++){
                    sb.append(sub.get(i));
                    sb.append(ops.get(i));
                }
                sb.append(sub.get(n-1));
                r.add(sb.toString());
            }
        } else {
            char[] a = "+-*".toCharArray();
            for(char c : a) {
                ops.add(c);
                tryOps(sub, ops, t, r);
                ops.remove(ops.size()-1);
            }
        }
    }

    private long eval(List<Long> sub, List<Character> ops) {
        List<Long> nums = new ArrayList(sub);
        List<Character> od = new ArrayList(ops);
        int p = 0;
        while(p < od.size()) {
            if (od.get(p) == '*') {
                od.remove(p);
                long x = nums.remove(p);
                long y = nums.remove(p);
                nums.add(p, x * y);
            } else {
                p++;
            }
        }

        while(!od.isEmpty()) {
            char c = od.remove(0);
            long x = nums.remove(0);
            long y = nums.remove(0);
            if (c == '+') {
                nums.add(0, x+y);
            } else {
                nums.add(0, x-y);
            }
        }

        return nums.get(0);
    }
}
