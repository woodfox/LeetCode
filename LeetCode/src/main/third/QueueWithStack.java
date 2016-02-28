package third;

import java.util.LinkedList;

public class QueueWithStack {
    LinkedList<Integer> first = new LinkedList();
    LinkedList<Integer> second = new LinkedList();

    // Push element x to the back of queue.
    public void push(int x) {
        first.addLast(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(second.isEmpty()) {
            while(!first.isEmpty()) {
                second.addLast(first.removeLast());
            }
        }

        if(!second.isEmpty()) {
            second.removeLast();
        }
    }

    // Get the front element.
    public int peek() {
        if(second.isEmpty()) {
            while(!first.isEmpty()) {
                second.addLast(first.removeLast());
            }
        }

        return second.getLast();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}
