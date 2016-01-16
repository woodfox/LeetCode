package first;
public class ReverseLinkedList {
	//Think carefully before starting to write code!!
	//Otherwise it will delay the spend of writing and may write wrong code.
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == n) {
			return head;
		}

		ListNode first = null;
		ListNode last = null;
		ListNode start = null;
		ListNode end = null;
		int i = 1;
		ListNode prev = null;
		ListNode current = head;
		while (i <= n) {
			if (i > m && i <= n) {
				ListNode tmp = current.next;
				current.next = prev;
				prev = current;
				current = tmp;

				if (i == n) {
					end = prev;
					last = tmp;
				}
				i++;
			} else {
				if (i == m) {
					if (i > 1) {
						first = prev;
					}
					start = current;
				}

				i++;
				prev = current;
				current = current.next;
			}
		}

		start.next = last;
		if (first != null) {
			first.next = end;
			return head;
		} else {
			return end;
		}
	}
}
