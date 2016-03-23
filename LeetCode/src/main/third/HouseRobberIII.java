package third;

import util.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
       3
      / \
     2   3
     \   \
     3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
        3
       / \
      4   5
     / \   \
    1  3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.

 */
public class HouseRobberIII {
    /**
     * DFS tree to get [a, b] of each node.
     * a is max value including current node, b is max value excluding current node.
     *
     * Time: O(n)
     */
    public int rob(TreeNode root) {
        int[] r = dfs(root);
        return Math.max(r[0], r[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root == null) return new int[] {0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int inclusive = root.val + left[1] + right[1];
        int exclusive = left[0] + right[0];

        // Inclusive should be same if exclusive is larger
        inclusive = Math.max(inclusive, exclusive);

        return new int[] {inclusive, exclusive};
    }

    /**
     * Divide and conquer (TLE exception!)
     *
     * Time: O(2*n)
     */
    public int rob_slow(TreeNode root) {
        return dfs(root, true);
    }

    private int dfs(TreeNode root, boolean self) {
        if(root == null) return 0;

        if(!self){
            return dfs(root.left, true) + dfs(root.right, true);
        } else {
            int a = root.val + dfs(root.left, false) + dfs(root.right, false);
            int b = dfs(root.left, true) + dfs(root.right, true);
            return Math.max(a, b);
        }
    }
}
