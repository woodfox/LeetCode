package second;

public class RecoverBinaryTree {
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        
        first = null;
        second = null;
        prev = null;
        
        dfs(root);
        
        if(first != null && second != null){
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
    
    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        
        dfs(root.left);
        if(prev != null){
            if(first == null){
                if(root.val < prev.val){
                    first = prev;
                    second = root;
                }
            }else if(root.val < first.val){
                second = root;
            }
        }
        prev = root;
        dfs(root.right);
    }
}
