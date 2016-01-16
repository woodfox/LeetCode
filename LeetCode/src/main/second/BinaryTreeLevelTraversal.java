package second;

import java.util.ArrayList;

public class BinaryTreeLevelTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return l;
        }
        
        dfs(l, root, 0);
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
