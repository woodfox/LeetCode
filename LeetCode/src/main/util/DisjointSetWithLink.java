package util;

/**
 * Disjoint set using link is more dynamic than using array to record parents.
 */
public class DisjointSetWithLink {
    // Return true if union two nodes in different set;
    // otherwise return false if in same set;
    public boolean union(DisjointNode x, DisjointNode y) {
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
    private class DisjointNode {
        DisjointNode parent;
        int rank = 0;

        public DisjointNode() {
            parent = this;
        }
    }
}
