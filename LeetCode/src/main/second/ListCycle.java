package second;

public class ListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        
        ListNode a = head;
        ListNode b = head.next;
        while(b != null){
            if(a == b){
                return true;
            }
            a = a.next;
            b = b.next;
            if(b != null){
                b = b.next;
            }
        }
        return false;
    }
}
