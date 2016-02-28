package third;

import util.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.

 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 Credits:
 Special thanks to @stellari for adding this problem and creating all test cases.
 */
public class IntersectionOfLinkedList {
    /**
     * Get length of two lists, and then move the longer list with different nodes.
     * Then start to loop the list again, which will have same node (or null if not found)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if(lengthA > lengthB) {
            for(int i=1;i<=lengthA-lengthB;i++) {
                headA = headA.next;
            }
        } else if(lengthB > lengthA) {
            for(int i=1;i<=lengthB-lengthA;i++){
                headB = headB.next;
            }
        }

        // Until found the intersection or reach the end
        while(headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode head) {
        int count = 1;
        while(head.next != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
