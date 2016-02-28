package third;

import util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        return copyNode(head, map);
    }

    private RandomListNode copyNode(RandomListNode node, Map<RandomListNode, RandomListNode> map) {
        if(node == null) {
            return null;
        }

        RandomListNode newNode = map.get(node);
        if(newNode == null) {
            newNode = new RandomListNode(node.label);
            map.put(node, newNode);

            newNode.next = copyNode(node.next, map);
            newNode.random = copyNode(node.random, map);
        }

        return newNode;
    }
}
