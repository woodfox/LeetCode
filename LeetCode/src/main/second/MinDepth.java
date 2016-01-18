package second;

import util.TreeNode;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMinDepth(root);
    }
    
    int getMinDepth(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        if(root.left == null && root.right == null){
            return 1;
        }else{
            int left = getMinDepth(root.left);
            int right = getMinDepth(root.right);
            return Math.min(left, right) + 1;
        }
    }
}
