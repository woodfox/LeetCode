package third;

import second.TreeNode;

/**
 * It allows negative values.... So it should try to the end when left/right is not empty
 *
 * Time: O(N)
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        } else if(root.val == sum && root.left == null && root.right == null) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val)
                  || hasPathSum(root.right, sum - root.val);
        }
    }
}
