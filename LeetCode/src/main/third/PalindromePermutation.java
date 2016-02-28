package third;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
    boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet();
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        int n = s.length();
        if(n%2 == 0){
            return set.isEmpty();
        } else {
            return set.size() <= 1;
        }
    }
}
