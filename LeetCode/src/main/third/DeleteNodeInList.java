package third;

import util.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function
 */
public class DeleteNodeInList {
    /**
     * Time: O(n), n is the length from node to tail
     */
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) {
            return;
        }

        ListNode pre = node;
        node = node.next;
        while(node.next != null) {
            pre.val = node.val;
            pre = node;
            node = node.next;
        }

        //Copy the last node, and delete the link of tail
        pre.val = node.val;
        pre.next = null;
    }

}
