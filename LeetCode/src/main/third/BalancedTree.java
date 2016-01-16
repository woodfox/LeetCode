package third;

import second.TreeNode;

public class BalancedTree {
    /**
     *        1
     *       / \
     *      2   3
     *     / \
     *    4  5
     */
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) >= 0;
    }

    /**
     * Check if the tree note is balanced by comparing the left and right length.
     * If unbalanced, return -1; otherwise return max(left, right)
     */
    private int checkBalance(TreeNode root) {
        if(root == null) {
            return 0;
        }else{
           int left = checkBalance(root.left);
           int right = checkBalance(root.right);
            // if left/right are unbalanced, or their difference is more than 1 level
            if(left == -1 || right == -1 || Math.abs(left-right) > 1) {
               return -1;
           }else {
               return Math.max(left, right)+1;
           }
        }
    }
}
