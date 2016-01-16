package first;
import java.util.ArrayList;
import java.util.HashMap;

public class GrayCode {
	//Unable to generate same results with OJ 
	//due to different dfs order
	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Node root = buildGraph(n);
		ArrayList<Integer> result = new ArrayList<Integer>();
		dfs(root, result);
		return result;
	}

	void dfs(Node root, ArrayList<Integer> result) {
		result.add(root.val);
		root.visited = true;

		for (Node u : root.adj) {
			if (u.visited == false) {
				dfs(u, result);
				break;
			}
		}
	}

	Node buildGraph(int n) {
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		for (int i = 0; i < Math.pow(2, n); i++) {
			map.put(i, new Node(i));
		}
		for (int i = 0; i < Math.pow(2, n) - 1; i++) {
			Node u = map.get(i);
			for (Node v : getNeighbour(i, n, map)) {
				u.adj.add(v);
				v.adj.add(u);
			}
		}
		return map.get(0);
	}

	ArrayList<Node> getNeighbour(int i, int n, HashMap<Integer, Node> map){
	        ArrayList<Node> l = new ArrayList<Node>();
	        for(int j=0;j<n;j++){
	            int k = 1<<j;
	            if((i&k) == 0){
	                Node u = map.get((i|k));
	                l.add(u);
	            }
	        }
	        return l;
	    }

	class Node {
		int val;
		boolean visited = false;
		ArrayList<Node> adj = new ArrayList<Node>();

		public Node(int v) {
			val = v;
		}
	}
}
