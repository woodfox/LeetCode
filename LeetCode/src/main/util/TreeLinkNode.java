package util;
public class TreeLinkNode {
	public int val;
	public TreeLinkNode left;
	public TreeLinkNode right;
	public TreeLinkNode next;

	TreeLinkNode(int x) {
		val = x;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TreeLinkNode))
			return false;
		if (obj == this)
			return true;

		TreeLinkNode a = (TreeLinkNode)obj;
		return (val == a.val && isEqual(left, a.left) && isEqual(right, a.right) && isEqual(next, a.next));
	}

	private boolean isEqual(TreeLinkNode a, TreeLinkNode b) {
		if(a == null && b == null) {
			return true;
		} else if(a == null || b == null) {
			return false;
		} else {
			return a.equals(b);
		}
	}
}
