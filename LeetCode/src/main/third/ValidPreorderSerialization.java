package third;

import java.util.LinkedList;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

 _9_
 /   \
 3     2
 / \   / \
 4   1  #  6
 / \ / \   / \
 # # # #   # #
 For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

 Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

 Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

 You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

 Example 1:
 "9,3,4,#,#,1,#,#,2,#,6,#,#"
 Return true

 Example 2:
 "1,#"
 Return false

 Example 3:
 "9,#,#,1"
 Return false
 */
public class ValidPreorderSerialization {
    /**
     * Time: O(n)
     */
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> q = new LinkedList();
        String[] a = preorder.split(",");
        for(String t : a) q.add(t);

        // At last queue must be empty
        return dfs(q) && q.isEmpty();
    }

    private boolean dfs(LinkedList<String> q) {
        if(q.isEmpty()) return false;

        String s = q.removeFirst();
        if(!"#".equals(s)) {
            if(!dfs(q)) return false;
            if(!dfs(q)) return false;
        }

        return true;
    }
}
