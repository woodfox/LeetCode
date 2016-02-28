package second;

import util.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prevNode = head;
        ListNode node = head.next;
        while(node != null){
            ListNode prev = null;
            ListNode cur = head;
            while(cur != node){
                if(cur.val > node.val){
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
            ListNode next = node.next;
            if(cur != node){
                if(prev == null){
                    node.next = head;
                    head = node;
                }else{
                    prev.next = node;
                    node.next = cur;
                }
                prevNode.next = next;
            }else{
                prevNode = node;
            }
            node = next;
        }
        return head;
    }
}
