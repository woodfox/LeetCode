package third;

import second.TreeNode;

/**
 * Get the min length to leaf node!!
 * If only has left or right, it should ignore the empty side!
 *
 * Time: O(N)
 */
public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }else{
            int left = getMinDepth(root.left);
            int right = getMinDepth(root.right);

            if(left == 0) {
                return right + 1;
            } else if(right == 0) {
                return left + 1;
            } else {
                return Math.min(left, right) + 1;
            }
        }
    }
}
