package third;

import java.util.*;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {
    /**
     * Sort and merge left and right side.
     * Have to merge from end of left and right so that equal numbers are separated!! Such as array [4,5,5,6]
     *
     * Time: O(nlogn)
     */
    public void wiggleSort(int[] a) {
        int n = a.length;
        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(b);

        int l = (n+1)/2;
        int p = 0;
        int i = l-1;
        int j = n-1;
        while(i>=0 && j>=l) {
            a[p++] = b[i--];
            a[p++] = b[j--];
        }

        // Add last one if left is longer than right (n is odd)
        if(i==0) a[p] = b[i];
    }

    /**
     * --------------------------------------------------
     * Use quick find to find median, and move smaller numbers to left, medians to center and larger numbers to right.
     * At last, merge left and right part from ending similar as sort version.
     *
     * Time: O(n)    Space: O(n)
     */
    public void wiggleSort_quickFind(int[] a) {
        int n = a.length;
        int[] b = Arrays.copyOf(a, n);
        int median = findKth(b, 0, n-1, (n+1)/2);

        int p = (n+1)/2;
        // Move all medians to the center
        int firstMedian = 0;
        for(int i=0;i<p;i++) {
            if(b[i] != median) {
                swap(b, firstMedian++, i);
            }
        }

        firstMedian = n-1;
        for(int i=n-1;i>=p;i--) {
            if(b[i] != median) {
                swap(b, firstMedian--, i);
            }
        }

        // At last, merge left and right part from ending
        int l = p-1;
        int r = n-1;
        for(int i=0;i<n;i++) {
            a[i] = (i%2==0)? b[l--] : b[r--];
        }
    }

    private int findKth(int[] a, int l, int r, int k) {
        int p = partition(a, l, r);
        if(p-l+1 == k) {
            return a[p];
        } else if(p-1+1 > k) {
            return findKth(a, l, p-1, k);
        } else {
            return findKth(a, p+1, r, k-(p-l+1));
        }
    }

    private int partition(int[] a, int l, int r) {
        int p = r;
        int firstLarge = l;
        for(int i=l;i<r;i++) {
            if(a[i] < a[p]) {
                swap(a, i, firstLarge++);
            }
        }
        swap(a, p, firstLarge);
        return firstLarge;
    }

    private void swap(int[] a, int i, int j) {
        if(i != j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    /**
     * Brute force to find possible solution.
     *
     * Time: O(n!)
     */
    public void wiggleSort_slow(int[] a) {
        List<Integer> l = new ArrayList();
        Set<Integer> visited = new HashSet();
        backtrack(a, l, visited);
    }

    private boolean backtrack(int[] a, List<Integer> l, Set<Integer> visited) {
        int p = l.size();
        int n = a.length;
        if(p == n) {
            for(int i=0;i<n;i++) a[i] = l.get(i);
            return true;
        } else {
            for(int i=0;i<n;i++) {
                if(visited.contains(i)) continue;

                if(p==0 || (p%2==1 && a[i]>l.get(p-1)) || (p%2==0 && a[i]<l.get(p-1))) {
                    visited.add(i);
                    l.add(a[i]);
                    if(backtrack(a, l, visited)) return true;

                    visited.remove(i);
                    l.remove(l.size()-1);
                }
            }

            return false;
        }
    }
}
