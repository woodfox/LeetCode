package third;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.

 Example: Given word = "word", return the following list (order does not matter):

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2",
 "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String w) {
        List<String> r = new ArrayList();
        if(w==null || w.length()==0) return r;

        StringBuffer sb = new StringBuffer(w);
        for(int i=0;i<=w.length();i++){
            backtrack(sb, 0, 0, i, r);
        }

        return r;
    }

    private void backtrack(StringBuffer sb, int p, int count, int total, List<String> r) {
        if(count == total) {
            add(sb, r);
        } else {
            for(int i=p;i<sb.length();i++){
                char c = sb.charAt(i);
                sb.setCharAt(i, '1');
                backtrack(sb, i+1, count+1, total, r);
                sb.setCharAt(i, c);
            }
        }
    }

    private void add(StringBuffer sb, List<String> r) {
        StringBuffer tmp = new StringBuffer();
        int n = sb.length();
        int p = 0;
        while(p < n) {
            char c = sb.charAt(p);
            if(c != '1') {
                tmp.append(c);
                p++;
            } else {
                int sum = 0;
                while(p<n && sb.charAt(p) == '1') {
                    sum++;
                    p++;
                }
                tmp.append(sum);
            }
        }
        r.add(tmp.toString());
    }
}
