package third;

import util.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______6______
 /              \
 ___2__          ___8__
 /      \        /      \
 0      _4       7       9
 /  \
 3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorOfBST {
    /**
     * This way applies for Binary Search Tree.
     *
     * Time: O(h), h is tree height
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        } else if(p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        if(root.val >= p.val && root.val <= q.val) {
            return root;
        } else if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }


    /**
     * This way applies for all Binary Tree.
     *
     * Time: O(n)
     */
    TreeNode r;
    int level;

    public TreeNode lowestCommonAncestor_BinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        r = null;
        level = -1;
        checkNode(root, q, p, 0);
        return r;
    }

    private int checkNode(TreeNode node, TreeNode p, TreeNode q, int l) {
        if(node == null) {
            return 0;
        } else {
            int count = checkNode(node.left, p, q, l+1) + checkNode(node.right, p, q, l+1);
            if(node == p || node == q) {
                count++;
            }

            if(count == 2 && l > level) {
                level = l;
                r = node;
            }
            return count;
        }
    }
}
