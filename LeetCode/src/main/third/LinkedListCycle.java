package third;

import util.ListNode;

public class LinkedListCycle {
    /**
     * Use two pointers with different speed, and check if faster one could catch slower one.
     * If yes, it means there is cycle; otherwise faster one will reach to the end;
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean slowMove = false;
        while(fast != null && slow != null) {
            fast = fast.next;
            if(fast == slow) {
                return true;
            }

            if(slowMove) {
                slow = slow.next;
                slowMove = false;
            } else {
                slowMove = true;
            }
        }

        return false;
    }
}
