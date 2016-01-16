package first;
import util.TreeNode;

import java.util.LinkedList;


public class PathSum {
	public boolean hasPathSum(TreeNode r, int sum) {
		if (r == null) {
			return false;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> s = new LinkedList<Integer>();
		q.add(r);
		s.add(r.val);
		while (!q.isEmpty()) {
			TreeNode u = q.removeFirst();
			int v = s.removeFirst();
			if (u.left == null && u.right == null) {
				if (v == sum) {
					return true;
				}
			} else {
				if (u.left != null) {
					q.add(u.left);
					s.add(v + u.left.val);
				}
				if (u.right != null) {
					q.add(u.right);
					s.add(v + u.right.val);
				}
			}
		}
		return false;
	}
}
