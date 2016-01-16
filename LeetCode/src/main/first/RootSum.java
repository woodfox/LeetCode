package first;
import util.TreeNode;

import java.util.*;

class RootSum {
	public int rootSum(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int sum = 0;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> sumStack = new LinkedList<Integer>();
        stack.addFirst(root);
        sumStack.addFirst(root.val);
        while(!stack.isEmpty()){
            TreeNode u = stack.removeFirst();
            Integer s = sumStack.removeFirst();
            if(u.left != null){
            	stack.addFirst(u.left);
            	sumStack.addFirst(s * 10 + u.left.val);
            }
            if(u.right != null){
            	stack.addFirst(u.right);
            	sumStack.addFirst(s*10 + u.right.val);
            }
            if(u.left == null  && u.right == null){
                sum += s;
            }
        }
        return sum;
    }

	public static void main(String[] args) throws java.lang.Exception {
		RootSum instance = new RootSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(instance.rootSum(root));
	}
}