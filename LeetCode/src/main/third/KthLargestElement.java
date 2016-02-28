package third;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElement {
    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        return find(a, 0, n-1, k);
    }

    private int find(int[] a, int start, int end, int k) {
        int p = partition(a, start, end);
        if(end-p == k-1) {
            return a[p];
        } else if(end-p < k-1) {
            // use p-1 as end to avoid deadloop when p is the largest one (end)
            return find(a, start, p-1, k-(end-p)-1);
        } else {
            return find(a, p+1, end, k);
        }
    }

    private int partition(int[] a, int start, int end) {
        int p = end;
        int firstLarge = start;
        for(int i= start;i<p;i++) {
            if(a[i] <= a[p]) {
                swap(a, firstLarge, i);
                firstLarge++;
            }
        }
        swap(a, firstLarge, p);
        return firstLarge;
    }

    private void swap(int[] a, int p, int q) {
        if(p != q) {
            int tmp = a[p];
            a[p] = a[q];
            a[q] = tmp;
        }
    }

    //---------------------------------
    // Another version: move larger elements to left
    private int findLargerVersion(int[] a, int start, int end, int k) {
        int p = partitionLargerVersion(a, start, end);
        if(p-start+1 == k) {
            return a[p];
        } else if(p-start+1 > k) {
            return find(a, start, p-1, k);
        } else {
            return find(a, p+1, end, k-(p-start+1));
        }
    }

    private int partitionLargerVersion(int[] a, int start, int end) {
        int p = end;
        int firstSmaller = start;
        for(int i= start;i<p;i++) {
            if(a[i] >= a[p]) {
                swap(a, firstSmaller, i);
                firstSmaller++;
            }
        }
        swap(a, firstSmaller, p);
        return firstSmaller;
    }
}
