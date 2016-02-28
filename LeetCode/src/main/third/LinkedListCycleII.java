package third;

import util.ListNode;

public class LinkedListCycleII {
    /**
     * Use two pointers to check where it meets (one is two-times faster than the other one).
     * And from the meeting position, one starts from starting point, while another one starts from meeting position.
     *
     * Prove: The total nodes of slower one is same as the total length of the loop (2X times + 1 ). So the length of the
     * starting point to start of cycle is the length from meeting position+1 to start of cycle - 1.
     *
     * In case head is the starting position of cycle, meet is the head!!
     *
     * n = 2*m+1                          | => l = m+1
     * n = m + l (l is length of cycle)   |
     *   @  -> @  -> @
     *            /   \
     *           @     @
     *          /      /
     *          @ <- @
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode meet = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null) {
            if(fast == slow) {
                meet = fast;
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
        }

        if(meet == null) {
            return null;
        } else if(meet == head) {
            // In case head is the starting position of cycle, meet is the head
            return head;
        } else {
            slow = head;
            fast = meet.next;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
