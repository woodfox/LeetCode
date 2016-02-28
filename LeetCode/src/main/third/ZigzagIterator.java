package third;

import java.util.List;
import java.util.PriorityQueue;

/**Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 */
 public class ZigzagIterator {
    private List<Integer> l1;
    private List<Integer> l2;
    private int pos1 = 0;
    private int pos2 = 0;
    int turn = 1;

    public ZigzagIterator(List<Integer> l1, List<Integer> l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public boolean hasNext() {
        return pos1 < l1.size() || pos2 < l2.size();
    }

    public int next() {
        turn++;
        if((turn%2==1 && pos2 < l2.size()) || pos1 >= l1.size()) {
            int x = l2.get(pos2);
            pos2++;
            return x;
        } else {
            int x = l1.get(pos1);
            pos1++;
            return x;
        }
    }

    /**
     * Extend to k lists with value in order:
     *   Use priority queue to get all digits in position and get one by one in order.
     *
     * Time: O(n*klgk), n is the average length of list
     */
    class ZigzagIteratorWithKListInOrder {
        private List<List<Integer>> l;
        int pos = 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        public ZigzagIteratorWithKListInOrder(List<List<Integer>> l) {
            this.l = l;
        }

        public boolean hasNext() {
            if(q.isEmpty()) {
                for(List<Integer> sub : l) {
                    if(pos < sub.size()) {
                        q.add(sub.get(pos));
                    }
                }
                pos++;
            }
            return !q.isEmpty();
        }

        public int next() {
            return q.poll();
        }
    }
}
