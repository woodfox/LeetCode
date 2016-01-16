package first;
public class PartiionList {
	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode lastLess = null;
		ListNode firstLarge = null;
		ListNode parent = null;
		ListNode current = head;
		while (current != null) {
			if (current.val >= x) {
				if (firstLarge == null) {
					firstLarge = current;
				}
			} else {
				if (firstLarge != null) {
					parent.next = current.next;
					current.next = firstLarge;
					if (lastLess == null) {
						lastLess = current;
						head = current;
					} else {
						lastLess.next = current;
					}
					lastLess = current;
					current = parent.next;
					continue;
				} else {
					lastLess = current;
				}

			}
			parent = current;
			current = current.next;
		}
		return head;
	}
}
