package third;

import second.ListNode;

public class RemoveDuplicateInSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        int value = head.val;
        if(head.next != null && head.next.val == value) {
            while(head != null && head.val == value){
                head = head.next;
            }
            return deleteDuplicates(head);
        }else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
