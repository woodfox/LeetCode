package first;

import util.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return true;
        }
        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean checkNode(TreeNode u, int min, int max){
        if(u == null){
            return true;
        }
        
        if(!(u.val > min && u.val < max)){
            return false;
        }
        if(!checkNode(u.left, min, u.val)){
            return false;
        }
        if(!checkNode(u.right, u.val, max)){
            return false;
        }
        return true;
    }
}