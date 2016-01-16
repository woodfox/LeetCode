package second;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        
        ListNode first, pre, current;
        if(m == 1){
            current = head;
            pre = null;
            first = null;
        }else{
            first = head;
            for(int i=1;i<m-1;i++){
                first = first.next;
            }
            current = first.next;
            pre = null;
        }
        
        for(int i=m;i<=n;i++){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        
        if(m == 1){
            head.next = current;
            return pre;
        }else{
            first.next.next = current;
            first.next = pre;
            return head;
        }
    }
}
