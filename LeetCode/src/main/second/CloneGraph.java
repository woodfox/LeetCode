package second;

import util.UndirectedGraphNode;

import java.util.HashMap;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// Note: The Solution object is instantiated only once and is reused
		// by each test case.
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		if (node == null) {
			return null;
		}
		return copyNode(node, map);
	}

	UndirectedGraphNode copyNode(UndirectedGraphNode old,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		UndirectedGraphNode node = map.get(old);
		if (node == null) {
			node = new UndirectedGraphNode(old.label);
			map.put(old, node);
			for (UndirectedGraphNode w : old.neighbors) {
				node.neighbors.add(copyNode(w, map));
			}
		}
		return node;
	}
}
