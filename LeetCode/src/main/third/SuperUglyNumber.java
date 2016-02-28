package third;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Write a program to find the nth super ugly number.

 Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */
public class SuperUglyNumber {
    /**
     * Use pointer for primes to generate candidates, and use Heap to get min value.
     *
     * Time: O(n*logk), k is size of primes.
     * Space: O(n+k)
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] a = new long[n];
        a[0] = 1;

        int m = primes.length;
        int[] p = new int[m];

        int i=1;
        while(i<n) {
            for(int j=0;j<m;j++){
                int k = p[j];
                if(a[k]*primes[j] <= a[i-1]) p[j]++;
            }

            // Get next minimal value
            PriorityQueue<Long> q = new PriorityQueue<Long>();
            for(int j=0;j<m;j++){
                int k = p[j];
                q.add(a[k]*primes[j]);
            }
            a[i++] = q.poll();
        }

        return (int)a[n-1];
    }

    // ------------------------------------------------------
    // Maintain the queue actively when removing one node.
    public int nthSuperUglyNumber_lessSpace(int n, int[] primes) {
        long[] a = new long[n];
        a[0] = 1;

        PriorityQueue<Prime> q = new PriorityQueue<Prime>(primes.length, new Comparator<Prime>() {
            @Override
            public int compare(Prime o1, Prime o2) {
                return (int)(o1.val - o2.val);
            }
        });
        for(int prime: primes) {
            q.add(new Prime(prime*1, prime));
        }

        for(int i=1;i<n;i++){
            // Remove any duplicate numbers
            while(q.peek().val <= a[i-1]) {
                Prime candidate = q.poll();

                // Add next candidate with increased index
                candidate.idx++;
                candidate.val = a[candidate.idx] * candidate.p;
                q.add(candidate);
            }

            a[i] = q.peek().val;
        }

        return (int)a[n-1];
    }

    private class Prime {
        int idx = 0;
        int p;
        long val;

        public Prime(int p, int v) {
            this.p = p;
            this.val = v;
        }
    }
    /**
     * ------------------------------------------------------------
     * Time Limit Exceeded!
     *
     * Time: O(nlog(k*n))
     */
    public int nthSuperUglyNumber_slow(int n, int[] primes) {
        long r = 1;
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(r);

        int pos = 1;
        while(pos < n) {
            for(int prime: primes) q.add(r*prime);

            while(q.peek() <= r) q.poll();

            r = q.poll();
            pos++;
        }
        return (int)r;
    }
}
