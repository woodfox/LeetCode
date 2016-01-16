package first;
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = 0;
		if (head == null) {
			return head;
		}
		ListNode u = head;
		while (u != null) {
			n++;
			u = u.next;
		}

		//If k > n, then only rotate the smaller part
		if (k > n) {
			k = k % n;
		}

		if (k == n || k == 0) {
			return head;
		}

		u = head;
		for (int i = 0; i < n - k - 1; i++) {
			u = u.next;
		}
		ListNode start = u.next;
		u.next = null;
		ListNode v = start;
		while (v.next != null) {
			v = v.next;
		}
		v.next = head;
		return start;
	}
}
