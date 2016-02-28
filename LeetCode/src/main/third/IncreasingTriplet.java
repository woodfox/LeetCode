package third;

import java.util.LinkedList;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:

 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Examples:
 Given [1, 2, 3, 4, 5],
 return true.

 Given [5, 4, 3, 2, 1],
 return false.
 */
public class IncreasingTriplet {
    /**
     * Maintain x1 and x2 and updat them if a[i] < x1 or x1 < a[i] < x2
     */
    public boolean increasingTriplet(int[] a) {
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MAX_VALUE;
        for(int v : a) {
            if(v < x1) x1 = v;
            else if(v>x1 && v<x2) x2 = v;
            else if(v>x2) return true;
        }
        return false;
    }

    /**
     * Use stack to get increasing triplets.
     * The difficulty is that we don't know what we should do if a[i] is less than stack elements.
     * So we need to check one more digit at i+1 to see if it's increasing and it's larger than stack elements.
     *
     * Time: O(n)
     */
    public boolean increasingTriplet_comlex(int[] a) {
        int n = a.length;
        LinkedList<Integer> q = new LinkedList();
        for(int i=0;i<n;i++){
            if(q.isEmpty()) {
                q.add(a[i]);
            } else if(a[i] > q.getLast()) {
                q.add(a[i]);
            } else if(a[i] < q.getLast()) {
                if(q.size() == 1) {
                    q.removeLast();
                    q.add(a[i]);
                } else if(a[i] > q.getFirst()) {
                    q.removeLast();
                    q.add(a[i]);
                } else if(i<n-1 && a[i]<a[i+1] && a[i+1]<q.getLast()){
                    q.clear();
                    q.add(a[i]);
                }
            }

            if(q.size() == 3) return true;
        }
        return false;
    }
}
