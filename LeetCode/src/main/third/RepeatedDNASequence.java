package third;

import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequence {
    /**
     * Use a map to record the substring and starting positions.
     * If duplicated string are found, add into the result.
     * Seems it doesn't care about overlap!!
     *
     * Time: O(n)
     *
     * Be careful:
     *  1. Do not add duplicated substring!
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        if (s == null || s.length() < 10) {
            return new ArrayList<String>();
        }

        int minOverlap = 1;
        int n = s.length();
        for(int i=0;i+10<=n;i++) {
            String t = s.substring(i, i+10);
            if(!map.containsKey(t)) {
                // Put new string and its starting position
                map.put(t, i);
            } else {
                int pos = map.get(t);
                if(i - pos >= minOverlap) {
                    // No overlap found for two duplicated string!
                    result.add(t);
                }
            }
        }

        return new ArrayList(result);
    }

    /**
     * Brute force way to find out repeated string.
     * Time: O(n*n*10) = O(n^2)
     */
    public List<String> findRepeatedDnaSequences_slow(String s) {
        Set<String> repeated = new HashSet<String>();
        Set<String> unmatched = new HashSet<String>();
        if(s == null || s.length() < 20) {
            return new ArrayList<String>();
        }

        int n = s.length();
        for(int i=0;i+20<=n;i++) {
            String t = s.substring(i, i+10);
            if(repeated.contains(t)) {
                continue;
            }
            if(unmatched.contains(t)) {
                continue;
            }

            String remain = s.substring(i+10);
            if(remain.contains(t)) {
                repeated.add(t);
            } else {
                unmatched.add(t);
            }
        }

        return new ArrayList(repeated);
    }
}
