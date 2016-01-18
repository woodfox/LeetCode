package third;

import util.TreeLinkNode;

import java.util.LinkedList;

/**
 *               1
 *             /  \
 *            3    4
 *           /    / \
 *          5    6  7
 *         /         \
 *        8           9
 *
 * Use queue to save nodes in one level to simplify the logic.
 * In order to use constant space, remove old nodes before adding new nodes.
 */
public class PopulateNextPointerII {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        } else {
            LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();

            // Add next-level nodes into list and connect them
            TreeLinkNode upperNode = root;
            while(upperNode != null) {
                addNode(queue, upperNode.left);
                addNode(queue, upperNode.right);

                upperNode = upperNode.next;
            }

            // Get leftest node in sub level (Be careful when no nodes in the queue!!)
            if(!queue.isEmpty()) {
                TreeLinkNode leftNode = queue.getFirst();
                connect(leftNode);
            }
        }
    }

    private void addNode(LinkedList<TreeLinkNode> queue, TreeLinkNode node) {
        if(node != null) {
            if(!queue.isEmpty()) {
                TreeLinkNode last = queue.getLast();
                last.next = node;
            }

            // Optional for space improvement
            // Remove nodes if there are already 2 nodes (keep first one which is header)
            if(queue.size() > 1) {
                queue.removeLast();
            }

            queue.add(node);
        }
    }
}
