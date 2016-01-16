package third;

import second.ListNode;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;

        ListNode prev = null;
        ListNode first = head;
        ListNode second = head;
        for(int i=1;i<n;i++){
            second = second.next;
        }

        while(second.next != null) {
            prev = first;
            first = first.next;
            second = second.next;
        }

        if(prev == null) {
            return head.next;
        }else {
            prev.next = first.next;
            return head;
        }
    }
}
