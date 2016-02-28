package third;

import util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    /**
     * DFS go through the graph, and clone every node and its neighbors (and single edge).
     *
     * Time: O(n)
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        if(node == null) {
            return null;
        }

        return copyNode(node, map);
    }

    private UndirectedGraphNode copyNode(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode newNode = map.get(node);
        if (newNode == null) {
            newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);

            // Only clone its neighbors if it's not visited before
            for(UndirectedGraphNode neighbor: node.neighbors) {
                newNode.neighbors.add(copyNode(neighbor, map));
            }
        }
        return newNode;
    }
}
