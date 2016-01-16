package first;
public class RemoveKthNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode u = head;
		int count = 1;
		if (head == null || n == 0) {
			return head;
		}
		while (u.next != null) {
			if (count == n) {
				break;
			}
			u = u.next;
			count++;
		}

		if (count < n) {
			return head;
		}

		ListNode v = head;
		ListNode prev = null;
		while (u.next != null) {
			prev = v;
			u = u.next;
			v = v.next;
		}

		if (prev == null) {
			return head.next;
		} else {
			prev.next = v.next;
		}
		return head;
	}
}
