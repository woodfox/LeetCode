package first;

import util.TreeNode;

import java.util.LinkedList;


public class MaxDepth {
	   public int maxDepth(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if (root == null){
	            return 0;
	        }
	        
	        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
	        LinkedList<Integer> d = new LinkedList<Integer>();
	        q.add(root);
	        d.add(1);
	        int maxDepth = Integer.MIN_VALUE;
	        while(!q.isEmpty()){
	            TreeNode u = q.removeFirst();
	            int depth = d.removeFirst();
	            if(u.left == null && u.right == null){
	                if(depth > maxDepth){
	                    maxDepth = depth;
	                }
	            }else{
	                if(u.left != null){
	                    q.add(u.left);
	                    d.add(depth+1);
	                }
	                if(u.right != null){
	                    q.add(u.right);
	                    d.add(depth+1);
	                }
	            }
	        }
	        return maxDepth;
	    }
}
