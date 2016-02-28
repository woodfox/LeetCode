package third;

import util.TreeNode;

import java.util.*;

public class BinaryTreeVerticalTraversal {
    List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap();
        dfs(root, 0, map);

        TreeSet<Integer> keys = new TreeSet(map.keySet());
        for(int x: keys) {
            r.add(map.get(x));
        }
        return r;
    }

    private void dfs(TreeNode root, int col, Map<Integer, List<Integer>> map) {
        if(root == null) return;
        if(!map.containsKey(col)) {
            map.put(col, new ArrayList<Integer>());
        }
        List<Integer> l = map.get(col);
        l.add(root.val);

        dfs(root.left, col-1, map);
        dfs(root.right, col+1, map);
    }
}
