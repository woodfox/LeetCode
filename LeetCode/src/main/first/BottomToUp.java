package first;

import util.TreeNode;

import java.util.ArrayList;

public class BottomToUp {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		traversal(root, 1, result);
		return reverseList(result);
	}

	void traversal(TreeNode root, int level,
			ArrayList<ArrayList<Integer>> result) {
		if (root == null) {
			return;
		}
		if (result.size() < level) {
			result.add(new ArrayList<Integer>());
		}
		ArrayList<Integer> a = result.get(level - 1);
		a.add(root.val);
		traversal(root.left, level + 1, result);
		traversal(root.right, level + 1, result);
	}

	ArrayList<ArrayList<Integer>> reverseList(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
		for (int i = a.size() - 1; i >= 0; i--) {
			b.add(a.get(i));
		}
		return b;
	}
}
