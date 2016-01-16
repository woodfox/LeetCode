package third;

import second.ListNode;
import second.TreeNode;

public class SortedListToBST {
    /**
     *  1 -> 2 -> 3 -> 4 -> 5
     *
     *  Time Complexity: O(nlgn)
     */
    public TreeNode sortedListToBST(ListNode head) {
        int total = 0;
        ListNode node = head;
        while(node != null) {
            total++;
            node = node.next;
        }

        return construct(head, total);
    }

    private TreeNode construct(ListNode head, int total) {
        if(total <= 0 || head == null) return null;

        int middle = (total+1)/2;
        int count = 1;
        ListNode node = head;
        while(count < middle) {
            node = node.next;
            count++;
        }

        TreeNode treeNode = new TreeNode(node.val);
        treeNode.left = construct(head, middle-1);
        treeNode.right = construct(node.next, total-middle);
        return treeNode;
    }
}
