package other;

import java.util.*;

/**
 * 在发邮件的时候，比如输入 ben ，下边会提示名字(FirstName, LastName)或者邮件以 ben 开头的人，设计一个类来完成这个提示功能。假设每次我们返回最多10个这样的结果。

 Follow up I，如果希望返回的结果是alphabetic有序的，比如输入ben的时候， benaa 在 benbd 前面，怎么设计。
 Follow up II，如果我们希望First Name是ben开头的在Last Name是ben开头的前边，比如 ben Back 在 jack benth前面怎么办。
 */
public class SearchSuggestion {
    /**
     * Use Tries to find matched names according to prefix.
     *
     * Init Time: O(n*k), k is string length   Space: O(n*k)
     * Query Time: O(k), k is prefix length
     *
     * Follow up I: Sort the list with order and fetch first 10 records.
     * Follow up II: Save matched list for firstName ad lastName in different list, and combine them.
     */
    private Node root = new Node(' ');

    public SearchSuggestion(List<String> dict) {
        for(String s : dict) {
            String[] names = s.split(" ");
            // Create tries for first name
            insertNode(root, names[0], s);
            // Create tries for last name
            insertNode(root, names[1], s);
        }
    }

    private void insertNode(Node root, String s, String name) {
        // Save whole name in the set for all nodes in the path, so it's easy to get result in query
        root.names.add(name);

        if(s.length() > 0) {
            char c = s.charAt(0);
            if(!root.map.containsKey(c)) {
                root.map.put(c, new Node(c));
            }
            insertNode(root.map.get(c), s.substring(1), name);
        }
    }

    public List<String> suggest(String prefix) {
        return suggestNode(root, prefix);
    }

    private List<String> suggestNode(Node root, String prefix) {
        if(prefix.length()==0){
            List<String> r = new ArrayList(root.names);
            if(r.size() > 10) {
                r = r.subList(0, 10);
            }
            return r;
        } else{
            char c = prefix.charAt(0);
            if(root.map.containsKey(c)){
                return suggestNode(root.map.get(c), prefix.substring(1));
            } else {
                return new ArrayList();
            }
        }
    }

    class Node {
        char c;
        Set<String> names = new HashSet();

        Map<Character, Node> map = new HashMap<Character, Node>();

        public Node(char d) {
            this.c = d;
        }
    }
}
