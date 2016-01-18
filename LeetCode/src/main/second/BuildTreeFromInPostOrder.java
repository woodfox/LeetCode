package second;

import util.TreeNode;

public class BuildTreeFromInPostOrder {
    public TreeNode buildTree(int[] in, int[] post) {
        int n = in.length;
        if(n == 0){
            return null;
        }
        
        int p = find(in, post[n-1]);
        TreeNode root = new TreeNode(post[n-1]);
        if(p > 0){
            int[] leftIn = copyArray(in, 0, p-1);
            int[] leftPost = copyArray(post, 0, p-1);
            root.left = buildTree(leftIn, leftPost);
        }
        
        if(p < n-1){
            int[] rightIn = copyArray(in, p+1, n-1);
            int[] rightPost = copyArray(post, p, n-2);
            root.right = buildTree(rightIn, rightPost);
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
    
    public static void main(String[] args){
    	BuildTreeFromInPostOrder b = new BuildTreeFromInPostOrder();
    	int[] in = {2,3,1};
    	int[] post = {3,2,1};
    	b.buildTree(in, post);
    }
}
