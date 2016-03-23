package third;

import java.util.*;

public class WordLadderII {
    /**
     *  Use implicit graph dfs to find min path to endWord (but it's slower to save whole path in queue).
     *  The key is remove visiting words from wordList to avoid dead loop.
     *  Be careful:
     *    1. Should allow multiple access on one node before it's visited!!
     *    2. Should only fetch path with min depth!!
     */
    public List<List<String>> findLadders_slow(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(beginWord.equals(endWord)) {
            result.add(Arrays.asList(beginWord));
            return result;
        }

        LinkedList<List<String>> queue = new LinkedList<List<String>>();
        List<String> path = Arrays.asList(beginWord);
        queue.add(path);

        wordList.add(endWord);
        // Remove beginWord from wordList to avoid visiting again
        wordList.remove(beginWord);

        int minDepth = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            List<String> list = queue.removeFirst();

            if(list.size() >= minDepth) {
                break;
            }

            String source = list.get(list.size() - 1);
            // Remove word from wordList to avoid dead loop
            // Should allow multiple access on one node before it's visited!!
            wordList.remove(source);

            for(String dest : transform(source, wordList)) {
                List<String> newList = new ArrayList<String>(list);
                newList.add(dest);

                if(dest.equals(endWord)) {
                    minDepth = newList.size();
                    result.add(newList);
                } else {
                    queue.add(newList);
                }
            }
        }
        return result;
    }

    private Set<String> transform(String s, Set<String> wordList) {
        Set<String> result = new HashSet<String>();

        StringBuffer sb = new StringBuffer(s);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            for(char d='a';d<='z';d++) {
                if(c == d) continue;

                sb.setCharAt(i, d);
                String t = sb.toString();
                if(wordList.contains(t)) {
                    result.add(t);
                }
            }

            // Restore character
            sb.setCharAt(i, c);
        }

        return result;
    }


    /** --------------------------------------------------------------------
     * Use Graph Node to record parents instead of copying whole path.
     *
     * Performance note:
     *   1. Do not add visited node again
     *   2. Save parent pointer
     */
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        wordList.add(beginWord);
        Map<String, Node> map = buildGraph(wordList);

        Node start = map.get(beginWord);
        Node end = map.get(endWord);
        LinkedList<Node> queue = new LinkedList<Node>();
        // Set start depth to non-zero, so that it will not be visited again!!!
        start.depth = 1;
        queue.add(start);

        int minDepth = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Node node = queue.removeFirst();

            if(node == end) {
                minDepth = node.depth;
            } else if(node.depth >= minDepth) {
                continue;
            } else {
                for (Node next : node.adj) {
                    // Only visit one node if it's not visited yet
                    if(next.depth == 0) {
                        queue.add(next);
                    }
                    // Only setup path for one node if it's not visited yet OR it's visited in same level
                    if(next.depth == 0 || next.depth == node.depth + 1) {
                        next.depth = node.depth + 1;
                        next.parents.add(node);
                    }
                }
            }
        }

        // Get paths at last!!
        return getLadder(end, start);
    }

    private Map<String, Node> buildGraph(Set<String> wordList) {
        Map<String, Node> map = new HashMap<String, Node>();
        for(String s: wordList) {
            map.put(s, new Node(s));
        }

        for(String s: map.keySet()) {
            Node source = map.get(s);
            for(String t: transform(s, wordList)) {
                Node dest = map.get(t);
                source.adj.add(dest);
                dest.adj.add(source);
            }

            // Remove from wordList to avoid deadloop
            wordList.remove(s);
        }
        return map;
    }

    // Get path from bottom to top
    List<List<String>> getLadder(Node end, Node start) {
        List<List<String>> r = new ArrayList<List<String>>();
        if (end == start) {
            ArrayList<String> sub = new ArrayList<String>();
            sub.add(start.word);
            r.add(sub);
        } else {
            for (Node p : end.parents) {
                for (List<String> sub : getLadder(p, start)) {
                    sub.add(end.word);
                    r.add(sub);
                }
            }
        }
        return r;
    }

    private class Node {
        String word;
        int depth = 0;
        List<Node> adj = new ArrayList<Node>();
        List<Node> parents = new ArrayList<Node>();

        public Node(String w) {
            this.word = w;
        }
    }

    /**
     * -------------------------------------------------------------
     * Use Map to save parents, so do not need to build graph
     */
    public List<List<String>> findLadders_map(String begin, String end, Set<String> dict) {
        dict.remove(begin);
        dict.add(end);
        LinkedList<String> q1 = new LinkedList();
        LinkedList<Integer> q2 = new LinkedList();
        q1.add(begin);
        q2.add(1);

        Map<String, List<String>> map = new HashMap();
        map.put(begin, new ArrayList<String>());

        Map<String, Integer> lengthMap = new HashMap();
        while(!q1.isEmpty()){
            String s = q1.removeFirst();
            int len = q2.removeFirst();

            if(s.equals(end)) {
                break;
            }

            for(String t : getCandidates(s, dict)){
                // Allow multiple access on same node if in same level
                if(!lengthMap.containsKey(t)) {
                    lengthMap.put(t, len+1);

                    // Only add this node at the first time! Otherwise will TLE
                    q1.add(t);
                    q2.add(len+1);
                } else if(len+1 > lengthMap.get(t)) {
                    dict.remove(t);
                    continue;
                }

                if(!map.containsKey(t)) map.put(t, new ArrayList<String>());
                map.get(t).add(s);
            }
        }

        return getPath(end, map);
    }

    private List<List<String>> getPath(String s, Map<String, List<String>> map) {
        List<List<String>> r = new ArrayList();
        if(!map.containsKey(s)) return r;

        for(String t : map.get(s)){
            List<List<String>> sub = getPath(t, map);
            for(List<String> l : sub){
                l.add(s);
                r.add(l);
            }
        }

        // For start node, there is no parents in the map
        if(map.get(s).isEmpty()){
            List<String> sub = new ArrayList();
            sub.add(s);
            r.add(sub);
        }
        return r;
    }

    private Set<String> getCandidates(String s, Set<String> dict){
        Set<String> r = new HashSet();
        StringBuffer sb = new StringBuffer(s);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            for(char d = 'a';d<='z';d++){
                if(d==c) continue;
                sb.setCharAt(i, d);
                if(dict.contains(sb.toString())) r.add(sb.toString());
            }
            sb.setCharAt(i, c);
        }
        return r;
    }
}
