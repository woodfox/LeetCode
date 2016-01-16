package second;

public class ListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode a = head;
        ListNode b = head.next;
        while(b != null){
            if(a == b){
                break;
            }
            a = a.next;
            b = b.next;
            if(b != null){
                b = b.next;
            }
        }
        if(b == null){
            return null;
        }
        
        a = head;
        b = b.next;
        while(a != b){
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
