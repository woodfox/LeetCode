package third;

import util.ListNode;

import java.util.LinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome
 */
public class PalindromeLinkedList {
    /**
     * Reverse last half list to compare with first half list, then reverse back
     *
     * Time: O(n)   Space: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        int n = 1;
        ListNode node = head;
        while(node.next != null){
            n++;
            node = node.next;
        }
        if(n <= 1) {
            return true;
        }

        node = head;
        for(int i=1;i<=(n+1)/2;i++) {
            node = node.next;
        }

        // Then node is the first element in last half list, Reverse it
        ListNode last = reverse(node);
        ListNode l = head;
        ListNode r = last;
        boolean flag = true;
        while(r != null) {
            if(l.val != r.val) {
                flag = false;
                break;
            }
            l = l.next;
            r = r.next;
        }

        // Finally reverse back last half list
        reverse(last);

        return flag;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        // Prev is the last element
        return prev;
    }

    /**
     * Use O(n) space to store node values in linkedlist and comapre first and last
     */
    public boolean isPalindrome_moreSpace(ListNode head) {
        LinkedList<Integer> q = new LinkedList();
        ListNode node = head;
        while(node != null){
            q.add(node.val);
            node = node.next;
        }
        while(q.size() > 1){
            int first = q.removeFirst();
            int last = q.removeLast();
            if(first != last) {
                return false;
            }
        }
        return true;
    }
}
