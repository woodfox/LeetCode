package third;

import second.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        if(m == n) return head;

        if(m == 1) {
            return reverse(head, n-m+1);
        }else {
            ListNode leftEnd = head;
            for (int i = 1; i < m - 1; i++) {
                leftEnd = leftEnd.next;
            }
            ListNode middleStart = leftEnd.next;
            leftEnd.next = reverse(middleStart, n-m+1);
            return head;
        }
    }

    private ListNode reverse(ListNode head, int length) {
        ListNode node = head;
        ListNode second = node.next;
        for(int i=0;i<length-1;i++){
            // Save the third node before overriding it
            ListNode third = second.next;
            second.next = node;
            node = second;
            second = third;
        }
        // At last: head <-- ... <-- node | rightNode --> ...
        head.next = second;
        return node;
    }
}
