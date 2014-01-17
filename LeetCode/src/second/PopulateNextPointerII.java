package second;

public class PopulateNextPointerII {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		TreeLinkNode parent = root;
		TreeLinkNode child = root.left;
		if (child == null) {
			child = root.right;
		}

		while (child != null) {
			TreeLinkNode nextChild = null;
			TreeLinkNode nextParent = null;

			TreeLinkNode node = child;
			TreeLinkNode p = parent;
			while (node != null) {
				if (nextChild == null) {
					if (node.left != null) {
						nextChild = node.left;
						nextParent = node;
					} else if (node.right != null) {
						nextChild = node.right;
						nextParent = node;
					}
				}

				if (node == p.left && p.right != null) {
					node.next = p.right;
				} else {
					p = p.next;
					while (p != null && p.left == null && p.right == null) {
						p = p.next;
					}
					if (p != null) {
						if (p.left != null) {
							node.next = p.left;
						} else {
							node.next = p.right;
						}
					}
				}
				node = node.next;
			}

			parent = nextParent;
			child = nextChild;
		}
	}
}
