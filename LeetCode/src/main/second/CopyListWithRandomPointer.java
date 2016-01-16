package second;

import java.util.HashMap;

public class CopyListWithRandomPointer {
	// Definition for singly-linked list with a random pointer.
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
	
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode first = null;
        RandomListNode cur = null;
        RandomListNode node = head;
        while(node != null){
            RandomListNode dup = copyNode(node, map);
            if(first == null){
                first = dup;
                cur = dup;
            }else{
                cur.next = dup;
                cur = dup;
            }
            node = node.next;
        }
        return first;
    }
    
    private RandomListNode copyNode(RandomListNode old, HashMap<RandomListNode, RandomListNode> map){
        if(old == null){
            return null;
        }
        RandomListNode newNode = map.get(old);
        if(newNode == null){
            newNode = new RandomListNode(old.label);
            map.put(old, newNode);
            newNode.random = copyNode(old.random, map);
        }
        return newNode;
    }
}
