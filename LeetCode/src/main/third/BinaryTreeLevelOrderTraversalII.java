package third;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traversal(root, result, 1);
        return result;
    }

    private void traversal(TreeNode root, List<List<Integer>> result, int level) {
        if(root == null) return;

        if(level > result.size()) {
            result.add(0, new ArrayList<Integer>());
        }

        List<Integer> nodes = result.get(result.size() - level);
        nodes.add(root.val);

        traversal(root.left, result, level+1);
        traversal(root.right, result, level+1);
    }
}
