package third;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreInOrder {
    /**
     * Given PreOrder 1245367
     *       InOrder 4251637
     *
     * Build the tree:
     *          1
     *         / \
     *        2   3
     *       / \ / \
     *      4  5 6 7
     *
     *
     *  Starting from start of preOrder, and split by the position in inOrder
     *  Time Complexity: O(n) using inorderMap
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        Map<Integer, Integer> inorderMap = getInorderMap(inorder);
        return build(preorder, 0, inorderMap, 0, length-1);
    }

    private TreeNode build(int[] preorder, int index, Map<Integer, Integer> inorderMap, int start, int end) {
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[index]);
        //int pos = findInOrder(inorder, preorder[index], start, end);
        int pos = inorderMap.get(preorder[index]);

        int leftLength = pos - start;
        node.left = build(preorder, index+1, inorderMap, start, pos-1);
        node.right = build(preorder, index+leftLength+1, inorderMap, pos+1, end);
        return node;
    }

    private Map<Integer, Integer> getInorderMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return map;
    }

//    private int findInOrder(int[] inorder, int value, int start, int end) {
//        for(int i=start;i<=end;i++){
//            if(inorder[i] == value) return i;
//        }
//        throw new RuntimeException("Could not find " + value);
//    }
}
