package third;

import util.TreeNode;

public class MaxTreeDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }
}
