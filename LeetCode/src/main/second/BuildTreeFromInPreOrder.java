package second;

public class BuildTreeFromInPreOrder {
    public TreeNode buildTree(int[] pre, int[] in){
        int n = in.length;
        if(n == 0){
            return null;
        }
        
        int p = find(in, pre[0]);
        TreeNode root = new TreeNode(pre[0]);
        if(p > 0){
            int[] leftIn = copyArray(in, 0, p-1);
            int[] leftPre = copyArray(pre, 1, p);
            root.left = buildTree(leftPre, leftIn);
        }
        
        if(p < n-1){
            int[] rightIn = copyArray(in, p+1, n-1);
            int[] rightPre = copyArray(pre, p+1, n-1);
            root.right = buildTree(rightPre, rightIn);
        }
        return root;
    }
    
    int find(int[] a, int v){
        for(int i=0;i<a.length;i++){
            if(a[i] == v){
                return i;
            }
        }
        return -1;
    }
    
    int[] copyArray(int[] a, int start, int end){
        int[] r = new int[end-start+1];
        for(int i=start;i<=end;i++){
            r[i-start] = a[i];
        }
        return r;
    }
}
