package third;

import util.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveListElement {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode node = head;
        while(node != null) {
            if(node.val == val) {
                if(prev == null) {
                    head = node.next;
                } else {
                    prev.next = node.next;
                }
            } else {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }
}
