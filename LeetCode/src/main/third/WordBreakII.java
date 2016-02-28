package third;

import java.util.*;

public class WordBreakII {
    /**
     *  Improve with cutting edges.
     *  Time: O(2^n)
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return result;
        }

        // unmatched set to remember failed strings
        Set<String> unmatched = new HashSet<String>();

        List<String> sub = new ArrayList<String>();
        backtrack(s, 0, wordDict, sub, result, unmatched);

        return result;
    }

    private boolean backtrack(String s, int pos, Set<String> wordDict, List<String> sub, List<String> result, Set<String> unmatched) {
        if(pos >= s.length()) {
            StringBuffer sb = new StringBuffer();
            for (String t : sub) {
                sb.append(t + " ");
            }
            result.add(sb.substring(0, sb.length() - 1));

            return true;
        } else if(unmatched.contains(s.substring(pos))) {
            // If the remaining string already unmatched before, just ignore it
            return false;
        } else {
            boolean flag = false;
            for(int i=pos;i<s.length();i++) {
                String t = s.substring(pos, i+1);
                if(wordDict.contains(t)) {
                    sub.add(t);
                    flag |= backtrack(s, i+1, wordDict, sub, result, unmatched);
                    sub.remove(sub.size() -1);
                }
            }

            if(!flag) {
                unmatched.add(s.substring(pos));
            }
            return flag;
        }
    }
}
