package third;

import scala.actors.threadpool.Arrays;

import java.util.Stack;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.

 Example 1:
 nums1 = [3, 4, 6, 5]
 nums2 = [9, 1, 2, 5, 8, 3]
 k = 5
 return [9, 8, 6, 5, 3]

 Example 2:
 nums1 = [6, 7]
 nums2 = [6, 0, 4]
 k = 5
 return [6, 7, 6, 0, 4]

 Example 3:
 nums1 = [3, 9]
 nums2 = [8, 9]
 k = 3
 return [9, 8, 9]
 */
public class CreateMatrixNumber {
    /**
     * Get max sub array from a1 for length i: from max(k-n,0) to min(m,k),
     * and max sub array from a2 for length k-i;
     * Then merge them to one array and save it if it's largest numbers.
     *
     * Time: O(k*(m+n+k)) = O((m+n)^2) in worst case when k = m+n
     *
     * Be careful:
     *   1. when merge two arrays, for same character it can not pick up any one.
     *      Have to compare whole string to get larger array.
     */
    public int[] maxNumber(int[] a1, int[] a2, int k) {
        int m = a1.length;
        int n = a2.length;
        int[] r = new int[k];
        for(int i=Math.max(k-n,0);i<=Math.min(m,k);i++){
            int[] b1 = maxSubArray(a1, i);
            int[] b2 = maxSubArray(a2, k-i);
            int[] c = merge(b1, b2);
            if(compare(r, 0, c, 0) < 0) r = c;
        }
        return r;
    }

    // O(n)
    private int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] r = new int[m+n];
        int p = 0;
        int i=0;
        int j=0;
        while(i<m || j<n) {
            // Can not use any one if the character is same.
            // So have to compare the whole array and use the larger one
            if(compare(a, i, b, j) < 0) r[p++] = b[j++];
            else r[p++] = a[i++];
        }
        return r;
    }

    // O(n)
    private int[] maxSubArray(int[] a, int k) {
        if(k == 0) return new int[0];

        int n = a.length;
        Stack<Integer> s = new Stack();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && a[i] > s.peek() && s.size()-1 + n-i>=k) {
                s.pop();
            }

            if(s.size() < k) s.push(a[i]);
        }

        int[] r = new int[k];
        for(int i=k-1;i>=0;i--) r[i] = s.pop();
        return r;
    }

    // O(n)
    private int compare(int[] a, int l1, int[] b, int l2) {
        int m = a.length;
        int n = b.length;
        while(l1<m && l2<n) {
            if(a[l1] != b[l2]) return a[l1]-b[l2];
            l1++;
            l2++;
        }
        return (m-l1) - (n-l2);
    }

    /**
     * Greedy solution: find the maximum character in the most possible
     * Time Limit Exceeded...
     *
     * Time: f(m+n) = 2*f(m+n-1) + (m+n) = O(2^n)
     */
    public int[] maxNumber_slow(int[] nums1, int[] nums2, int k) {
        return getMax(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, k);
    }
    private int[] getMax(int[] a1, int l1, int r1, int[] a2, int l2, int r2, int k) {
        if(k == 0) return new int[0];

        int m = r1-l1+1;
        int n = r2-l2+1;
        int left1 = Math.max(0, k-n-1);
        int max1 = Integer.MIN_VALUE;
        int pos1 = -1;
        for(int i=l1;i<=r1-left1;i++){
            if(a1[i]>max1) {
                max1 = a1[i];
                pos1 = i;
            }
        }

        int left2 = Math.max(0, k-m-1);
        int max2 = Integer.MIN_VALUE;
        int pos2 = -1;
        for(int i=l2;i<=r2-left2;i++){
            if(a2[i]>max2) {
                max2 = a2[i];
                pos2 = i;
            }
        }

        if(max1 < max2) {
            // Use largest number in max2
            return merge(max2, getMax(a1, l1, r1, a2, pos2+1, r2, k-1));
        } else if(max1 > max2) {
            // Use largest number in max1
            return merge(max1, getMax(a1, pos1+1, r1, a2, l2, r2, k-1));
        } else {
            int[] b1 = getMax(a1, pos1+1, r1, a2, l2, r2, k-1);
            int[] b2 = getMax(a1, l1, r1, a2, pos2+1, r2, k-1);
            if(compare(b1, b2) < 0) {
                // B2 is larger
                return merge(max2, b2);
            } else {
                // B1 is larger
                return merge(max1, b1);
            }
        }
    }

    private int[] merge(int x, int[] a) {
        int n = a.length;
        int[] b = new int[n+1];
        b[0] = x;
        for(int i=0;i<n;i++) b[i+1] = a[i];
        return b;
    }

    private int compare(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        for(int i=0;i<m;i++) {
            if(a[i] != b[i]) return a[i]-b[i];
        }
        return m-n;
    }

}
