package third;

import util.ListNode;

public class ReverseListWithKGroup {
    // Divide and conqure
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1) return head;

        int i = 0;
        ListNode current = head;
        while(current != null && i<k){
            current = current.next;
            i++;
        }

        if(i<k) return head;
        ListNode prev = null;
        ListNode node = head;
        while(node != current) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head.next = reverseKGroup(current, k);
        return prev;
    }

    //Danger: be careful of the k group length!
    //Practice more!
    public ListNode reverseKGroup_complex(ListNode head, int k) {
        if(head == null || k ==1) return head;

        //Check if the current list is longer than k nodes
        ListNode node = head;
        int count = 0;
        while(count < k && node != null) {
            node = node.next;
            count++;
        }
        if(count < k){
            return head;
        }

        ListNode last = head;
        ListNode first = head;
        ListNode second = head.next;
        for(int i=1;i<k;i++){
            ListNode third = second.next;
            second.next = first;

            first = second;
            second = third;
        }

        // First is the end of current k group (new head after reversed);
        // and second is the start of next group
        last.next = reverseKGroup(second, k);
        return first;
    }
}
