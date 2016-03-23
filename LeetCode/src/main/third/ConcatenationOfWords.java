package third;

import java.util.*;

public class ConcatenationOfWords {
    /**
     * Starting from 0..k-1, moving window to find starting positions that contains all words in dict.
     *
     * Time: O(n)
     */
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        List<Integer> r = new ArrayList();
        if (n == 0 || words.length == 0) return r;

        int k = words[0].length();
        int m = words.length;
        Map<String, Integer> map = count(words);
        for(int i=0;i<k;i++){
            Map<String, Integer> current = new HashMap();
            int start = i;
            int end = i;
            int added = 0;
            while(end+k<=n){
                String t = s.substring(end, end+k);
                if(!map.containsKey(t)) {
                    // Found invalid string, restart from next position
                    current.clear();
                    end += k;
                    start = end;
                    added = 0;
                } else if(current.containsKey(t) && current.get(t) >= map.get(t)) {
                    // can not add new string anymore, move start
                    String tmp = s.substring(start, start+k);
                    current.put(tmp, current.get(tmp)-1);
                    added--;
                    start += k;
                } else {
                    // Can add new strings, move end
                    if(!current.containsKey(t)) current.put(t, 0);
                    current.put(t, current.get(t)+1);
                    added++;
                    end += k;

                    // If added all words, save starting position
                    if(added == m) {
                        r.add(start);
                    }
                }
            }
        }

        return r;
    }

    private Map<String, Integer> count(String[] words) {
        Map<String, Integer> map = new HashMap();
        for(String s : words) {
            if(!map.containsKey(s)) map.put(s, 0);
            map.put(s, map.get(s)+1);
        }
        return map;
    }

    /**
     * Use HashMap to check if substring is in the list (set doesn't work for duplicated strings).
     * Still TLE...
     *
     * Time: O(m*n)
     */
    public List<Integer> findSubstring_slow(String s, String[] words) {
        int n = s.length();
        List<Integer> r = new ArrayList();
        if(n==0 || words.length==0) return r;

        int k = words[0].length();
        int m = words.length;
        Map<String, Integer> map = count(words);
        for(int i=0;i+k*m<=n;i++){
            Map<String, Integer> dup = new HashMap(map);
            int pos = i;
            for(int j=0;j<m;j++){
                String t = s.substring(pos, pos+k);
                if(!dup.containsKey(t) || map.get(t)<=0) break;

                dup.put(t, map.get(t)-1);
                pos = pos + k;
            }

            if(pos==i+k*m) r.add(i);
        }

        return r;
    }

    // Time Limit Exceed!
    public List<Integer> findSubstring_complex(String s, String[] a) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || a == null || a.length == 0) return result;

        List<String> original = new ArrayList<String>();
        original.addAll(Arrays.asList(a));
        Collections.sort(original);

        int length = a[0].length();
        int m = s.length();
        int n = a.length;
        for(int i=0;i<=m-n*length;i++){
            List<String> list = new ArrayList<String>();

            for(int j=0;j<n;j++){
                String t = s.substring(i+j*length, i+j*length+length);
                list.add(t);
            }
            Collections.sort(list);
            if(compareList(original, list)){
                result.add(i);
            }
        }

        return result;
    }

    private boolean compareList(List<String> a, List<String> b) {
        if(a.size() != b.size()) return false;
        for(int i=0;i<a.size();i++){
            if(!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }
}
