package third;

import java.util.LinkedList;

public class  MyStack {
    LinkedList<Integer> first = new LinkedList();
    LinkedList<Integer> second = new LinkedList();
    int lastValue = -1;

    // Push element x onto stack.
    public void push(int x) {
        first.addLast(x);
        lastValue = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!first.isEmpty()) {
            while(first.size() > 1) {
                int x = first.removeFirst();
                second.addLast(x);
                lastValue = x;
            }
            first.removeFirst();

            LinkedList<Integer> tmp = first;
            first = second;
            second = tmp;
        }
    }

    // Get the top element.
    public int top() {
        return lastValue;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return first.isEmpty();
    }
}
