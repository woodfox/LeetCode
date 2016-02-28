package util;

import java.util.ArrayList;

public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UndirectedGraphNode))
            return false;
        if (obj == this)
            return true;

        UndirectedGraphNode a = (UndirectedGraphNode)obj;
        if(a.label != this.label){
            return false;
        } else {
            int m = this.neighbors.size();
            int n = a.neighbors.size();
            if(m != n) {
                return false;
            } else {
                for(int i=0;i<m;i++){
                    UndirectedGraphNode x = this.neighbors.get(i);
                    UndirectedGraphNode y = a.neighbors.get(i);
                    if(!x.equals(y)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}