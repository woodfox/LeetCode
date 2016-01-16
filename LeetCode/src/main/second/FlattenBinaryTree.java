package second;

public class FlattenBinaryTree {
	//Limited Time Exceeded!!
    public void flatten2(TreeNode root) {
        if(root == null){
            return;
        }
        
        flatten2(root.right);
        if(root.left != null){
            flatten2(root.left);
            TreeNode end = root.left;
            while(end.right != null){
                end = end.right;
            }
            end.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
