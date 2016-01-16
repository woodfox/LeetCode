package second;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0){
            return head;
        }
        
        int count = 1;
        ListNode node = head;
        while(count < n && node.next != null){
            count++;
            node = node.next;
        }
        if(count < n){
            return head;
        }
        ListNode first = head;
        ListNode prev = null;
        while(node.next != null){
            node = node.next;
            prev = first;
            first = first.next;
        }
        if(prev == null){
            return head.next;
        }else{
            prev.next = first.next;
            return head;
        }
    }
}
