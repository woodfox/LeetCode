package first;

import util.TreeLinkNode;

public class NextPointer {
	public void connect(TreeLinkNode r) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (r == null) {
			return;
		}
		r.next = null;
		setNode(r);
	}

	void setNode(TreeLinkNode u) {
		if (u == null) {
			return;
		}
		if (u.left != null) {
			u.left.next = u.right;
		}
		if (u.right != null && u.next != null) {
			u.right.next = u.next.left;
		}
		setNode(u.left);
		setNode(u.right);
	}
}
