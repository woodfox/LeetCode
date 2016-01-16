package second;

import java.util.ArrayList;

public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return l;
        }
        
        if(root.left == null && root.right == null){
            if(root.val == sum){
                ArrayList<Integer>sub = new ArrayList<Integer>();
                sub.add(root.val);
                l.add(sub);
            }
        }else {
            ArrayList<ArrayList<Integer>> left = pathSum(root.left, sum-root.val);
            for(ArrayList<Integer> sub : left){
                sub.add(0, root.val);
                l.add(sub);
            }
            
            ArrayList<ArrayList<Integer>> right = pathSum(root.right, sum-root.val);
            for(ArrayList<Integer> sub : right){
                sub.add(0, root.val);
                l.add(sub);
            }
        }
        return l;
    }
}
