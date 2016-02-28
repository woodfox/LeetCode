package third;

import java.util.*;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].
 */
public class CountSmallerNumberAfter {
    /**
     * Use Binary Search Tree to maintain the count of smaller values when inserting new nodes.
     *
     * Time: O(nlogh),  h is the average height of Tree
     */
    public List<Integer> countSmaller(int[] a) {
        LinkedList<Integer> r = new LinkedList<Integer>();
        int n = a.length;
        if(n == 0) return r;

        TreeNode root = new TreeNode(a[n-1]);
        for(int i=n-1;i>=0;i--){
            r.addFirst(insert(root, a[i]));
        }
        return r;
    }

    private int insert(TreeNode root, int val) {
        if(val == root.val) {
            root.cnt++;
            return root.leftCnt;
        } else if(val < root.val) {
            root.leftCnt++;
            if(root.left == null) {
                root.left = new TreeNode(val);
            }
            return insert(root.left, val);
        } else {
            if(root.right == null) {
                root.right = new TreeNode(val);
            }
            return root.leftCnt + root.cnt + insert(root.right, val);
        }
    }

    private class TreeNode {
        int cnt=0;  // count of current value
        int leftCnt=0; // count of smaller value
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * -----------------------------------------------------
     * Check digits one by one for numbers from right to left, and separate them to higher/lower
     * according to the digit, and update the smaller count on that position.
     *
     * Time: O(32*n)
     */
    public List<Integer> countSmaller_digit(int[] a) {
        List<Integer> r = new ArrayList();
        int n = a.length;
        for(int i=0;i<n;i++) r.add(0);

        List<Integer> index = new ArrayList();
        for(int i=n-1;i>=0;i--) index.add(i);

        int mask = 1 << 31;
        checkDigits(a, mask, index, r);
        return r;
    }

    private void checkDigits(int[] a, int mask, List<Integer> index, List<Integer> r) {
        if(mask==0 || index.size() <= 1) return;

        List<Integer> higher = new ArrayList();
        List<Integer> lower = new ArrayList();

        int highDigit = (mask<0)? 0 : mask;
        for(int i=0;i<index.size();i++){
            int pos = index.get(i);
            if((a[pos]&mask) == highDigit) {
                // Bit is 1 (or positive for first digit), so it's in higher list
                higher.add(pos);
                r.set(pos, r.get(pos) + lower.size());
            } else {
                lower.add(pos);
            }
        }
        checkDigits(a, mask>>>1, lower, r);
        checkDigits(a, mask>>>1, higher, r);
    }

    /**
     * ------------------------------------------------------
     * Use TreeSet to get smaller numbers in logn time.
     * Still Time Limit Exceeded...
     *
     * Time: O(nlogn)
     */
    public List<Integer> countSmaller_slow(int[] nums) {
        LinkedList<Integer> r = new LinkedList<Integer>();
        SortedSet<Integer> set = new TreeSet<Integer>();

        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            SortedSet<Integer> sub = set.headSet(nums[i]);
            r.addFirst(sub.size());
            set.add(nums[i]);
        }

        return r;
    }
}
