package second;

import util.TreeNode;

public class MaxPathSum {
    private int max;
    
    public int maxPathSum(TreeNode root) {
        max  = Integer.MIN_VALUE;
        singlePathSum(root);
        return max;
    }
    
    int singlePathSum(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = singlePathSum(root.left);
        left = Math.max(left, 0);
        int right = singlePathSum(root.right);
        right = Math.max(right, 0);
        max = Math.max(max, left+right+root.val);
        
        //return the max path sum including this node
        return Math.max(left, right) + root.val;
    }
}
