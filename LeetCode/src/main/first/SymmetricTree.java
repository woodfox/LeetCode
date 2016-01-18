package first;

import util.TreeNode;

import java.util.LinkedList;

public class SymmetricTree {
	//Recursively check Symmetric tree
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		l.add(root.left);
		l.add(root.right);
		return check(l);
	}
	
	boolean check(LinkedList<TreeNode> l) {
		LinkedList<TreeNode> left = new LinkedList<TreeNode>();
		LinkedList<TreeNode> right = new LinkedList<TreeNode>();
		while(!l.isEmpty()) {
			TreeNode u = l.removeFirst();
			TreeNode v = l.removeLast();
			if((u == null && v != null) || (u != null && v == null)
					|| (u != null && v != null && u.val != v.val)){
				return false;
			}else if(u != null && v != null){
				left.add(u.left);
				left.add(u.right);
				right.addFirst(v.right);
				right.addFirst(v.left);
			}
		}
		
		LinkedList<TreeNode> m = new LinkedList<TreeNode>();
		m.addAll(left);
		m.addAll(right);
		if(m.size() > 0){
			return check(m);
		}else{
			return true;
		}
	}
	
	//Iteratively check Symmetric tree
	public boolean isSymmetric2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return true;
		}
		LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> left = new LinkedList<TreeNode>();
		LinkedList<TreeNode> right = new LinkedList<TreeNode>();
		q1.add(root.left);
		q1.add(root.right);
		while (!q1.isEmpty()) {
			while (!q1.isEmpty()) {
				TreeNode t1 = q1.removeFirst();
				TreeNode t2 = q1.removeLast();
				if ((t1 == null && t2 != null) || (t1 != null && t2 == null)
						|| (t1 != null && t2 != null && t1.val != t2.val)) {
					return false;
				} else if (t1 != null && t2 != null) {
					left.add(t1.left);
					left.add(t1.right);
					right.addFirst(t2.right);
					right.addFirst(t2.left);
				}
			}
			q1.addAll(left);
			q1.addAll(right);
			left.clear();
			right.clear();
		}
		return true;
	}
}
