package third;

import second.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInPostOrder {
    /**
     * Given InOrder 4251637
     *       PostOrder 4526731
     *
     * Build the tree:
     *          1
     *         / \
     *        2   3
     *       / \ / \
     *      4  5 6 7
     *
     *
     *  Starting from end of postOrder, and split by the position in inOrder
     *  Time Complexity: O(n) using inorderMap
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        Map<Integer, Integer> inorderMap = getInorderMap(inorder);
        return build(postorder, length-1, inorderMap, 0, length-1);
    }

    private TreeNode build(int[] postorder, int index, Map<Integer, Integer> inorderMap, int start, int end) {
        if(start > end) return null;

        TreeNode node = new TreeNode(postorder[index]);
        int pos = inorderMap.get(postorder[index]);
        
        int rightLength = end - pos;
        node.right = build(postorder, index-1, inorderMap, pos+1, end);
        node.left = build(postorder, index-rightLength-1, inorderMap, start, pos-1);
        return node;
    }

    private Map<Integer, Integer> getInorderMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return map;
    }
}
