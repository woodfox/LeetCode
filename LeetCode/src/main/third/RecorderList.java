package third;

import util.ListNode;

public class RecorderList {
    /**
     * Get total number of nodes (n), and keep left side of roundUp(n/2),
     * while reverse right side of roundDown(n/2). Then merge them to one.
     * Time: O(n)
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        int total = 1;
        ListNode node = head;
        while(node.next != null) {
            node = node.next;
            total++;
        }

        // Find the end of left list
        int leftLength = (total+1)/2;
        int count = 1;
        node = head;
        while(count < leftLength) {
            count++;
            node = node.next;
        }

        // Reverse right list and get last node,
        // And cut off the link between left and right
        ListNode rightNode = node.next;
        node.next = null;

        ListNode prev = null;
        while(rightNode != null) {
            ListNode next = rightNode.next;
            rightNode.next = prev;
            prev = rightNode;
            rightNode = next;
        }

        // Now prev is the last node which is start of new right list
        rightNode = prev;

        // Merge two lists
        while(rightNode != null) {
            ListNode leftNext = head.next;
            ListNode rightNext = rightNode.next;
            head.next = rightNode;
            rightNode.next = leftNext;

            head = leftNext;
            rightNode = rightNext;
        }
    }

    /**
     * Divide and conquer.  (Limit Time Exceeded!)
     * Time: f(n) = n + f(n-2)= O(n^2)
     *
     */
    public void reorderList_slow(ListNode head) {
        move(head);
    }

    ListNode move(ListNode head) {
        if(head == null) {
            return null;
        } else if(head.next == null || head.next.next == null) {
            // Only one or two elements, just return head
            return head;
        }

        ListNode prev = head;
        ListNode last = head;
        while(last.next != null) {
            prev = last;
            last = last.next;
        }

        prev.next = null;
        last.next = move(head.next);
        head.next = last;
        return head;
    }
}
