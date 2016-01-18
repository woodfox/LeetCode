package first;

import util.TreeNode;

public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode start){
		int n = 0;
		if(start == null){
			return null;
		}
		ListNode u= start;
		while(u != null){
			n++;
			u = u.next;
		}
		return convert(start, n);
	}
	
	TreeNode convert(ListNode start, int n){
		if(n <= 0){
			return null;
		}
		
		ListNode u = start;
		for(int i=0;i<n/2;i++){
			u = u.next;
		}
		TreeNode root  = new TreeNode(u.val);
		root.left = convert(start, n/2);
		root.right = convert(u.next, n - n/2 -1);
		return root;
	}
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int value) {
			val = value;
		}
	}
}
