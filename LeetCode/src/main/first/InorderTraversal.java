package first;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class InorderTraversal {
	// Inorder traversal with stack
	public ArrayList<Integer> inorderTraversal(TreeNode r) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (r == null) {
			return result;
		}

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> color = new LinkedList<Integer>();
		q.addFirst(r);
		color.addFirst(0);
		while (!q.isEmpty()) {
			TreeNode u = q.removeFirst();
			int c = color.removeFirst();
			if (c == 0) {
				addNode(u.right, q, color);
				q.addFirst(u);
				color.addFirst(1);
				addNode(u.left, q, color);
			} else {
				result.add(u.val);
			}
		}
		return result;
	}

	void addNode(TreeNode u, LinkedList<TreeNode> q, LinkedList<Integer> color) {
		if (u != null) {
			q.addFirst(u);
			color.addFirst(0);
		}
	}

	// Inorder traversal recursively
	public ArrayList<Integer> inorderTraversalRecursive(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		dfs(root, result);
		return result;
	}

	void dfs(TreeNode r, ArrayList<Integer> result) {
		if (r == null) {
			return;
		}
		dfs(r.left, result);
		result.add(r.val);
		dfs(r.right, result);
	}
}
