package third;

import java.util.*;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]

 Note:

 (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

 (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTree {
    /**
     * Similar with topological sort, try to remove nodes with degree 1 together and add new nodes until there are only two left.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Node> map = build(n, edges);
        LinkedList<Node> q = new LinkedList<Node>();
        for(Node node : map.values()) {
            // If only one node, the degree is 0
            if(node.degree <= 1) {
                q.add(node);
            }
        }

        int total = n;
        while(total > 2) {
            // Have to remove all outside nodes together and add inner nodes into queue
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node node = q.removeFirst();
                total--;

                for (Node child : node.adj) {
                    child.degree--;
                    if (child.degree == 1) {
                        q.add(child);
                    }
                }
            }
        }

        List<Integer> r = new ArrayList();
        while(!q.isEmpty()) {
            r.add(q.removeFirst().val);
        }
        return r;
    }

    private Map<Integer, Node> build(int n, int[][] edges) {
        Map<Integer, Node> map = new HashMap();
        for(int i=0;i<n;i++){
            map.put(i, new Node(i));
        }

        for(int[] e: edges) {
            Node a = map.get(e[0]);
            Node b = map.get(e[1]);
            a.adj.add(b);
            a.degree++;
            b.adj.add(a);
            b.degree++;
        }
        return map;
    }

    class Node {
        int val;
        List<Node> adj = new ArrayList<Node>();
        int degree = 0;

        public Node(int x) {
            val = x;
        }
    }

    /**
     * ----------------------------------------------------------
     * DFS to find minimum depth.  Time Limit Exceed!
     *
     * Time: O(n^2)
     *
     * Be careful:
     *  1. Can not visit parent node again to avoid dead loop!
     */
    public List<Integer> findMinHeightTrees_slow(int n, int[][] edges) {
        Map<Integer, Node> map = build(n, edges);
        List<Integer> r = new ArrayList();

        int minDepth = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int depth = dfs(map.get(i), null);
            if(depth < minDepth) {
                minDepth = depth;
                r = new ArrayList();
                r.add(i);
            } else if(depth == minDepth) {
                r.add(i);
            }
        }
        return r;
    }

    private int dfs(Node root, Node parent) {
        int depth = 0;
        for(Node child: root.adj) {
            if(child != parent) {
                depth = Math.max(depth, dfs(child, root));
            }
        }
        return depth+1;
    }
}
