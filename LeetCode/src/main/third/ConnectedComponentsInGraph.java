package third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

 Example 1:

 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:

 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class ConnectedComponentsInGraph {
    /**
     * DFS to remove connected nodes.
     *
     * Time: O(n+e)
     */
    public int connectedComponents(int n, int[][] edges) {
        Map<Integer, Node> map = build(n, edges);

        int total = 0;
        for(Node node : map.values()) {
            if(!node.visited) {
                total++;
                dfs(node);
            }
        }
        return total;
    }

    private void dfs(Node node) {
        node.visited = true;
        for(Node child : node.adj) {
            if(!child.visited) dfs(child);
        }
    }

    private Map<Integer, Node> build(int n, int[][] edges) {
        Map<Integer, Node> map = new HashMap();
        for(int i=0;i<n;i++) map.put(i, new Node(i));

        for(int[] edge: edges) {
            Node from = map.get(edge[0]);
            Node to = map.get(edge[1]);
            from.adj.add(to);
            to.adj.add(from);
        }

        return map;
    }

    private class Node {
        int val;
        List<Node> adj = new ArrayList();
        boolean visited = false;

        public Node(int v) {
            val = v;
        }
    }
}
