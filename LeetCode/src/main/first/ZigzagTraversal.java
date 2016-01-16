package first;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZigzagTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}

		LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);
		int level = 0;
		ArrayList<Integer> c = new ArrayList<Integer>();
		while (!q1.isEmpty()) {
			TreeNode u;
			if (level % 2 == 0) {
				u = q1.removeFirst();
			} else {
				u = q1.removeLast();
			}

			if (level % 2 == 0) {
				if (u.left != null) {
					q2.addLast(u.left);
				}
				if (u.right != null) {
					q2.addLast(u.right);
				}
			} else {
				if (u.right != null) {
					q2.addFirst(u.right);
				}
				if (u.left != null) {
					q2.addFirst(u.left);
				}
			}

			c.add(u.val);
			if (q1.isEmpty()) {
				level++;
				q1.addAll(q2);
				q2.clear();
				result.add(c);
				c = new ArrayList<Integer>();
			}
		}
		return result;
	}

	// Zigzag level traversal which need to reverse the arraylist after dfs
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		dfs(root, 0, result);
		return reverse(result);
	}

	void dfs(TreeNode u, int level, ArrayList<ArrayList<Integer>> result) {
		if (u == null) {
			return;
		}
		if (result.size() < level + 1) {
			result.add(new ArrayList<Integer>());
		}
		ArrayList<Integer> l = result.get(level);
		l.add(u.val);
		dfs(u.left, level + 1, result);
		dfs(u.right, level + 1, result);
	}

	ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> r) {
		for (int i = 0; i < r.size(); i++) {
			if (i % 2 == 0) {
				continue;
			}

			ArrayList<Integer> a = r.get(i);
			ArrayList<Integer> b = new ArrayList<Integer>();
			for (int j = a.size() - 1; j >= 0; j--) {
				b.add(a.get(j));
			}
			r.set(i, b);
		}
		return r;
	}
}
