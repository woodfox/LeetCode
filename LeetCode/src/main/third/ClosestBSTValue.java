package third;

import util.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:

 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBSTValue {
    /**
     * Time: O(n)
     *
     * Can extend to any Binary Tree if don't compare value
     */
    int closestValue(TreeNode root, double t) {
        if(root == null) return Integer.MAX_VALUE;

        int r;
        if(t == root.val) {
            return 0;
        } else if(t > root.val) {
            r = closestValue(root.right, t);
        } else {
            r = closestValue(root.left, t);
        }

        if(Math.abs(root.val - t) < Math.abs(r - t)) {
            return root.val;
        } else {
            return r;
        }
    }
}
