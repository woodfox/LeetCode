package third;

import second.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        } else if(root.val < max && root.val > min){
            return validate(root.left, min, root.val) && validate(root.right, root.val, max);
        } else {
            return false;
        }
    }
}
