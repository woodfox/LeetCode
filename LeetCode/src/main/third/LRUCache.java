package third;

import java.util.HashMap;
import java.util.Map;

/**
 *  R1:  Size will be total of nodes (plus 1 when adding node, and minus 1 when removing tail)
 *  R2:  Map always contains nodes, and should not contain anymore when node removed
 *  R3:  Recently used nodes are in head, and least used in tail
 *  R4:  It will not exceed the capacity (remove tail before adding if it's reaching capacity)
 */
public class LRUCache {
    private int capacity;
    private int size = 0;

    private Node head = null;
    private Node tail = null;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    // Get node from hashMap if any, and move node to the head
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        } else {
            remove(node);
            addHead(node);
            return node.value;
        }
    }

    // Find the node, set value and move to the head
    // If it's more than capacity, delete the one in tail first
    public void set(int key, int value) {
        Node node = map.get(key);
        if(node == null) {
            // Only need to delete capacity if adding new nodes
            if(size >= capacity) {
                remove(tail);
            }

            node = new Node(key, value);
        } else {
            node.value = value;
            remove(node);
        }

        addHead(node);
    }


    private void remove(Node node) {
        if(node == tail) {
            tail = node.prev;
        }
        if(node == head) {
            head = node.next;
        }

        Node prev = node.prev;
        Node next = node.next;
        if(prev != null) {
            prev.next = next;
        }
        if(next != null) {
            next.prev = prev;
        }

        // Reset the prev/next links
        node.prev = null;
        node.next = null;

        map.remove(node.key);
        size--;
    }

    private void addHead(Node node) {
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        map.put(node.key, node);
        size++;
    }
}