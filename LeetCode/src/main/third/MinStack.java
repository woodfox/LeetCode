package third;

import java.util.LinkedList;

/**
 *  Use another stack to maintain minimum value.
 */
class MinStack {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    LinkedList<Integer> minStack = new LinkedList<Integer>();

    public void push(int x) {
        stack.addFirst(x);

        if(minStack.isEmpty() || x <= getMin()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            int x = stack.pop();

            if(x == getMin()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.getFirst();
        }else {
            return -1;
        }
    }

    public int getMin() {
        if(!minStack.isEmpty()) {
            return minStack.getFirst();
        } else {
            return -1;
        }
    }
}

/**
 *  Use LinkedList to establish FIFO order;
 *  And use double-linked list to order by value.
 */
class MinStack2 {
    class Node {
        int value;
        Node prev;
        Node next;

        public Node (int x) {
            value = x;
        }
    }

    LinkedList<Node> stack = new LinkedList<Node>();
    Node head;

    /**
     * Time: O(n) in worst case
     */
    public void push(int x) {
        Node node = new Node(x);
        stack.addFirst(node);
        addNode(node);
    }

    /**
     * Time: O(n) in worst case
     */
    public void pop() {
        if(!stack.isEmpty()) {
            Node node = stack.removeFirst();
            removeNode(node);
        }
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.getFirst().value;
        }else {
            return -1;
        }
    }

    public int getMin() {
        if(head != null) {
            return head.value;
        } else {
            return -1;
        }
    }

    private void addNode(Node node) {
        if(head == null) {
            head = node;
        } else {
            Node prev = null;
            Node current = head;
            while(current != null && current.value < node.value) {
                prev = current;
                current = current.next;
            }

            if(current == null) {
                prev.next = node;
                node.prev = prev;
            } else {
                if(prev == null) {
                    head = node;
                } else {
                    prev.next = node;
                }

                node.next = current;
                node.prev = prev;
                current.prev = node;
            }
        }
    }

    private void removeNode(Node node) {
        // Move head if node is current head
        if(node == head) {
            head = node.next;
        }

        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
    }
}
