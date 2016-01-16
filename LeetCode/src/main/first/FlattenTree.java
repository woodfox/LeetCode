package first;
import util.TreeNode;

import java.util.ArrayList;

public class FlattenTree {
	public void flatten(TreeNode root) {
		ArrayList<TreeNode> parents = new ArrayList<TreeNode>();
		dfs(root, parents);
	}

	//Time Limit will exceed if it creates a new list to store parents
	//so use the same list to add current node for children, and then remove current node
	private void dfs(TreeNode u, ArrayList<TreeNode> p){
		if(u == null){
			return;
		}
		//ArrayList<TreeNode> n = new ArrayList<TreeNode>(p);
		p.add(u);
		dfs(u.left, p);
		dfs(u.right, p);
		p.remove(p.size()-1);
		
		if(u.left != null) {
			u.right = u.left;
		}else if(u.right == null){
			u.right = getNeighbour(u, p);
		}
		u.left = null;
	}
	
	private TreeNode getNeighbour(TreeNode u, ArrayList<TreeNode> p) {
		for(int i=p.size()-1;i>=0;i--){
			TreeNode v = p.get(i);
			if(u == v.left) {
				if(v.right != null){
					return v.right;
				}
			}
			u = v;
		}
		return null;
	}
}
