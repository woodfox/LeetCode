package third;

import util.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = even;

        while(even != null) {
            ListNode nextOdd = even.next;
            odd.next = nextOdd;
            if(nextOdd != null) {
                odd = nextOdd;
                even.next = nextOdd.next;
                even = even.next;
            } else {
                even.next = null;
                even = even.next;
            }
        }
        // odd is last odd node
        odd.next = firstEven;
        return head;
    }
}
