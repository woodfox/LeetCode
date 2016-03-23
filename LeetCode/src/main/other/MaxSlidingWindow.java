package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    /**
     * Use queue to maintain max elements so that it's constant time to add/remove/getMax.
     *  1. when push x, delete all elements from end that is less than x, then add x into the end;
     *  2. when pop x, remove it from start if it's first one(largest one)
     *
     *  Time: O(n)
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> r = new ArrayList();
        int n = nums.length;
        if (n == 0) return r;

        LinkedList<Integer> maxQueue = new LinkedList();
        for(int i=0;i<k-1;i++){
            enqueue(maxQueue, nums[i]);
        }

        for(int i=k-1;i<n;i++){
            enqueue(maxQueue, nums[i]);
            r.add(maxQueue.getFirst());
            dequeue(maxQueue, nums[i - k + 1]);
        }
        return r;
    }

    private void enqueue(LinkedList<Integer> maxQueue, int x) {
        while(!maxQueue.isEmpty() && maxQueue.getLast() < x) {
            maxQueue.removeLast();
        }

        maxQueue.addLast(x);
    }

    private void dequeue(LinkedList<Integer> maxQueue, int x) {
        if(!maxQueue.isEmpty() && maxQueue.getFirst() == x) {
            maxQueue.removeFirst();
        }
    }

    /**
     * Use PriorityQueue to maintain max element in k window.
     * Time Limit Exceeded!
     *
     * Time: O(nlogk)
     */
    public ArrayList<Integer> maxSlidingWindow_slow(int[] nums, int k) {
        ArrayList<Integer> r = new ArrayList();
        int n = nums.length;
        if(n==0) return r;

        k = Math.min(n, k);
        PriorityQueue<Integer> maxQueue = new PriorityQueue(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });

        for(int i=0;i<k-1;i++){
            maxQueue.add(nums[i]);
        }
        for(int i=k-1;i<n;i++){
            maxQueue.add(nums[i]);
            r.add(maxQueue.peek());
            maxQueue.remove(nums[i - k + 1]);
        }
        return r;
    }
}
