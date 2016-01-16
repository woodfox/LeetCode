package third;

import java.util.*;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        Map<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();

        List<String> result = new ArrayList<String>();
        result.addAll(generate(n, map));
        return result;
    }

    // Danger: import idea! For inner = 0..n-1 => Set of (inner) outer
    private Set<String> generate(int n, Map<Integer, Set<String>> map) {
        if(map.get(n) != null) return map.get(n);

        Set<String> set = new HashSet<String>();
        if(n == 0) {
            set.add("");
        }else{
            for(int i=0;i<n;i++){
                Set<String> inner = generate(i, map);
                Set<String> outer = generate(n-1-i, map);
                for(String l : inner) {
                    for(String r : outer) {
                        set.add("(" + l + ")" + r);
                    }
                }
            }
        }

        map.put(n, set);
        return set;
    }
}
