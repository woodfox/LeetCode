package first;

import java.util.LinkedList;

public class IsBalancedTree {
	// Visit each node only once. Time Complexisity is O(n)
	public boolean isBalanced(TreeNode root) {
		int depth = checkNode(root);
		if (depth == -1) {
			return false;
		} else {
			return true;
		}
	}

	int checkNode(TreeNode u) {
		if (u == null) {
			return 0;
		}
		int left = checkNode(u.left);
		int right = checkNode(u.right);
		if (left == -1 || right == -1) {
			return -1;
		} else if (Math.abs(left - right) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}

	// Visit each node twice. Time Complexisity is O(nlogn)
	public boolean isBalanced2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return true;
		}

		int left = getMaxDepth(root.left);
		int right = getMaxDepth(root.right);
		if (Math.abs(left - right) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	int getMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> d = new LinkedList<Integer>();
		q.add(root);
		d.add(1);
		int maxDepth = 0;
		while (!q.isEmpty()) {
			TreeNode u = q.removeFirst();
			int depth = d.removeFirst();
			if (u.left == null && u.right == null) {
				if (depth > maxDepth) {
					maxDepth = depth;
				}
			} else {
				if (u.left != null) {
					q.add(u.left);
					d.add(depth + 1);
				}
				if (u.right != null) {
					q.add(u.right);
					d.add(depth + 1);
				}
			}
		}
		return maxDepth;
	}
}
