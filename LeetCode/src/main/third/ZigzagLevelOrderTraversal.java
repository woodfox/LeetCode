package third;

import second.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traversal(root, result, 1);
        return result;
    }

    private void traversal(TreeNode root, List<List<Integer>> result, int level) {
        if(root == null) return;

        if(level > result.size()) {
            result.add(new ArrayList<Integer>());
        }

        List<Integer> nodes = result.get(level - 1);
        if(level%2 == 1) {
            nodes.add(root.val);
        } else {
            nodes.add(0, root.val);
        }

        traversal(root.left, result, level + 1);
        traversal(root.right, result, level + 1);
    }
}
