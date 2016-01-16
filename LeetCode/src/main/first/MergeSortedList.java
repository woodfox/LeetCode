package first;
public class MergeSortedList {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode u = a;
		ListNode v = b;
		ListNode head = null;
		ListNode current = null;
		while (u != null || v != null) {
			int i = Integer.MAX_VALUE;
			if (u != null) {
				i = u.val;
			}
			int j = Integer.MAX_VALUE;
			if (v != null) {
				j = v.val;
			}
			if (i <= j) {
				if (current == null) {
					head = u;
					current = u;
				} else {
					current.next = u;
					current = u;
				}
				u = u.next;
			} else {
				if (current == null) {
					head = v;
					current = v;
				} else {
					current.next = v;
					current = v;
				}
				v = v.next;
			}
		}
		return head;
	}
}
