package third;

import second.ListNode;

public class ReverseListWithKGroup {
    //Danger: be careful of the k group length!
    //Practice more!
    public ListNode reverseKGroup(ListNode head, int k) {
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
