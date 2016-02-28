package first;

import java.util.HashMap;
import util.UndirectedGraphNode;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        // Note: The Solution object is instantiated only once and is reused
			// by each test case.
	        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	        if(node == null){
	            return null;
	        }
	        
	        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
	        map.put(node, newNode);
	        dfs(node, map);
	        return newNode;
	    }

	private void dfs(UndirectedGraphNode oldNode,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		UndirectedGraphNode newNode = map.get(oldNode);
		for (UndirectedGraphNode oldAdj : oldNode.neighbors) {
			UndirectedGraphNode newAdj = map.get(oldAdj);
			if (newAdj == null) {
				newAdj = new UndirectedGraphNode(oldAdj.label);
				map.put(oldAdj, newAdj);
				dfs(oldAdj, map);
			}
			newNode.neighbors.add(newAdj);
		}
	}
}
