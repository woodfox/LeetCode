package third;

import util.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2       0       8
 /  \
 7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorOfBinaryTree {
    /**
     * This way applies for all Binary Tree.
     *
     * Time: O(n)
     */
    TreeNode r;
    int level;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
