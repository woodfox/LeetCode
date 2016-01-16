package second;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ArrayList<ListNode> l) {
        if(l.size() == 0){
            return null;
        }
        
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(l.size(), new NodeComparator());
        for(ListNode node : l){
            if(node != null){
                q.add(node);
            }
        }
        ListNode head = null;
        ListNode cur = null;
        while(!q.isEmpty()){
            ListNode node = q.poll();
            if(node.next != null){
                q.offer(node.next);
            }
            if(head == null){
                head = node;
                cur = node;
            }else{
                cur.next = node;
                cur = node;
            }
        }
        return head;
    }
    
    class NodeComparator implements Comparator<ListNode> {
    	public int compare(ListNode a, ListNode b ){
    		if(a == null || b == null){
    			return 0;
    		}
    		if(a.val < b.val){
    			return -1;
    		}else if(a.val == b.val){
    			return 0;
    		}else{
    			return 1;
    		}
    	}
    }
}
