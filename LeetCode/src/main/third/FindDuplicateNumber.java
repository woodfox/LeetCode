package third;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDuplicateNumber {
    /**
     * Binary search:
     *   1. if total numbers (<= m) is larger than m, then duplicate exists between (l, m)
     *   2. otherwise there are n+1-total numbers for range [m+1,n] (length is n-m if no duplicate), must exist a duplicate
     *
     * Time: O(nlgn)
     */
    public int findDuplicate(int[] a) {
        int l = 1;
        int r = a.length;
        while(l < r) {
            int m = (l+r)/2;
            int total = 0;
            for(int x : a) {
                if(x <= m) total++;
            }
            if(total > m) r = m;
            else l = m+1;
        }
        return l;
    }

    /**
     * Use two pointer (fast and slow) to find where the looping start is.
     * Define f(i) = a[i], then there must be (i, j) => same value K, which will be the merging position of two pointers.
     *
     * For example, array [3,5,2,7,4,6,1,5] would be equal as link below:
     *    0 -> 3 -> 7 -> 5 -> 6
     *                   \   /
     *                     1
     *
     * Time: O(n)
     *
     */
    public int findDuplicate_fastSlow(int[] a) {
        int slow = 0;
        int fast = 0;

        slow = a[slow];
        fast = a[a[fast]];
        while(slow != fast) {
            slow = a[slow];
            fast = a[a[fast]];
        }

        slow = 0;
        while(slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }
}
