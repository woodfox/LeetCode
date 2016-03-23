package util;

public class DisjointSet {
    int[] parents;
    int[] rank;

    public DisjointSet(int n) {
        parents = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * Time: O(logn)
     */
    public int find(int x) {
        if(parents[x] == x) {
            return x;
        } else {
            // Update the parent link
            int p = find(parents[x]);
            parents[x] = p;
            return p;
        }
    }

    /**
     * Union two sub tree as balanced tree.
     *
     * Time: O(logn)
     */
    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return false;

        if(rank[x] < rank[y]) {
            parents[x] = y;
        } else {
            parents[y] = x;
            if(rank[x] == rank[y]) rank[x]++;
        }
        return true;
    }
}
