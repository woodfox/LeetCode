package third;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array
 */
public class SlidingWindowMaximum {
    /**
     * Use double-end queue to maintain max element in a queue.
     * 1. when push x, delete all elements from end that is less than x, then add x into the end;
     * 2. when pop x, remove it from start if it's first one(largest one)
     *
     * Time: O(n)
     */
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        if (n == 0) {
            return new int[0];
        }

        int[] r = new int[n-k+1];
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<k;i++) {
            push(q, a[i]);
        }

        for(int i=0;i<n-k+1;i++) {
            r[i] = max(q);
            pop(q, a[i]);
            if(i+k < n) {
                push(q, a[i+k]);
            }
        }
        return r;
    }

    private void push(LinkedList<Integer> q, int x) {
        while(!q.isEmpty() && q.getLast() < x) {
            q.removeLast();
        }
        q.add(x);
    }

    private void pop(LinkedList<Integer> q, int x) {
        if(!q.isEmpty() && x == q.getFirst()) {
            q.removeFirst();
        }
    }

    private int max(LinkedList<Integer> q) {
        return q.getFirst();
    }

    /**
     * 1. Brute Force
     *    Time: O(nk)
     *
     * 2. Use Max Stack to maintain the maximum value
     *    Time: O(nlgk)
     */
    public int[] maxSlidingWindow_slow(int[] a, int k) {
        int n = a.length;
        if(n == 0) {
            return new int[0];
        }

        int[] r = new int[n-k+1];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 >= o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(int i=0;i<k;i++) {
            q.add(a[i]);
        }
        int i = 0;
        while(i < n-k+1) {
            r[i] = q.peek();
            q.remove(a[i]);

            if(i+k < n) {
                q.add(a[i+k]);
            }


            i++;
        }

        return r;
    }
}
