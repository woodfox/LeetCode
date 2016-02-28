package third;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */
public class BinaryTreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        visitNode(root, 1, result);
        return result;
    }

    private void visitNode(TreeNode root, int depth, List<Integer> result) {
        if(root == null) {
            return;
        }

        if(result.size() < depth) {
            result.add(root.val);
        }

        visitNode(root.right, depth+1, result);
        visitNode(root.left, depth+1, result);
    }

}
