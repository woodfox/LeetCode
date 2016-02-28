package third;

import java.util.LinkedList;

/**
 * Use queue to maintain max elements so that it's constant time to add/remove/getMax.
 *  1. when push x, delete all elements from end that is less than x, then add x into the end;
 *  2. when pop x, remove it from start if it's first one(largest one)
 */
public class MaxQueue {
    LinkedList<Integer> queue = new LinkedList();
    LinkedList<Integer> max = new LinkedList();

    void enqueue(int x) {
        queue.addLast(x);

        // Maintain max queue
        while(!max.isEmpty() && max.getLast() < x) {
            max.removeLast();
        }
        max.add(x);
    }

    void dequeue() {
        int x = queue.removeFirst();

        if(x == max.getFirst()) {
            max.removeFirst();
        }
    }

    int max() {
        if(max.isEmpty()) {
            return -1;
        } else {
            return max.getFirst();
        }
    }
}
