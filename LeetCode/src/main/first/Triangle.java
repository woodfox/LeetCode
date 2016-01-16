package first;
import java.util.ArrayList;

public class Triangle {
	//Divide and conque with time complexisity O(n^2)
	//and space complexisity O(n)
	public int minimumTotal(ArrayList<ArrayList<Integer>> t) {
		int n = t.size();
		if(n == 0){
			return 0;
		}
		
		int[] a = minSubPathSum(t, n -1);
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if(min > a[i]){
				min = a[i];
			}
		}
		return min;
	}
	
	int[] minSubPathSum(ArrayList<ArrayList<Integer>> t, int k){
		int[] a = new int[k+1];
		for(int i=0;i<=k;i++){
			a[i] = Integer.MAX_VALUE;
		}
		
		ArrayList<Integer> row = t.get(k);
		if(k == 0){
			a[0] = row.get(0);
		}else {
			int[] b = minSubPathSum(t, k-1);
			for(int i=0;i<=k-1;i++){
				int l = b[i] + row.get(i);
				int r = b[i] + row.get(i+1);
				a[i] = Math.min(a[i], l);
				a[i+1] = Math.min(a[i+1], r);
			}
		}
		
		return a;
	}
	
	//Construct the graph with all path and dfs the grapt
	//Time complexisity is O(n^2), while space complexisity is O(n^2)
	//It will throw Time Limited Error for large data set
	public int minimumTotal2(ArrayList<ArrayList<Integer>> t) {
		if(t.size() == 0){
			return 0;
		}
		
		Node[][] g = new Node[t.size()][t.size()];
		for(int i=t.size()-1;i>=0;i--){
			ArrayList<Integer> row = t.get(i);
			for(int j=0;j<=i;j++){
				g[i][j] = new Node(row.get(j));
				if(i < t.size() -1){
					g[i][j].left = g[i+1][j];
					g[i][j].right = g[i+1][j+1];
				}
			}
		}
		g[0][0].sum = g[0][0].value;
		return dfs(g[0][0]);
	}
	
	int dfs(Node u){
		if(u.left == null && u.right == null){
			return u.sum;
		}
		u.left.sum = u.sum + u.left.value;
		u.right.sum = u.sum + u.right.value;
		int l = dfs(u.left);
		int r = dfs(u.right);
		
		return Math.min(l, r);
	}
	
	class Node {
		int value;
		int sum;
		Node left;
		Node right;
		
		public Node(int v){
			value = v;
		}
	}
}