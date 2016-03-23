package other;

import util.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of intervals of time, find maximum number of non-overlapping intervals.

 For example:
 Given [0,2], [1,4], [3,5], the result would be 2.
 */
public class MaximumNonOverlap {
    /**
     * Brute force way: for interval i, check how many non-overlap intervals after that (time: O(n^2)
     *
     * Can use binary search to improve the performance to O(nlogn)
     *
     * Note:
     *   1. Be careful when counting non-overlapping + 1
     */
    public int maxNonOverlap(List<Interval> l) {
        int n = l.size();
        if(n==0) return 0;
        else if(n==1) return 1;

        Collections.sort(l, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        int count = 0;
        for(int i=0;i<n-1;i++){
            int p = binarySearch(l, i+1, n-1, l.get(i).end);
            // If there are non-overlapping intervals, then the total is n-p+1
            if(p<n) {
                count = Math.max(count, n-p+1);
            }
        }

        return count;
    }

    private int binarySearch(List<Interval> l, int start, int end, int t){
        while(start<=end){
            int m = start + (end-start)/2;
            Interval interval = l.get(m);
            if(interval.start > t) {
                end = m-1;
            } else {
                start = m+1;
            }
        }

        return start;
    }
}
