package first;
public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (k <= 1 || head == null) {
			return head;
		}

		int count = 0;
		ListNode u = head;
		while (u != null) {
			count++;
			u = u.next;
		}
		if (count < k) {
			return head;
		}
		count = 0;
		ListNode newHead = null;
		ListNode prev = null;
		ListNode current = head;
		while (current != null) {
			count++;
			if (count < k) {
				ListNode next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			} else {
				ListNode next = current.next;
				current.next = prev;
				head.next = reverseKGroup(next, k);
				newHead = current;
				current = null;
			}
		}
		return newHead;
	}

}
