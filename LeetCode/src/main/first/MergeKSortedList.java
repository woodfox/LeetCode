package first;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
	public ListNode mergeKLists(ArrayList<ListNode> l) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode head = null;
		ListNode current = null;
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(10,
				new NodeComparator());
		for (int i = 0; i < l.size(); i++) {
			ListNode u = l.get(i);
			if (u != null) {
				q.offer(u);
			}
		}
		while (!q.isEmpty()) {
			ListNode u = q.poll();
			if (head == null) {
				head = u;
				current = u;
			} else {
				current.next = u;
				current = u;
			}
			if (u.next != null) {
				q.offer(u.next);
			}
		}

		return head;
	}

	public class NodeComparator implements Comparator<ListNode> {
		public int compare(ListNode u, ListNode v) {
			if (u.val <= v.val) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
