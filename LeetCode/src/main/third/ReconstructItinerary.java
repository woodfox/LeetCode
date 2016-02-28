package third;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 Note:
 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.
 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class ReconstructItinerary {
    /**
     * Use a Map and PriorityQueue instead of building graph.
     * Be careful:
     *   1. In DFS, Add current node into result at last instead of at first, because non-loop nodes should be put at last.
     */
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap();
        for(String[] p : tickets) {
            String from = p[0];
            String to = p[1];
            if(!map.containsKey(from)) map.put(from, new PriorityQueue<String>());
            if(!map.containsKey(to)) map.put(to, new PriorityQueue<String>());
            map.get(from).add(to);
        }

        List<String> r = new ArrayList<String>();
        dfs("JFK", map, r);
        return r;
    }

    private void dfs(String s, Map<String, PriorityQueue<String>> map, List<String> r) {
        while(!map.get(s).isEmpty()) {
            String next = map.get(s).poll();
            dfs(next, map, r);
        }
        r.add(0, s);
    }

    /**
     * Build the map and DFS to go through every edges.
     * Be careful that it may go through non-loop node first, so it needs to check if there are remaining edges,
     * and add current orders at the beginning.
     *
     * Time: O(n + sortTime?)
     */
    public List<String> findItinerary_complicated(String[][] tickets) {
        Map<String, Node> map = build(tickets);

        for(Node node : map.values()) {
            Collections.sort(node.toEdges);
        }

        List<String> r = new ArrayList();
        dfs_complicated(map.get("JFK"), r);
        return r;
    }

    private void dfs_complicated(Node node, List<String> r) {
        while(!node.toEdges.isEmpty()) {
            Node next = node.toEdges.removeFirst();
            dfs_complicated(next, r);
        }
        r.add(0, node.val);
    }

    private Map<String, Node> build(String[][] a) {
        Map<String, Node> map = new HashMap();
        for(String[] t : a) {
            String from = t[0];
            String to = t[1];
            if(!map.containsKey(from)) map.put(from, new Node(from));
            if(!map.containsKey(to)) map.put(to, new Node(to));
            Node fromNode = map.get(from);
            Node toNode = map.get(to);
            // Record the edge in reverse order
            fromNode.toEdges.add(toNode);
        }

        return map;
    }

    private class Node implements Comparable<Node> {
        String val;
        LinkedList<Node> toEdges = new LinkedList();

        public Node(String s) {
            val = s;
        }

        @Override
        public int compareTo(Node o) {
            return this.val.compareTo(o.val);
        }
    }
}
