package second;

import util.TreeNode;

public class SortedList2BST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        int n = 0;
        ListNode node = head;
        while(node != null){
            n++;
            node = node.next;
        }
        return convert(head, n);
    }
    
    TreeNode convert(ListNode head, int n){
        if(n <= 0){
            return null;
        }
        
        ListNode mid = head;
        for(int i=0;i<n/2;i++){
            mid = mid.next;
        }
        
        TreeNode root = new TreeNode(mid.val);
        root.left = convert(head, n/2);
        root.right = convert(mid.next, n-n/2-1);
        return root;
    }
}
