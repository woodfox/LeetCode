package first;

import util.TreeNode;

public class BuildTreeFromInPreorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = inorder.length;
		if (n == 0) {
			return null;
		}
		int v = preorder[0];
		int i = 0;
		for (; i < n; i++) {
			if (inorder[i] == v) {
				break;
			}
		}
		
		TreeNode root = new TreeNode(v);
		if (i > 0) {
			int[] leftInorder = getSubList(inorder, 0, i - 1);
			int[] leftPreorder = getSubList(preorder, 1, i);
			root.left = buildTree(leftPreorder, leftInorder);
		}
		if (i < n - 1) {
			int[] rightInorder = getSubList(inorder, i + 1, n - 1);
			int[] rightPreorder = getSubList(preorder, i + 1, n - 1);
			root.right = buildTree(rightPreorder, rightInorder);
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
	
	public static void main(String[] args){
		BuildTreeFromInPreorder b = new BuildTreeFromInPreorder();
		int[] preorder = {1,2};
		int[] inorder = {2,1};
		b.buildTree(preorder, inorder);
		
	}
}
