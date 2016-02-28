package third;

import java.util.List;

public class ShortestWordDistanceIII {
    int shortestDistance(List<String> l, String s, String t) {
        int p1 = -1;
        int p2 = -1;
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<l.size();i++) {
            String x = l.get(i);
            if(s.equals(t)) {
                if(s.equals(x)) {
                    // Always increase the smaller one
                    if(p1 < p2) {
                        p1 = i;
                    } else {
                        p2 = i;
                    }
                }
            } else {
                if(s.equals(x)) p1 = i;
                if(t.equals(x)) p2 = i;
            }

            if(p1 >= 0 && p2 >= 0) {
                dist = Math.min(dist, Math.abs(p2 - p1));
            }
        }

        return dist;
    }
}
