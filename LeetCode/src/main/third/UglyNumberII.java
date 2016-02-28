package third;

import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.

 Hint:

 The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 */
public class UglyNumberII {
    /**
     * Use PriorityQueue to sort and get next ugly number.
     *
     * Time: O(nlgn)
     *
     * Be careful:
     *   1. Use long since it may overflow when multiple 5
     */
    public int nthUglyNumber(int n) {
        long p = 1;
        int i = 1;
        PriorityQueue<Long> q = new PriorityQueue();
        while(i < n) {
            q.add(p*2);
            q.add(p*3);
            q.add(p*5);

            // Avoid same number in the queue
            while(q.peek() == p) q.poll();

            p = q.poll();
            i++;
        }

        return (int)p;
    }

    /**
     * Use three pointers to record the last positions for 2,3,5
     * This doesn't require to sort the candidate numbers, so time is O(n)
     */
    public int nthUglyNumber_faster(int n) {
        int[] a = new int[n];
        a[0] = 1;

        int last2 = 0;
        int last3 = 0;
        int last5 = 0;
        for(int i=1;i<n;i++){
            int pre = a[i-1];
            if(last2*2 <= pre) last2++;
            if(last3*3 <= pre) last3++;
            if(last5*5 <= pre) last5++;

            int cad1 = a[last2] * 2;
            int cad2 = a[last3] * 3;
            int cad3 = a[last5] * 5;
            a[i] = Math.min(cad1, Math.min(cad2, cad3));
        }

        return a[n-1];
    }
}
