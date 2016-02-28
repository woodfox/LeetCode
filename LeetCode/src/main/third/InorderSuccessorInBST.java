package third;

import util.TreeNode;

import java.util.Stack;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

 Note: If the given node has no in-order successor in the tree, return null.
 */
public class InorderSuccessorInBST {
    /**
     * For BST, we can check the node value and find the next larger node from stack.
     * It's easier than Binary Tree.
     *
     * Time: O(h)
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
        if (node.right != null) {
            TreeNode next = node.right;
            while (next.left != null) {
                next = next.left;
            }
            return next;
        } else {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode curr = root;
            while(curr != node) {
                stack.push(curr);
                if(curr.val > node.val) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            while(!stack.isEmpty() && stack.peek().val < node.val) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                return null;
            } else {
                return stack.pop();
            }
        }
    }

    /**
     * For any binary tree.
     * If node has right child, the next successor is the most-left node of his right child;
     * otherwise find the nearest parent node that node is left child of parent node.
     *
     * Time: O(n)
     */
    public TreeNode inorderSuccessor_anyBinaryTree(TreeNode root, TreeNode node) {
        if(node.right != null) {
            TreeNode next = node.right;
            while(next.left != null) {
                next = next.left;
            }
            return next;
        } else {
            Stack<TreeNode> stack = new Stack();
            dfs(root, node, stack);
            while(!stack.isEmpty()) {
                TreeNode p = stack.pop();
                if(node == p.left) {
                    return p;
                } else {
                    node = p;
                }
            }
            return null;
        }
    }

    private boolean dfs(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if(root == null) return false;
        else if(root == node) return true;

        stack.push(root);
        if(dfs(root.left, node, stack)) return true;
        if(dfs(root.right, node, stack)) return true;

        // At last, remove root from stack if node is not found
        stack.pop();
        return false;
    }
}
