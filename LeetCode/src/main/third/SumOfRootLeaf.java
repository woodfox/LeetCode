package third;

import util.TreeNode;

public class SumOfRootLeaf {
    /**
     * f(node, parentValue) = | f(node.left, newParentValue) + f(node.right, newParentValue), newParentValue = (parentValue*10 + nodeValue)
     *                        | parentValue   if node == null
     *                        | parentValue*10 + nodeValue if node.left == null && node.right == null
     */
    public int sumNumbers(TreeNode root) {
        return sumNode(root, 0);
    }

    private int sumNode(TreeNode root, int parentValue) {
        if(root == null) {
            return 0;
        } else {
            int updatedParentValue = parentValue * 10 + root.val;
            if(root.left == null && root.right == null) {
                return updatedParentValue;
            } else {
                int left = sumNode(root.left, updatedParentValue);
                int right = sumNode(root.right, updatedParentValue);

                return left + right;
            }
        }
    }
}
