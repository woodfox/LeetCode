package second;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeZigzagTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return l;
        }
        
        dfs(l, root, 0);
        for(int i=0;i<l.size();i++) {
            if(i%2 == 1){
                Collections.reverse(l.get(i));
            }
        }
        return l;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> l, TreeNode root, int level){
        if(root == null){
            return;
        }
        
        if(level >= l.size()){
            l.add(new ArrayList<Integer>());
        }
        l.get(level).add(root.val);
        dfs(l, root.left, level+1);
        dfs(l, root.right, level+1);
    }
}
