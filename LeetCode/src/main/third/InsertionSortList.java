package third;

import util.ListNode;

public class InsertionSortList {
    /**
     * From left, pick up one node and find a position in left to insert.
     * 1. Start from new head in the loop!
     * 2. Recover the link from prev -> next when moving one node.
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head;
        ListNode prevNode = head;
        ListNode node = head.next;
        while(node != null) {
            ListNode next = node.next;

            ListNode prev = null;
            // Must start from new head!!!
            ListNode current = newHead;
            while(current != node && current.val <= node.val) {
                prev = current;
                current = current.next;
            }

            if(current != node) {
                if(prev == null) {
                    newHead = node;
                } else {
                    prev.next = node;
                }
                node.next = current;

                // Must resume link before and after the node
                prevNode.next = next;
            } else {
                prevNode = node;
            }

            node = next;
        }

        return newHead;
    }
}
