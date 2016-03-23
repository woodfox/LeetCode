package third;

import util.DisjointSet;

import java.util.*;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
public class GraphValidTree {
    /**
     * DFS to check if all nodes are connected and there is no loop.
     *
     * Time: O(n), n = edges number.
     *
     * Be careful:
     *   1. For non-directed graph, the edge should be added for both nodes, and
     *      it should avoid visit parent node again.
     */
    public boolean validTree(int n, int[][] e) {
        if(e.length == 0) return false;

        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] a : e) {
            if(!map.containsKey(a[0])) {
                map.put(a[0], new ArrayList<Integer>());
            }
            List<Integer> l = map.get(a[0]);
            l.add(a[1]);

            // Add the opposite edge
            if(!map.containsKey(a[1])) {
                map.put(a[1], new ArrayList<Integer>());
            }
            List<Integer> l2 = map.get(a[1]);
            l2.add(a[0]);
        }

        Set<Integer> set = new HashSet();
        dfs(e[0][0], -1, set, map);
        return set.size() == n;
    }

    private boolean dfs(int p, int pre, Set<Integer> set, Map<Integer, List<Integer>> map){
        // Break dfs immediately if found loop
        if(set.contains(p)) {
            set.clear();
            return false;
        }

        set.add(p);
        for(int x : map.get(p)) {
            // Skip the parent node
            if(x == pre) continue;

            if(!dfs(x, p, set, map)) {
                return false;
            }
        }

        return true;
    }

    public boolean validTree_disjointSet(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);
        Set<Integer> visited = new HashSet();
        for(int[] edge : edges){
            if(!set.union(edge[0], edge[1])) return false;

            visited.add(edge[0]);
            visited.add(edge[1]);
        }

        return visited.size()==n;
    }
}
