package third;

import second.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

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
        if(k == 0) return head;

        ListNode prev = head;
        ListNode first = head;
        ListNode last = head;
        for(int i=0;i<k-1;i++){
            last = last.next;
        }

        while(last.next != null){
            prev = first;
            first = first.next;
            last = last.next;
        }

        if(first == head) return head;

        last.next = head;
        prev.next = null;
        return first;
    }
}
