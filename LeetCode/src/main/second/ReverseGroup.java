package second;

public class ReverseGroup {
    public ListNode reverseKGroup(ListNode head, int n) {
        if(head == null || n == 0){
            return head;
        }
        int count = 1;
        ListNode node = head;
        while(count < n && node.next != null){
            node = node.next;
            count++;
        }
        if(count < n){
            return head;
        }
        
        ListNode end = node.next;
        ListNode prev = reverseKGroup(node.next, n);
        ListNode cur = head;
        while(cur != null && cur != end){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return node;
    }
}
