package third;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
    /**
     * Use a TreeSet to find if there are numbers within range [a[i]-t, a[i]+t].
     *
     * Time: O(nlgk)
     *
     * Be careful:
     * 1. Use long to avoid overflow
     * 2. return false if t is negative!
     */
    public boolean containsNearbyAlmostDuplicate(int[] a, int k, int t) {
        // return false if t < 0
        if (k < 1 || t < 0) return false;

        int n = a.length;
        k++;

        TreeSet<Long> set = new TreeSet();
        for(int i=0;i<a.length;i++) {
            if(set.size() >= k) {
                set.remove((long)a[i-k]);
            }

            long low = (long)a[i] - t;
            long high = (long)a[i] + t + 1;
            SortedSet<Long> sub = set.subSet(low, high);
            if(!sub.isEmpty()) {
                return true;
            }

            set.add((long)a[i]);
        }

        return false;
    }

    /**
     * Brute force to search.  Time Limit Exceeded!
     *
     * Time: O(n^2)
     */
    public boolean containsNearbyAlmostDuplicate_slow(int[] a, int k, int t) {
        int n = a.length;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=i+k&&j<n;j++){
                if(Math.abs(a[j] - a[i]) <= t) {
                    return true;
                }
            }
        }

        return false;
    }
}
