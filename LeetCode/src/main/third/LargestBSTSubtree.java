package third;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of whole tree.

 Examples:

 Input:
       5
     /  \
    2    4
   / \
  1   3

 Output: 3
 */
public class LargestBSTSubtree {
    private int MIN = Integer.MIN_VALUE;
    private int MAX = Integer.MAX_VALUE;

    /**
     * Bottom-up way to get max BST subtree.
     * If node value is between [left.max, right.min] and left/right is valid BST, return new min/max;
     * otherwise any parent node can not be valid BST.
     *
     * For NULL, it returns range [MAX, MIN], so that any node value is <MAX or >MIN.
     *
     * Time: O(n)
     */
    int max = 0;
    public int largestBST(TreeNode root) {
        if(root == null) return 0;

        max = 0;
        check(root);
        return max;
    }

    private Result check(TreeNode root) {
        Result r = new Result();
        if(root == null) {
            r.isBST = true;
            return r;
        }

        Result left = check(root.left);
        Result right = check(root.right);
        if(left.isBST && right.isBST && root.val>left.max && root.val<right.min) {
            r.isBST = true;
            r.min = Math.min(root.val, left.min);
            r.max = Math.max(root.val, right.max);
            r.size = left.size + right.size + 1;

            max = Math.max(max, r.size);
        }
        return r;
    }

    private class Result {
        int min = MAX;
        int max = MIN;
        int size = 0;
        boolean isBST = false;
    }



    /**
     * --------------------------------------------------------------
     * Easy but Inefficient way
     *
     * Time: f(n) = 2f(n/2) + n = O(nlogn)
     */
    int largestBST_slow(TreeNode root) {
        if (root == null) return 0;

        if(isValidBST(root, MIN, MAX)) {
            return count(root);
        } else {
            return Math.max(largestBST_slow(root.left), largestBST_slow(root.right));
        }
    }

    private boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) return true;

        return root.val>min && root.val<max
                && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    private int count(TreeNode root) {
        if(root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }

}
