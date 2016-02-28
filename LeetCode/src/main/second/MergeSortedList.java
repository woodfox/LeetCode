package second;

import util.ListNode;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null){
            return b;
        }else if(b == null){
            return a;
        }
        
        ListNode head = null;
        ListNode last = null;
        ListNode p = a;
        ListNode q = b;
        while(p != null || q != null){
            int x = Integer.MAX_VALUE;
            if(p != null){
                x = p.val;
            }
            int y = Integer.MAX_VALUE;
            if(q != null){
                y = q.val;
            }
            
            ListNode next;
            if(x <= y){
                next = p;
                p = p.next;
            }else{
                next = q;
                q = q.next;
            }
            if(head == null){
                head = next;
                last = next;
            }else{
                last.next = next;
                last = next;
            }
        }
        return head;
    }
}
