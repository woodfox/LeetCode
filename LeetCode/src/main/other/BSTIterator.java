package other;

import util.TreeNode;

import java.util.LinkedList;

public class BSTIterator {
    LinkedList<TreeNode> q = new LinkedList();

    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        while(root != null) {
            q.addFirst(root);
            root = root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !q.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        TreeNode node = q.removeFirst();

        TreeNode next = node.right;
        while(next != null) {
            q.addFirst(next);
            next = next.left;
        }
        return node;
    }
}