package second;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        LinkedList<Integer> level = new LinkedList<Integer>();

        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return l;
        }
        q.add(root);
        level.add(0);
        while(!q.isEmpty()){
            int k = level.removeFirst();
            TreeNode node = q.removeFirst();
            if(k >= l.size()){
                l.add(0, new ArrayList<Integer>());
            }
            l.get(0).add(node.val);
            
            if(node.left != null){
                q.add(node.left);
                level.add(k+1);
            }
            if(node.right != null){
                q.add(node.right);
                level.add(k+1);
            }
        }
        
        return l;
    }
}
