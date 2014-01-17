package second;

import java.util.ArrayList;

public class UniqueBSTII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return create(1, n);
    }
    
    ArrayList<TreeNode> create(int start, int end){
        ArrayList<TreeNode> r = new ArrayList<TreeNode>();
        if(start > end){
            r.add(null);
            return r;
        }
        
        for(int i=start;i<=end;i++){
            ArrayList<TreeNode> left = create(start, i-1);
            ArrayList<TreeNode> right = create(i+1, end);
            for(TreeNode u : left){
                for(TreeNode v : right){
                    TreeNode root = new TreeNode(i);
                    root.left = u;
                    root.right = v;
                    r.add(root);
                }
            }
        }
        
        return r;
    }
}
