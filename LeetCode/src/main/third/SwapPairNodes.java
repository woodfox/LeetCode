package third;

import util.ListNode;

public class SwapPairNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        //Danger: be careful if list has only one node!
        ListNode newHead = head;
        ListNode prev = head;

        ListNode first = head;
        ListNode second = head.next;
        while(second != null) {
            ListNode third = second.next;
            second.next = first;
            first.next = third;

            if(newHead == head) {
                newHead = second;
                prev = first;
            }else{
                prev.next = second;
                prev = first;
            }

            first = third;
            second = getNext(first);
        }

        return newHead;
    }

    private ListNode getNext(ListNode node) {
        if(node == null) {
            return null;
        }else {
            return node.next;
        }
    }
}
