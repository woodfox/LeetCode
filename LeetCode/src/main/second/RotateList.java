package second;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        
        int n = 1;
        ListNode node = head;
        while(node.next != null){
            node = node.next;
            n++;
        }
        
        //If k > n, then only rotate the smaller part
		if (k > n) {
			k = k % n;
		}
		if(k == 0 || k == n){
            return head;
        }
        
        ListNode last = head;
        for(int i=1;i<n-k;i++){
            last = last.next;
        }
        ListNode first = last.next;
        last.next = null;
        node.next = head;
        return first;
    }
}
