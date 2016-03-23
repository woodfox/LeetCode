package third;

import util.TreeNode;

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

    /**
     * Another way is to return head and tail node every time.
     * So that it doesn't need to find last element every time.
     */
    public void flatten_faster(TreeNode root) {
        if(root==null) return;
        flattenNode(root);
    }
    private TreeNode[] flattenNode(TreeNode root){
        if(root.left==null&&root.right==null){
            return new TreeNode[]{root,root};
        } else if(root.left==null){
            TreeNode[] r = flattenNode(root.right);
            return new TreeNode[] {root, r[1]};
        } else if(root.right==null){
            TreeNode[] l = flattenNode(root.left);
            root.left=null;
            root.right=l[0];
            return new TreeNode[] {root, l[1]};
        } else {
            TreeNode[] l = flattenNode(root.left);
            TreeNode[] r = flattenNode(root.right);
            root.left=null;
            root.right=l[0];
            l[1].right=r[0];
            return new TreeNode[] {root, r[1]};
        }
    }
}
