package third;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.
 For example:

 add(1)
 add(2)
 findMedian() -> 1.5
 add(3)
 findMedian() -> 2
 */
public class MedianFinder {
    /**
     * Use maxHeap and minQUeue to maintain two parts, and median is the peek value.
     *
     * Add Time: O(lgn),  find Time: O(1)
     *
     * Be careful:
     *   1. When find median, use peek instead of poll!!
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b-a;
        }
    });

    PriorityQueue<Integer> minHeap = new PriorityQueue(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a-b;
        }
    });

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        //Make sure left size (maxHeap) = right size (minHeap) + 0/1
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

        if(maxHeap.size() > minHeap.size()+1) {
            minHeap.add(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int n = maxHeap.size() + minHeap.size();
        if(n%2 == 1) {
            return maxHeap.peek();
        } else {
            return ((double)(maxHeap.peek() + minHeap.peek()))/2;
        }
    }

    /**
     * ---------------------------------------------
     * Another way is to quick find n/2 and n/2+1 numbers from list.
     *
     * Add Time: O(1),  Find Time: O(n)
     */
    List<Integer> l = new ArrayList();

    public void addNum_slow(int num) {
        l.add(num);
    }

    public double findMedian_slow() {
        int n = l.size();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = l.get(i);

        int x = findKth(a, 0, n-1, (n+1)/2);
        if(n%2 == 1) {
            return x;
        } else {
            int y = findKth(a, 0, n-1, n/2+1);
            return ((double)(x+y))/2;
        }
    }

    private int findKth(int[] a, int l, int r, int k) {
        int p = partition(a, l, r);
        if(p-l+1 == k) {
            return a[p];
        } else if(p-l+1 > k) {
            return findKth(a, l, p-1, k);
        } else {
            return findKth(a, p+1, r, k-(p-l+1));
        }
    }

    private int partition(int[] a, int l, int r) {
        int p = a[r];
        int firstLarge = l;
        for(int i=l;i<r;i++){
            if(a[i] <= p) {
                swap(a, i, firstLarge);
                firstLarge++;
            }
        }
        swap(a, firstLarge, r);
        return firstLarge;
    }

    private void swap(int[] a, int i, int j) {
        if(i != j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
