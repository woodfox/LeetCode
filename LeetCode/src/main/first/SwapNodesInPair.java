package first;

public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null){
            return null;
        }
        ListNode second = head.next;
        if(second == null){
            return head;
        }
        ListNode next = second.next;
        second.next = head;
        head.next = swapPairs(next);
        return second;
    }
}
