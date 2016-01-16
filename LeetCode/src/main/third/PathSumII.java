package third;

import second.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: O(N)
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();

        checkPathSum(root, sum, sub, result);

        return result;
    }

    private void checkPathSum(TreeNode root, int sum, List<Integer> sub, List<List<Integer>> result) {
        if(root == null) {
            return;
        } else if(root.val == sum && root.left == null && root.right == null) {
            sub.add(root.val);
            result.add(new ArrayList<Integer>(sub));
            sub.remove(sub.size() - 1);
        } else {
            sub.add(root.val);
            checkPathSum(root.left, sum - root.val, sub, result);
            checkPathSum(root.right, sum - root.val, sub, result);
            sub.remove(sub.size() - 1);
        }
    }
}
