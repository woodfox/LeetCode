package second;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode last = head.next;
        ListNode next = last.next;
        last.next = head;
        head.next = swapPairs(next);
        return last;
    }
}
