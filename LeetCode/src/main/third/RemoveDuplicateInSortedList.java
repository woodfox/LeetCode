package third;

import second.ListNode;

public class RemoveDuplicateInSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode nextNode = head.next;
        while(nextNode != null && nextNode.val == head.val){
            nextNode = nextNode.next;
        }
        head.next = deleteDuplicates(nextNode);
        return head;
    }
}
