package other;

import util.ListNode;

public class SwapTwoNodesInList {
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if(head == null || v1==v2) return head;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode prev1 = null;
        ListNode prev2 = null;

        ListNode current = head;
        ListNode prev = null;
        while(current != null) {
            if(current.val == v1) {
                if(node1 == null) {
                    node1= current;
                    prev1= prev;
                } else {
                    node2= current;
                    prev2 = prev;
                }
            } else if(current.val == v2) {
                if(node1 == null) {
                    node1= current;
                    prev1= prev;
                } else {
                    node2= current;
                    prev2 = prev;
                }
            }

            prev = current;
            current = current.next;
        }

        if(node1==null || node2==null) return head;

        if(prev1 == null){
            head = node2;
        } else {
            prev1.next = node2;
        }

        ListNode next1= node1.next;
        ListNode next2 = node2.next;
        if(node1.next == node2){
            node2.next = node1;
            node1.next = next2;
        } else {
            node2.next = next1;
            node1.next = next2;
            prev2.next = node1;
        }
        return head;
    }
}
