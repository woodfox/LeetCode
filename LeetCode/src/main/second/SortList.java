package second;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        int n = 1;
        ListNode node = head;
        while(node.next != null){
            node = node.next;
            n++;
        }
        return sort(head, n);
    }
    
    ListNode sort(ListNode head, int n){
        if(n <= 1){
            head.next = null;
            return head;
        }
        ListNode m = head;
        int count = 1;
        while(count <= n/2){
            count++;
            m = m.next;
        }
        ListNode a = sort(head, n/2);
        ListNode b = sort(m, n-n/2);
        ListNode first = null;
        ListNode cur = null;
        for(int i=0;i<n;i++){
            ListNode c = null;
            int x = Integer.MAX_VALUE;
            if(a != null){
                x = a.val;
            }
            int y = Integer.MAX_VALUE;
            if(b != null){
                y = b.val;
            }
            if(x <= y){
                c = a;
                a = a.next;
            }else{
                c = b;
                b = b.next;
            }
            
            if(first == null){
                first = c;
                cur = c;
            }else{
                cur.next = c;
                cur = c;
            }
        }
        return first;
    }
}
