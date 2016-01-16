package second;

public class SortedArray2BST {
    public TreeNode sortedArrayToBST(int[] a) {
        if(a == null || a.length == 0){
            return null;
        }
        
        return convert(a, 0, a.length-1);
    }
    
    TreeNode convert(int[] a, int start, int end){
        if(start > end){
            return null;
        }
        
        int m = (start + end)/2;
        TreeNode root = new TreeNode(a[m]);
        root.left = convert(a, start, m-1);
        root.right = convert(a, m+1, end);
        return root;
    }
}
