package third;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            result.add(node.val);

            // Add right first, so left will be visited before right
            if(node.right != null) {
                queue.addFirst(node.right);
            }
            if(node.left != null) {
                queue.addFirst(node.left);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal_recursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if(root != null) {
            result.add(root.val);

            traversal(root.left, result);
            traversal(root.right, result);
        }
    }
}
