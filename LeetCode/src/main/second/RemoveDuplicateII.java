package second;

import util.ListNode;

public class RemoveDuplicateII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode first = null;
        ListNode last = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            while(next != null && next.val == current.val){
                next = next.next;
            }
            if(next != current.next){
                if(last != null){
                    last.next = next;
                }
            }else{
                if(first == null){
                    first = current;
                }
                last = current;
            }
            current = next;
        }
        return first;
    }
}
