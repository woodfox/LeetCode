package first;

import java.util.ArrayList;

public class RecoverBinaryTree {
	TreeNode first;
	TreeNode second;
	TreeNode parent = null;

	// Enahced with space O(1)
	public void recoverTree(TreeNode root) {
		first = null;
		second = null;
		parent = null;

		dfs(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}

	void dfs(TreeNode r) {
		if (r == null) {
			return;
		}
		dfs(r.left);
		if (parent == null) {
			parent = r;
		} else if (first == null && parent.val > r.val) {
			first = parent;
			second = r;
		} else if (first != null && r.val < second.val) {
			second = r;
		} else {
			parent = r;
		}
		dfs(r.right);
	}

	// Time complexisity is O(n), with space O(n)
	public void recoverTree2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TreeNode> q = new ArrayList<TreeNode>();
		dfs2(root, q);
		TreeNode first = null;
		TreeNode second = null;
		int i = 0;
		for (; i < q.size() - 1; i++) {
			if (q.get(i).val > q.get(i + 1).val) {
				first = q.get(i);
				second = q.get(i + 1);
				break;
			}
		}
		i++;
		for (; i < q.size(); i++) {
			TreeNode u = q.get(i);
			if (u.val < second.val) {
				second = u;
			}
		}

		if (first != null && second != null) {
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}

	}

	void dfs2(TreeNode r, ArrayList<TreeNode> q) {
		if (r == null) {
			return;
		}
		dfs2(r.left, q);
		q.add(r);
		dfs2(r.right, q);
	}
}
