package first;

public class BuildTreeFromInPostorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = inorder.length;
		if (n == 0) {
			return null;
		}

		int v = postorder[n - 1];
		TreeNode root = new TreeNode(v);
		int i = 0;
		for (; i < n; i++) {
			if (inorder[i] == v) {
				break;
			}
		}
		if (i > 0) {
			int[] leftInorder = getSubList(inorder, 0, i - 1);
			int[] leftPostorder = getSubList(postorder, 0, i - 1);
			root.left = buildTree(leftInorder, leftPostorder);
		}
		if (i < n - 1) {
			int[] rightInorder = getSubList(inorder, i + 1, n - 1);
			int[] rightPostorder = getSubList(postorder, i, n - 2);
			root.right = buildTree(rightInorder, rightPostorder);
		}
		return root;
	}

	int[] getSubList(int[] list, int start, int end) {
		int[] sub = new int[end - start + 1];
		for (int i = start; i <= end; i++) {
			sub[i - start] = list[i];
		}
		return sub;
	}
}
