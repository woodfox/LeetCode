package third;

import second.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    //O(mn), m=lists number, n=total list nodes
    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<NodeWithIndex> sorted = new PriorityQueue<NodeWithIndex>();
        for(int i=0;i<lists.size();i++){
            ListNode node = lists.get(i);
            if(node != null) {
                sorted.add(new NodeWithIndex(node, i));
            }
        }

        ListNode head = null;
        ListNode prev = null;
        while(!sorted.isEmpty()) {
            NodeWithIndex smallest = sorted.poll();
            if(head == null) {
                prev = smallest.node;
                head = prev;
            }else{
                prev.next = smallest.node;
                prev = prev.next;
            }

            if(smallest.node.next != null) {
                sorted.add(new NodeWithIndex(smallest.node.next, smallest.index));
            }
        }

        return head;
    }

    private class NodeWithIndex implements Comparable<NodeWithIndex> {
        ListNode node;
        int index;

        public NodeWithIndex(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }

        public int compareTo(NodeWithIndex other) {
            return node.val - other.node.val;
        }
    }
}
