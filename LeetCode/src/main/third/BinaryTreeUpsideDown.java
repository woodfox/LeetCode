package third;

import util.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},

       1
     /  \
     2  3
    / \
   4  5
  return the root of the binary tree [4,5,2,#,#,3,1].

      4
     / \
    5  2
      / \
     3  1
 */
public class BinaryTreeUpsideDown {
    /**
     * Recursive solution.
     *
     * Careful:
     * 1. Reset root's left and right at first!
     */
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        // Reset old links to avoid dead loop!
        root.left = null;
        root.right = null;

        return rotate(root, left, right);
    }

    private TreeNode rotate(TreeNode root, TreeNode left, TreeNode right) {
        if(left == null) {
            return root;
        } else {
            TreeNode nextLeft = left.left;
            TreeNode nextRight = left.right;

            left.left = right;
            left.right = root;

            // Rotate next level and return final root
            return rotate(left, nextLeft, nextRight);
        }
    }
}
