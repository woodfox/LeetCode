package third;

import second.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode current = null;
        while(l1 != null || l2 != null || carry > 0) {
            int a = 0;
            if(l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            int b = 0;
            if(l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int t = a + b + carry;
            int remain = t % 10;
            carry = t / 10;
            if(head == null) {
                head = new ListNode(remain);
                current = head;
            }else {
                current.next = new ListNode(remain);
                current = current.next;
            }
        }
        return head;
    }
}
