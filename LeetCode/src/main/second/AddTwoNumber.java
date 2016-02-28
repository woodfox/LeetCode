package second;

import util.ListNode;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if(a == null){
            return b;
        }else if(b == null){
            return a;
        }
        
        ListNode head = null;
        ListNode cur = null;
        int carry = 0;
        while(a != null || b != null){
            int x = 0;
            if(a != null){
                x = a.val;
                a = a.next;
            }
            int y = 0;
            if(b != null){
                y = b.val;
                b = b.next;
            }
            int r = x + y + carry;
            carry = r/10;
            ListNode node = new ListNode(r%10);
            if(head == null){
                head = node;
                cur = node;
            }else{
                cur.next = node;
                cur = node;
            }
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return head;
    }
}
