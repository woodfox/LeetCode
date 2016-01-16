package second;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean check(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        
        if(root.val <= min || root.val >= max){
            return false;
        }
        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }
}
