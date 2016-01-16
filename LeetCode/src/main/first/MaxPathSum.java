package first;
import util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class MaxPathSum {
	Map<TreeNode, Integer> singlePathSum = null;
	
	public int getSinglePathMaxSum(TreeNode root) {
        if(root == null){
        	return 0;
        }
        Integer sum = singlePathSum.get(root);
        if(sum != null) {
        	return sum;
        }
        int leftMax = getSinglePathMaxSum(root.left);
        int rightMax = getSinglePathMaxSum(root.right);
        if(leftMax < 0){
        	leftMax = 0;
        }
        if(rightMax < 0){
        	rightMax = 0;
        }
        int singleSum = root.val + Math.max(leftMax, rightMax);
        singlePathSum.put(root, singleSum);
        return singleSum;
    }
	
	int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		singlePathSum = new HashMap<TreeNode, Integer>();
		int max = Integer.MIN_VALUE;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode u = queue.removeFirst();
			int l = getSinglePathMaxSum(u.left);
			int r = getSinglePathMaxSum(u.right);
			if(l < 0){
				l = 0;				
			}
			if(r < 0){
				r = 0;
			}
			int m = l + r + u.val;
			if(max < m) {
				max = m;
			}
			if(u.left != null){
				queue.add(u.left);
			}
			if(u.right != null){
				queue.add(u.right);
			}
		}
		return max;
	}
	 
    public static void main(String[] args) {
    	MaxPathSum v = new MaxPathSum();
    	
    	System.out.println("Excepted 0:" + v.maxPathSum(null));
    	
    	TreeNode root = new TreeNode(1);
    	TreeNode left = new TreeNode(2);
    	TreeNode right = new TreeNode(3);
    	root.left = left;
    	root.right = right;
    	System.out.println("Excepted 6:" + v.maxPathSum(root));
    	
    	root = new TreeNode(1);
    	System.out.println("Excepted 1:" + v.maxPathSum(root));
    	
    	root = new TreeNode(1);
    	left = new TreeNode(-5);
    	right = new TreeNode(7);
    	TreeNode l2 = new TreeNode(3);
    	TreeNode r2 = new TreeNode(2);
    	right.left = l2;
    	right.right = r2;
    	root.left = left;
    	root.right = right;
    	System.out.println("Excepted 12:" + v.maxPathSum(root));
    }
}
