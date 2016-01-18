package second;

import util.TreeNode;

public class RootToLeafSum {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return dfs(root, 0);
	}

	private int dfs(TreeNode root, int p) {
		if (root == null) {
			return 0;
		}
		p = p * 10 + root.val;
		if (root.left == null && root.right == null) {
			return p;
		} else {
			return dfs(root.left, p) + dfs(root.right, p);
		}
	}
}
