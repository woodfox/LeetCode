package util;
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TreeNode))
			return false;
		if (obj == this)
			return true;

		TreeNode a = (TreeNode)obj;
		return this.toString().equals(a.toString());
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.val+",");
		this.printTree(sb);

		return sb.toString();
	}

	private void printTree(StringBuffer sb) {

		if(this.left != null) {
			sb.append(this.left.val+",");
		} else {
			sb.append("x,");
		}

		if(this.right != null) {
			sb.append(this.right.val+",");
		}else {
			sb.append("x,");
		}

		if(this.left != null) {
			this.left.printTree(sb);
		}

		if(this.right != null) {
			this.right.printTree(sb);
		}
	}
}


