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
        if(k<=0 || t<0) return false;

        k++;
        TreeSet<Long> set = new TreeSet();
        for(int i=0;i<a.length;i++){
            SortedSet<Long> sub = set.subSet((long)a[i]-t, true, (long)a[i]+t, true);
            if(!sub.isEmpty()){
                return true;
            }
            set.add((long)a[i]);
            if(set.size()>=k) {
                set.remove((long)a[i-k+1]);
            }
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
