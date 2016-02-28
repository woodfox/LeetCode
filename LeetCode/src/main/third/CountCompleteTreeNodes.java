package third;

import util.TreeNode;

public class CountCompleteTreeNodes {
    /**
     * Check height of left and right subtrees. If they are equal, then total nodes = 2^h -1 (h starts from 1)
     *
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = 0;
        TreeNode node = root;
        while(node != null) {
            lh++;
            node = node.left;
        }

        int rh = 0;
        node =root;
        while(node != null) {
            rh++;
            node = node.right;
        }

        if(lh == rh) {
            return (1<<lh) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    /**
     * Slow version without considering complete binary tree. Time Limit Exceed.
     *
     * Time: O(n)
     */
    public int countNodes_slow(TreeNode root) {
        if(root == null) {
            return 0;
        }else {
            return 1+ countNodes_slow(root.left) + countNodes_slow(root.right);
        }
    }
}
