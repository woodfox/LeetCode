package third;

import util.ListNode;

public class PartitionList {
    /**
     * Filter records with left and right, and merge them.
     *
     * Left head -> ... -> left node (value < x),  Right head -> ... -> right node
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;

        ListNode left = null;
        ListNode leftHead = null;

        ListNode right = null;
        ListNode rightHead = null;

        ListNode node = head;
        while(node != null) {
            if(node.val < x) {
                if(left == null) {
                    leftHead = node;
                }else{
                    left.next = node;
                }
                left = node;
            }else{
                if(right == null) {
                    rightHead = node;
                }else {
                    right.next = node;
                }
                right = node;
            }

            // Reset the next link of node to avoid dead loop!
            ListNode next = node.next;
            node.next = null;
            node = next;
        }

        if(leftHead == null) {
            return rightHead;
        }
        else {
            left.next = rightHead;
            return leftHead;
        }
    }
}
