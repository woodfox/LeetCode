package second;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        
        ListNode firstS = null;
        ListNode lastS = null;
        ListNode firstB = null;
        ListNode lastB = null;
        ListNode node = head;
        while(node != null){
            ListNode next = node.next;
            if(node.val < x){
                if(firstS == null){
                    firstS = node;
                }else{
                    lastS.next = node;
                }
                
                if(lastB != null){
                    node.next = firstB;
                    lastB.next = next;
                }
                lastS = node;
            }else{
                if(firstB == null){
                    firstB = node;
                }
                lastB = node;
            }
            node = next;
        }
        
        if(firstS != null){
            return firstS;
        }else{
            return firstB;
        }
    }
}
