package first;
public class RemoveDuplicateInListII {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode prev = null;
		ListNode lastDiff = null;
		ListNode u = head;
		boolean flag = false;
		while (u != null) {
			if (prev == null) {
				prev = u;
				u = u.next;
			} else if (prev.val == u.val) {
				flag = true;
				prev = u;
				u = u.next;
			} else if (prev.val != u.val) {
				if (flag) {
					if (lastDiff == null) {
						head = u;
					} else {
						lastDiff.next = u;
					}
					flag = false;
				} else {
					lastDiff = prev;
				}
				prev = u;
				u = u.next;
			}
		}

		if (flag) {
			if (lastDiff == null) {
				head = u;
			} else {
				lastDiff.next = u;
			}
		}

		return head;
	}
}
