package other;

public class KmpSearch {
    /**
     * Prefix array starts from 0
     */
    public int search(String s, String t) {
        int[] p = calcPrefix(t);

        int i = 0;
        int j = 0;
        while(i<s.length() && j<t.length()) {
            while(j>0 && s.charAt(i) != t.charAt(j)){
                j = p[j-1];
            }

            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else {
                i++;
            }
        }

        if(j==t.length()){
            return i-j;
        } else {
            return -1;
        }
    }

    private int[] calcPrefix(String t){
        int[] p = new int[t.length()];
        p[0] = 0;
        for(int i=1;i<p.length;i++) {
            int k = p[i-1];
            while(k > 0 && t.charAt(i) != t.charAt(k)) {
                k = p[k-1];
            }
            if(t.charAt(i) == t.charAt(k)) {
                p[i] = k + 1;
            } else {
                p[i] = k;
            }
        }
        return p;
    }

    /**
     * Prefix array starts from -1
     */
    public int search_another(String s, String p) {
        if(s == null || p == null || s.length() < p.length()) {
            return -1;
        }

        int[] next = calcNext(p);
        int i = 0;
        int j = 0;
        while(i < s.length() && j < p.length()) {
            if(j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if(j == p.length()) {
            return i-j;
        } else {
            return -1;
        }
    }

    public int[] calcNext(String p) {
        int n = p.length();
        int[] next = new int[n];
        next[0] = -1;
        int k = -1;
        int i=0;
        while(i < n-1) {
            if(k == -1 || p.charAt(i) == p.charAt(k)) {
                k++;
                i++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }

    public int[] calcNextByPrefix(String p) {
        int n = p.length();
        int[] next = new int[n];

        next[0] = 0;
        for(int i=1;i<n;i++) {
            int k = next[i-1];
            while(k > 0 && p.charAt(i) != p.charAt(k)) {
                k = next[k-1];
            }

            if(p.charAt(i) == p.charAt(k)) {
                next[i] = k + 1;
            } else {
                next[i] = k;
            }
        }

        for(int i=n-1;i>0;i--) {
            next[i] = next[i-1];
        }
        next[0] = -1;

        return next;
    }
}
