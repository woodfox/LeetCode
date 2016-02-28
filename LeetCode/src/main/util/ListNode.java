package util;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode prev;
	
	public ListNode(int v) {
		val = v;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ListNode))
			return false;
		if (obj == this)
			return true;

		ListNode a = (ListNode)obj;
		return this.toString().equals(a.toString());
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		ListNode node = this;
		while(node != null) {
			sb.append(node.val + ",");
			node = node.next;
		}
		return sb.toString();
	}
}
