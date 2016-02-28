package third;

import util.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,
      5
     / \
    1   5
   / \   \
  5   5   5
 return 4.
 */
public class CountUnivalueSubtree {
    int countUnivalSubtrees(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int r = countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right) + 1;
            if(root.left != null && root.val == root.left.val) {
                r--;
            }
            if(root.right != null && root.val == root.right.val) {
                r--;
            }
            return r;
        }
    }
}
