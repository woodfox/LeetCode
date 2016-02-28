package third;

import java.util.LinkedList;

/**
 * Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 1 + 99 = 100, 99 + 100 = 199
 Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

 Follow up:
 How would you handle overflow for very large input integers?
 */
public class AdditiveNumber {
    /**
     * Backtrack
     *
     * Be careful:
     *   1. Can not reach the end when there are only two numbers.
     *   2. Add numbers back into queue after try
     */
    public boolean isAdditiveNumber(String s) {
        if(s.length() < 3) return false;

        LinkedList<Long> q = new LinkedList();
        return backtrack(s, 0, q);
    }

    private boolean backtrack(String s, int p, LinkedList<Long> q) {
        int n = s.length();
        System.out.println("p:" + p + ",queue:" + q);
        if(p == n) {
            return true;
        } else {
            boolean flag = (q.size() == 2);
            long a = 0;
            long b = 0;
            if(flag){
                a = q.removeFirst();
                b = q.removeFirst();
            }

            char c = s.charAt(p);
            for(int i=p;i<n;i++){
                // If starting with 0, it should not continue
                if(c=='0' && i>p) break;

                // Should not reach the end of string if total numbers < 2
                if(!flag && i == n-1) break;

                long x = Long.parseLong(s.substring(p, i+1));
                if(!flag) {
                    q.add(x);
                    if(backtrack(s, i+1, q)) return true;
                    q.removeLast();
                } else if(a+b == x) {
                    q.add(b);
                    q.add(x);
                    if(backtrack(s, i+1, q)) return true;

                    // Remove the queue values
                    q.removeLast();
                    q.removeLast();

                    break;
                } else if(a+b < x) {
                    // Don't need to try if x is too large
                    break;
                }
            }

            // Add the values back
            if(flag) {
                q.add(a);
                q.add(b);
            }
            return false;
        }
    }
}
