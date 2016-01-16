package third;

import second.TreeNode;

/**
 * Time: Worst case when all nodes is in left =>
 *   (n-1) + (n-2) + ...  = O(n^2)
 */
public class FlattenTreeToList {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root) {
        if(root != null) {
            TreeNode left = flattenTree(root.left);
            TreeNode right = flattenTree(root.right);

            root.left = null;

            // If left is not empty, root -> left -> right!!
            // Otherwise root -> right!!
            if(left != null) {
                root.right = left;

                TreeNode last = left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = right;
            } else {
                root.right = right;
            }
        }

        return root;
    }
}
