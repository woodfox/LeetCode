package first;

import util.TreeNode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return convert(num, 0, num.length-1);
    }
    
    TreeNode convert(int[] a, int start, int end){
        if(start > end){
            return null;
        }
        int m = (start + end)/2;
        TreeNode u = new TreeNode(a[m]);
        u.left = convert(a, start, m-1);
        u.right = convert(a, m+1, end);
        return u;
    }
}
