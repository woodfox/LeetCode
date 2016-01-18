package third;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        traversalIterative(root, result);

        return result;
    }

    private void traversalIterative(TreeNode root, List<Integer> result) {
        // Node that needs to process left subtree
        TreeNode node = root;

        // waiting nodes that left subtree has been processed
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        while(node != null || !queue.isEmpty()) {
            while(node != null) {
                queue.addFirst(node);
                node = node.left;
            }

            TreeNode current = queue.removeFirst();
            result.add(current.val);
            node = current.right;
        }
    }

    private void traversalRecursive(TreeNode root, List<Integer> result) {
        if(root != null){
            traversalRecursive(root.left, result);
            result.add(root.val);
            traversalRecursive(root.right, result);
        }
    }
}
