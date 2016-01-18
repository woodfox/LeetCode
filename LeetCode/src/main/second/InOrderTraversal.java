package second;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class InOrderTraversal {
    enum Color {WHITE, GREY}

    /**
     * Use additional color to identify if it's visited or not.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        if(root == null){
            return r;
        }
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        LinkedList<Color> c = new LinkedList<Color>();
        q.add(root);
        c.add(Color.WHITE);
        while(!q.isEmpty()){
            TreeNode node = q.removeLast();
            Color color = c.removeLast();
            if(color == Color.WHITE){
            	addNode(node.right, q, c);
                q.add(node);
                c.add(Color.GREY);
                addNode(node.left, q, c);
            }else{
                r.add(node.val);
            }
        }
        
        return r;
    }
    
    void addNode (TreeNode root, LinkedList<TreeNode> q, LinkedList<Color> c){
        if(root != null){
            q.add(root);
            c.add(Color.WHITE);
        }
    }
}
