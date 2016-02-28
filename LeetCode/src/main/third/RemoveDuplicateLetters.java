package third;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 Example:
 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"
 */
public class RemoveDuplicateLetters {
    /**
     * Divide and conqure: Find the leftmost character first and handle remaining.
     *
     * Find the minimal characters from beginning until we encounter some character that's count is 0.
     * Then call the remaining string recursively.
     *
     * Time: O(n)
     * Reference: https://www.hrwhisper.me/leetcode-remove-duplicate-letters/
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;

        Map<Character, Integer> map = count(s);
        char min = 'z'+1;
        int idx = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(min > c){
                min = c;
                idx = i;
            }

            map.put(c, map.get(c)-1);
            if(map.get(c) <= 0) break;
        }

        String next = s.substring(idx+1).replaceAll(min+"", "");
        return min + removeDuplicateLetters(next);
    }

    /**
     * Use stack to maintain the minimal string.
     * For a new character c, if c is smaller than stack peek and the count of stack peek is larger than 0 (means there are others),
     * pop from stack.
     * At last the result in stack should be reversed.
     *
     * Time: O(n)
     *
     * Reference: http://bookshadow.com/weblog/2015/12/09/leetcode-remove-duplicate-letters/
     */
    public String removeDuplicateLetters_stack(String s) {
        if (s == null || s.length() == 0) return s;

        Map<Character, Integer> map = count(s);
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            map.put(c, map.get(c)-1);
            if(stack.contains(c)) continue;

            while(!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }

    private Map<Character, Integer> count(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
        }
        return map;
    }

    /**
     * Get last positions of each character, and query the minimal characters between [start, lastPos].
     * When one min character is found, remove it from lastPosMap.
     * When start exceeds lastPos, fetch next lastPos.
     *
     * Time: O(k*k+n),  k is number of unique characters.
     */
    public String removeDuplicateLetters_complicated(String s) {
        if (s == null || s.length() == 0) return s;

        Map<Character, Integer> lastPosMap = new HashMap();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            lastPosMap.put(c, i);
        }

        int begin = 0;
        int end = getMinLastPos(lastPosMap);
        StringBuffer sb = new StringBuffer();
        int n = lastPosMap.size();
        for(int i=0;i<n;i++){
            char min = 'z'+1;
            for(int j=begin;j<=end;j++){
                char c = s.charAt(j);
                if(lastPosMap.containsKey(c) && min > c) {
                    min = c;
                    begin = j+1;
                }
            }

            lastPosMap.remove(min);
            sb.append(min);

            // If it exceeds the end, poll next minimal last shown position;
            if(s.charAt(end) == min) end = getMinLastPos(lastPosMap);
        }

        return sb.toString();
    }

    private int getMinLastPos(Map<Character, Integer> lastPosMap) {
        int min = Integer.MAX_VALUE;
        for(int x : lastPosMap.values()) {
            min = Math.min(min, x);
        }
        return min;
    }

}
