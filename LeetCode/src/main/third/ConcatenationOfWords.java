package third;

import java.util.*;

public class ConcatenationOfWords {
    public List<Integer> findSubstring(String s, String[] a) {
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
