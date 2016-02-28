package third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Follow up: what if this method is called multiple times?
 */
public class ShortestWordDistanceII {
    /**
     * Reuse a map to record string positions.
     */
    int shortestDistance(List<String> l, String s, String t) {
        // Initialize positions of strings
        Map<String, List<Integer>> map = new HashMap();
        for(int i=0;i<l.size();i++) {
            List<Integer> pos = map.get(l.get(i));
            if(pos == null) {
                pos = new ArrayList();
                map.put(l.get(i), pos);
            }
            pos.add(i);
        }

        List<Integer> list1 = map.get(s);
        List<Integer> list2 = map.get(t);
        int pos1 = 0;
        int pos2 = 0;
        int dist = Integer.MAX_VALUE;
        while(pos1 < list1.size() && pos2 < list2.size()) {
            int p = list1.get(pos1);
            int q = list2.get(pos2);
            dist = Math.min(dist, Math.abs(p - q));

            if(p <= q) {
                pos1++;
            } else {
                pos2++;
            }
        }

        return dist;
    }
}
