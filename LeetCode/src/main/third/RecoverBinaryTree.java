package third;

import second.TreeNode;

import java.util.ArrayList;

public class RecoverBinaryTree {
    public void recoverTree(TreeNode root) {
        recoverTreeFast(root);
    }

    /**
     * Use Morris Search to do it in O(1) space
     *
     *   1. Initialize current as root
         2. While current is not NULL
             If current does not have left child
             a) Print current’s data
             b) Go to the right, i.e., current = current->right
             Else
             a) Make current as right child of the rightmost node in current's left subtree
             b) Go to this left child, i.e., current = current->left
     */
    protected TreeNode recoverTreeFast(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;

        TreeNode previous = null;
        TreeNode current = root;
        while(current != null) {
            if(current.left != null){
                TreeNode pre = current.left;

                while(pre.right != null && pre.right != current){
                    pre = pre.right;
                }

                if(pre.right == null) {
                    // Record next pointer in the right
                    pre.right = current;
                    current = current.left;
                } else {
                    // Visit and compare current value...
                    if(isInvalid(previous, current)) {
                        if(first == null) {
                            first = previous;
                            second = current;
                        } else {
                            second = current;
                        }
                    }

                    // Reset next pointer before going back to upper level
                    pre.right = null;

                    // Move to the right branch
                    previous = current;
                    current = current.right;
                }
            }else {
                // Visit and compare current value...
                if(isInvalid(previous, current)) {
                    if(first == null) {
                        first = previous;
                        second = current;
                    } else {
                        second = current;
                    }
                }

                // Move to the right branch
                previous = current;
                current = current.right;
            }
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

        return root;
    }

    private boolean isInvalid(TreeNode prev, TreeNode current) {
        return (prev != null && prev.val > current.val);
    }

    /**
     * Slow version: Use InOrder to sort and then find the wrong odes
     * Space: O(n)
     */
    public TreeNode recoverTreeSlow(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        dfs(root, queue);

        TreeNode first = null;
        TreeNode second = null;
        for(int i=1;i<queue.size();i++){
            TreeNode prev = queue.get(i-1);
            TreeNode current = queue.get(i);
            if(current.val < prev.val) {
                if(first == null) {
                    // Previous one is incorrect which is larger
                    first = prev;
                    second = current;
                }else {
                    // Current one is the second incorrect which is smaller
                    second = current;
                    break;
                }
            }
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

        return root;
    }

    private void dfs(TreeNode root, ArrayList<TreeNode> queue) {
        if(root != null) {
            dfs(root.left, queue);
            queue.add(root);
            dfs(root.right, queue);
        }
    }

}
