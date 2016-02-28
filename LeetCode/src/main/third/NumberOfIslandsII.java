package third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]. Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0
 We return the result as an array: [1, 1, 2, 3]

 Note 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 */
public class NumberOfIslandsII {
    /**
     * Slow way is to check how many islands using DFS every time when setting a position.
     * Another way is keep the number of islands and their positions in map. When setting new positions, it check the surrounding islands
     * and merge them to one with new id, and update the map.
     *
     * Time: O(n*n), the find/union operation could be improved to (logn)
     */
    List<Integer> numIslands2(int m, int n, List<int[]> p) {
        List<Integer> r = new ArrayList();
        if(m ==0 || n == 0) return r;

        int[][] a = new int[m][n];
        Map<Integer, List<int[]>> map = new HashMap();
        for(int i=0;i<p.size();i++){
            int[] pos = p.get(i);
            List<int[]> l = new ArrayList();
            l.add(pos);

            // Merge islands into one in map if found nearby
            int[][] rules = {{-1,0},{1,0},{0,-1},{0,1}};
            for(int[] rule: rules) {
                int x = pos[0] + rule[0];
                int y = pos[1] + rule[1];
                if(x>=0 && x<m && y>=0 && y<n && map.containsKey(a[x][y])) {
                    l.addAll(map.get(a[x][y]));
                    map.remove(a[x][y]);
                }
            }

            // Set the island number for all positions
            for(int[] q : l) {
                int x = q[0];
                int y = q[1];
                a[x][y] = i+1;
            }
            map.put(i+1, l);

            // Map size is the total islands
            r.add(map.size());
        }

        return r;
    }

    //-------------------------------------------------------
    // Use Disjoint Set to improve find/union operation
    // Time: O(n*lgn) since disjoint tree is balance
    List<Integer> numIslands2_faster(int m, int n, List<int[]> p) {
        List<Integer> r = new ArrayList();
        if(m ==0 || n == 0) return r;

        int[][] a = new int[m][n];
        DisjointNode[][] nodes = new DisjointNode[m][n];
        int islands = 0;
        for(int i=0;i<p.size();i++){
            int[] pos = p.get(i);
            int x = pos[0];
            int y = pos[1];

            nodes[x][y] = new DisjointNode();
            islands++;

            // Merge islands into one in map if found nearby
            int[][] rules = {{x-1,y},{x+1,y},{x,y-1},{x,y+1}};
            for(int[] rule: rules) {
                int nextX = rule[0];
                int nextY = rule[1];
                if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && nodes[nextX][nextY] != null) {
                    // If nodes are merged into one set, then remove islands total.
                    if(UnionNodes(nodes[x][y], nodes[nextX][nextY])) {
                        islands--;
                    }
                }
            }

            r.add(islands);
        }

        return r;
    }

    // Return true if union two nodes in different set;
    // otherwise return false if in same set;
    public boolean UnionNodes(DisjointNode x, DisjointNode y) {
        DisjointNode r1 = find(x);
        DisjointNode r2 = find(y);
        if(r1 == r2) {
            return false;
        } else {
            if(r1.rank > r2.rank){
                r2.parent = r1;
            } else {
                r1.parent = r2;
                if(r1.rank == r2.rank) r2.rank++;
            }
            return true;
        }
    }

    // Find parent for one node
    public DisjointNode find(DisjointNode x) {
        while(x != x.parent) {
            x = x.parent;
        }
        return x;
    }

    // Rand is used to balance the tree; otherwise it's same as linked list
    class DisjointNode {
        DisjointNode parent;
        int rank = 0;

        public DisjointNode() {
            parent = this;
        }
    }
}
