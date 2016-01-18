package second;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        if(root == null){
            return r;
        }
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.removeLast();
            r.add(node.val);
            addNode(node.right, q);
            addNode(node.left, q);
        }
        return r;
    }
    
    void addNode(TreeNode node, LinkedList<TreeNode> q){
        if(node != null){
            q.add(node);
        }
    }
}
