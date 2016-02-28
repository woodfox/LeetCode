package third;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely. Each 1 marks a building which you cannot pass through. Each 2 marks an obstacle which you cannot pass through. For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

 Note:

 There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class ShortestBuildingDistance {
    public int shortestDistance_simple(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int[][] dist = new int[m][n];
        int[][] count = new int[m][n];

        int total = 0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j<n; j++) {
                if (a[i][j] == 1) {
                    total++;
                }
            }
        }

        for(int i=0;i<m;i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 1) {
                    // BFS
                    boolean[][] visited = new boolean[m][n];
                    LinkedList<int[]> q = new LinkedList();
                    q.add(new int[]{i, j, 0});
                    while (!q.isEmpty()) {
                        int[] node = q.removeFirst();
                        int x = node[0];
                        int y = node[1];
                        int distance = node[2];
                        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                        // a[x][y] should be 0 except the starting point
                        if(distance != 0 && a[x][y] != 0) continue;

                        int[][] rules = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
                        for (int[] rule : rules) {
                            q.add(new int[]{x + rule[0], y + rule[1], distance + 1});
                        }

                        // Add the distance and count from this building
                        visited[x][y] = true;
                        dist[x][y] += distance;
                        count[x][y]++;
                        if (count[x][y] == total) {
                            return dist[x][y];
                        }
                    }
                }
            }
        }
        return -1;
    }


    /**
     * BFS to get nodes that are visited from all buildings.
     *
     * Time:
     */
    public int shortestDistance(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        Node[][] nodes = new Node[m][n];
        LinkedList<Node> q = new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nodes[i][j] = new Node(i, j, a[i][j]);
            }
        }

        int total = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 1) {
                    total++;
                    // Initialize starting distance
                    nodes[i][j].distance.put(nodes[i][j], 0);
                    q.add(nodes[i][j]);
                }
            }
        }

        while(!q.isEmpty()) {
            LinkedList<Node> next = new LinkedList();
            while(!q.isEmpty()) {
                Node node= q.removeFirst();
                addNext(next, node, nodes);
            }

            for(Node node : next) {
                if(node.distance.size() == total) {
                    return calcDistance(node);
                }
            }

            q = next;
        }

        return -1;
    }

    private void addNext(LinkedList<Node> q, Node node, Node[][] nodes) {
        int[][] rules = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] rule: rules) {
            int x = node.x + rule[0];
            int y = node.y + rule[1];
            if(x<0 || x>=nodes.length || y<0 || y>=nodes[0].length || nodes[x][y].val != 0) {
                continue;
            }

            boolean flag = false;
            for(Node from : node.distance.keySet()) {
                if(!nodes[x][y].distance.containsKey(from)) {
                    nodes[x][y].distance.put(from, node.distance.get(from) + 1);
                    flag = true;
                }
            }
            // Already visited;  avoid dead loop
            if(flag) {
                q.addLast(nodes[x][y]);
            }
        }
    }

    private int calcDistance(Node node) {
        int sum = 0;
        for(int x : node.distance.values()) {
            sum += x;
        }
        return sum;
    }

    private class Node {
        int x;
        int y;
        int val;
        // Save distance from every starting building
        Map<Node, Integer> distance = new HashMap();

        public Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
