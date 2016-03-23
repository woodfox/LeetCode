package other;

import util.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)

 Example
 Given graph:

        A ---- B      C ---- E
         \    /
          \  /
            D


 Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

 */
public class FindConnectedComponents {
    public Set<Set<UndirectedGraphNode>> connectedSet(Set<UndirectedGraphNode> nodes) {
        Set<Set<UndirectedGraphNode>> r = new HashSet();
        Set<UndirectedGraphNode> visited = new HashSet();
        for(UndirectedGraphNode node : nodes) {
            if(!visited.contains(node)) {
                Set<UndirectedGraphNode> sub = new HashSet();
                dfs(node, sub, visited);
                r.add(sub);
            }
        }
        return r;
    }

    private void dfs(UndirectedGraphNode node, Set<UndirectedGraphNode> sub, Set<UndirectedGraphNode> visited) {
        sub.add(node);
        visited.add(node);
        for(UndirectedGraphNode adj : node.neighbors) {
            if(!visited.contains(adj)) {
                dfs(adj, sub, visited);
            }
        }
    }
}
