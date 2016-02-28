package third;

import util.TreeNode;

import java.util.LinkedList;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeDeserializeTree {
    // Time: O(n)

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        dfs(root, sb);
        return sb.substring(0, sb.length()-1);
    }

    private void dfs(TreeNode root, StringBuffer sb) {
        if(root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val + ",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if(s == null) return null;
        String[] a = s.split(",");

        LinkedList<String> q = new LinkedList();
        for(String t : a) q.add(t);

        return deserializeNodes(q);
    }

    private TreeNode deserializeNodes(LinkedList<String> q) {
        if(!q.isEmpty()) {
            String s = q.poll();
            if(s.equals("null")) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = deserializeNodes(q);
            root.right = deserializeNodes(q);
            return root;
        } else {
            return null;
        }
    }
}
