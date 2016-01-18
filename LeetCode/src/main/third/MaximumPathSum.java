package third;

import util.TreeNode;

/**
 * Find max sum with one node by checking both of left & right side:
 *   Max(left, 0) + Max(right, 0) + node.value
 *
 *   And return the max path sum with this node and ONLY one side!!
 *
 * And compare and get the max path sum in all nodes!!
 */
public class MaximumPathSum {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        maxPathSumWithNode(root);
        return result;
    }

    private int maxPathSumWithNode(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftSum = Math.max(maxPathSumWithNode(root.left), 0);
            int rightSum = Math.max(maxPathSumWithNode(root.right), 0);
            int maxForNode = leftSum + rightSum + root.val;
            result = Math.max(result, maxForNode);

            int maxWithOneSide = Math.max(leftSum, rightSum) + root.val;
            return maxWithOneSide;
        }
    }
}
