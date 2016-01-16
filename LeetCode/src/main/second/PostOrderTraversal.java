package second;

import java.util.ArrayList;
import java.util.LinkedList;

public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        if(root == null){
            return r;
        }
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        LinkedList<Color> c = new LinkedList<Color>();
        addNode(q, c, root, Color.WHITE);
        while(!q.isEmpty()){
            TreeNode node = q.removeLast();
            Color color = c.removeLast();
            if(color == Color.GREY){
                r.add(node.val);
            }else{
                addNode(q, c, node, Color.GREY);
                addNode(q, c, node.right, Color.WHITE);
                addNode(q, c, node.left, Color.WHITE);
            }
        }
        return r;
    }
    
    void addNode(LinkedList<TreeNode> q, LinkedList<Color> c, TreeNode node, Color color){
        if(node != null){
            q.add(node);
            c.add(color);
        }
    }
    
    private enum Color {
        WHITE, GREY;
    }
}
