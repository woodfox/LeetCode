package first;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class PathSumII {
	//Use ArrayList<Integer> to collect path, so it will not throw TLE error.
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode r, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (r == null) {
			return result;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> s = new LinkedList<Integer>();
		LinkedList<ArrayList<Integer>> p = new LinkedList<ArrayList<Integer>>();
		q.add(r);
		s.add(r.val);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(r.val);
		p.add(a);
		while (!q.isEmpty()) {
			TreeNode u = q.removeFirst();
			int v = s.removeFirst();
			ArrayList<Integer> path = p.removeFirst();
			if (u.left == null && u.right == null) {
				if (v == sum) {
					result.add(path);
				}
			} else {
				if (u.left != null) {
					q.add(u.left);
					s.add(v + u.left.val);
					ArrayList<Integer> b = new ArrayList<Integer>();
					b.addAll(path);
					b.add(u.left.val);
					p.add(b);
				}
				if (u.right != null) {
					q.add(u.right);
					s.add(v + u.right.val);
					ArrayList<Integer> b = new ArrayList<Integer>();
					b.addAll(path);
					b.add(u.right.val);
					p.add(b);
				}
			}
		}
		return result;
	}

	// Using String to collect path will throw Time Limited Error
	public ArrayList<ArrayList<Integer>> pathSum2(TreeNode r, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (r == null) {
			return result;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> s = new LinkedList<Integer>();
		LinkedList<String> p = new LinkedList<String>();
		q.add(r);
		s.add(r.val);
		p.add("");
		while (!q.isEmpty()) {
			TreeNode u = q.removeFirst();
			int v = s.removeFirst();
			String path = p.removeFirst();
			if (u.left == null && u.right == null) {
				if (v == sum) {
					result.add(getPath(r, path));
				}
			} else {
				if (u.left != null) {
					q.add(u.left);
					s.add(v + u.left.val);
					p.add(path + "0");
				}
				if (u.right != null) {
					q.add(u.right);
					s.add(v + u.right.val);
					p.add(path + "1");
				}
			}
		}
		return result;
	}

	public ArrayList<Integer> getPath(TreeNode r, String path) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(r.val);
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == '0') {
				a.add(r.left.val);
				r = r.left;
			} else {
				a.add(r.right.val);
				r = r.right;
			}
		}
		return a;
	}
}
