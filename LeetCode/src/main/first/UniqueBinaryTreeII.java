package first;

import java.util.ArrayList;

public class UniqueBinaryTreeII {
	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0) {
			ArrayList<TreeNode> result = new ArrayList<TreeNode>();
			result.add(null);
			return result;
		}
		return construct(1, n);
	}

	ArrayList<TreeNode> construct(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			return result;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = construct(start, i - 1);
			ArrayList<TreeNode> right = construct(i + 1, end);
			if (left.size() == 0 && right.size() == 0) {
				result.add(new TreeNode(i));
			} else if (left.size() == 0 && right.size() > 0) {
				for (TreeNode u : right) {
					TreeNode r = new TreeNode(i);
					r.right = u;
					result.add(r);
				}
			} else if (left.size() > 0 && right.size() == 0) {
				for (TreeNode u : left) {
					TreeNode r = new TreeNode(i);
					r.left = u;
					result.add(r);
				}
			} else {
				for (TreeNode u : left) {
					for (TreeNode v : right) {
						TreeNode r = new TreeNode(i);
						r.left = u;
						r.right = v;
						result.add(r);
					}
				}
			}
		}
		return result;
	}
}
