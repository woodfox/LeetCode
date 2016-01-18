package third;

import util.TreeLinkNode;

/**
 * Time: C(N, 2) = O(N^2)
 */
public class PopulateNextPointer {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        } else if(root.left == null || root.right == null) {
            return;
        } else {
            root.left.next = root.right;
            connect(root.left);
            connect(root.right);
            connectTwoTree(root.left, root.right);
        }
    }

    /**
     * Connect two nodes between sub-trees. It needs to apply to next level
     */
    private void connectTwoTree(TreeLinkNode leftNode, TreeLinkNode rightNode) {
        if(leftNode.right == null || rightNode.left == null) {
            return;
        } else {
            leftNode.right.next = rightNode.left;

            connectTwoTree(leftNode.right, rightNode.left);
        }
    }
}
