package third;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthElementInBST {
    /**
     * If this method is called frequently, it can maintain the map of total nodes for one node,
     * and plus/minus 1 when inserting/deleting BST for all related nodes.
     */
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> map = new HashMap();
        return findKth(root, k, map);
    }

    private int findKth(TreeNode root, int k, Map<TreeNode, Integer> map) {
        if(root == null) return -1;

        int left = countNodes(root.left, map);
        if(left+1 == k) {
            return root.val;
        } else if(left+1 > k) {
            return findKth(root.left, k, map);
        } else {
            return findKth(root.right, k-left-1, map);
        }
    }

    private int countNodes(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null) {
            return 0;
        } else if(map.containsKey(root)) {
            return map.get(root);
        } else {
            int r = countNodes(root.left, map) + countNodes(root.right, map) + 1;
            map.put(root, r);
            return r;
        }
    }
}
