package third;

import util.TreeNode;

public class SymmetricTree {
    /**
     *         1
     *      /    \
     *    2       3
     *   4 5     5 4
     *  6 7 8 9 9 8 7 6
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            return compare(root.left, root.right);
        }
    }

    private boolean compare(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null) {
            return true;
        }else if(leftNode == null || rightNode == null){
            return false;
        }else {
            return (leftNode.val == rightNode.val)
                    && compare(leftNode.left, rightNode.right)
                    && compare(leftNode.right, rightNode.left);
        }
    }
}
