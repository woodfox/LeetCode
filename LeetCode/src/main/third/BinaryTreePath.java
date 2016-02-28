package third;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> r = new ArrayList();
        if(root == null) return r;

        List<TreeNode> sub = new ArrayList();
        dfs(root, sub, r);

        return r;
    }

    void dfs(TreeNode root, List<TreeNode> sub, List<String> r) {
        // Add root into the current path
        sub.add(root);

        if(root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for(TreeNode node : sub) {
                sb.append(node.val + "->");
            }
            r.add(sb.substring(0, sb.length()-2));
        } else {
            if(root.left != null) {
                dfs(root.left, sub, r);
            }
            if(root.right != null) {
                dfs(root.right, sub, r);
            }
        }

        // Remove root from path at last
        sub.remove(sub.size()-1);
    }
}
