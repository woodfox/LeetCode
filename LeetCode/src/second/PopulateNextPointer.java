package second;

import java.util.HashMap;
import java.util.LinkedList;

public class PopulateNextPointer {
	//With O(1) space
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        TreeLinkNode parent = root;
        TreeLinkNode child = root.left;
        while(child != null){
            TreeLinkNode next = child.left;
            TreeLinkNode p = parent;
            TreeLinkNode node = child;
            while(node != null){
                if(node == p.left){
                    node.next = p.right;
                }else{
                    p = p.next;
                    if(p != null){
                        node.next = p.left;
                    }
                }
                node = node.next;
            }
            parent = child;
            child = next;
        }
    }
	
    //With O(n) space
	public void connect2(TreeLinkNode root) {
		HashMap<Integer, LinkedList<TreeLinkNode>> q = new HashMap<Integer, LinkedList<TreeLinkNode>>();
		dfs(q, root, 0);
		for (LinkedList<TreeLinkNode> l : q.values()) {
			for (int i = 0; i < l.size() - 1; i++) {
				l.get(i).next = l.get(i + 1);
			}
		}
	}

	void dfs(HashMap<Integer, LinkedList<TreeLinkNode>> q, TreeLinkNode node,
			int level) {
		if (node == null) {
			return;
		}

		if (q.get(level) == null) {
			q.put(level, new LinkedList<TreeLinkNode>());
		}
		q.get(level).add(node);
		dfs(q, node.left, level + 1);
		dfs(q, node.right, level + 1);
	}
}
