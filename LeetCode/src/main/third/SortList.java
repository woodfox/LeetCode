package third;

import util.ListNode;

public class SortList {
    // Merge List with time O(nlgn)
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }

        int n = 1;
        ListNode node = head;
        while(node.next != null) {
            node = node.next;
            n++;
        }

        return mergeSort(head, n);
    }

    private ListNode mergeSort(ListNode head, int length) {
        if(length <= 1) {
            return head;
        }

        int leftLength = length/2;
        int rightLength = length - leftLength;

        int count = 1;
        ListNode node = head;
        while(count < leftLength) {
            node = node.next;
            count++;
        }

        ListNode rightHead = node.next;
        // Break the link between left and right
        node.next = null;

        ListNode left = mergeSort(head, leftLength);
        ListNode right = mergeSort(rightHead, rightLength);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = null;
        ListNode node = null;
        while(left != null || right != null) {
            int leftValue = Integer.MAX_VALUE;
            if(left != null) {
                leftValue = left.val;
            }

            int rightValue = Integer.MAX_VALUE;
            if(right != null) {
                rightValue = right.val;
            }

            ListNode nextNode = null;
            if(leftValue <= rightValue) {
                nextNode = left;
                left = left.next;
            } else {
                nextNode = right;
                right = right.next;
            }

            if(head == null) {
                head = nextNode;
                node = nextNode;
            } else {
                node.next = nextNode;
                node = nextNode;
            }
        }

        return head;
    }
}
