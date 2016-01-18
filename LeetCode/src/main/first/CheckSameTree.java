package first;

import util.TreeNode;

public class CheckSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if((p == null && q != null) 
        || (p != null && q == null)
        || (p != null && q != null && p.val != q.val)){
            return false;
        }else if (p == null && q == null){
            return true;
        }else{
            if(!isSameTree(p.left, q.left)){
                return false;
            }
            if(!isSameTree(p.right, q.right)){
                return false;
            }
        }
        return true;
    }
}
