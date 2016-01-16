package first;
public class RemoveDulicateInList {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode prev = null;
		ListNode u = head;
		while (u != null) {
			if (prev != null && prev.val == u.val) {
				prev.next = u.next;
				u = u.next;
			} else {
				prev = u;
				u = u.next;
			}
		}
		return head;
	}
}
