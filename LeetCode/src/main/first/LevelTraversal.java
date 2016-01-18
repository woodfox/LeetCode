package first;

import util.TreeNode;

import java.util.ArrayList;


public class LevelTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		dfs(root, 0, result);
        return result;
    }
    
    void dfs(TreeNode u, int level, ArrayList<ArrayList<Integer>> result) {
    	if (u == null) {
			return;
		}
		if (result.size() < level + 1) {
			result.add(new ArrayList<Integer>());
		}
		ArrayList<Integer> l = result.get(level);
		l.add(u.val);
		dfs(u.left, level + 1, result);
		dfs(u.right, level + 1, result);
	}
}
