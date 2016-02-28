package third;

import util.ListNode;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = null;

        while(l1 != null || l2 != null){
            int v1 = Integer.MAX_VALUE;
            if(l1 != null) v1 = l1.val;

            int v2 = Integer.MAX_VALUE;
            if(l2 != null) v2 = l2.val;

            ListNode node;
            if(v1 <= v2){
                node = new ListNode(v1);
                l1 = l1.next;
            }else{
                node = new ListNode(v2);
                l2 = l2.next;
            }

            if(head == null){
                prev = node;
                head = node;
            }else{
                prev.next = node;
                prev = node;
            }
        }

        return head;
    }
}
