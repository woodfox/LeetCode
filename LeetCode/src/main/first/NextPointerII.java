package first;

import util.TreeLinkNode;

public class NextPointerII {

    public void connect(TreeLinkNode r) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(r == null){
            return;
        }
        r.next = null;
        setNode(r);
    }
    void setNode(TreeLinkNode u){
        if(u == null){
            return;
        }
        if(u.left != null){
            if(u.right != null){
                u.left.next = u.right;
            }else{
                u.left.next = findNeighbour(u);
            }
            
        }
        if(u.right != null){
            u.right.next = findNeighbour(u);
            
        }
        setNode(u.right);
        setNode(u.left);        
    }
    TreeLinkNode findNeighbour(TreeLinkNode u){
        TreeLinkNode v = u;
        while(v.next != null && v.next.left == null
            && v.next.right == null){
                v = v.next;
        }
        if(v.next == null){
            return null;
        }else if(v.next.left != null){
            return v.next.left;
        }else {
            return v.next.right;
        }
    }
}
