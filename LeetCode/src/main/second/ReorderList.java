package second;

import util.ListNode;

import java.util.LinkedList;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        LinkedList<ListNode> q = new LinkedList<ListNode>();
        ListNode node = head;
        while(node != null){
            q.add(node);
            node = node.next;
        }
        
        while(q.size() > 2){
            ListNode first = q.removeFirst();
            ListNode mid = q.peekFirst();
            ListNode last = q.removeLast();
            first.next = last;
            last.next = mid;
        }
        if(!q.isEmpty()){
            q.peekLast().next = null;
        }
    }
}
