package third;

import util.TreeNode;

import java.util.*;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }

        Set<TreeNode> visited = new HashSet<TreeNode>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if(visited.contains(node)) {
                // Second time, should add value
                result.add(node.val);
            } else {
                // First time, add (node, right, left) -> queue header
                visited.add(node);

                queue.addFirst(node);
                if(node.right != null) {
                    queue.addFirst(node.right);
                }
                if(node.left != null) {
                    queue.addFirst(node.left);
                }
            }
        }
        return result;
    }
}
