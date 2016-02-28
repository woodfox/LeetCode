package third;

import util.TreeNode;

import java.util.LinkedList;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    public BSTIterator(TreeNode root) {
        addToStack(root);
    }

    private void addToStack(TreeNode root) {
        TreeNode node = root;
        while(node != null) {
            stack.addFirst(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.removeFirst();
        addToStack(node.right);

        return node.val;
    }
}