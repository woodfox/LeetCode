package third;

import util.TreeNode;

import java.util.*;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

 Note:

 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.


 Follow up:
 Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class ClosestBSTValueII {
    /**
     * Use left and right pointer to find k closest numbers in sorted list from BST.
     *
     * Time: O(n),  Space: O(n)
     */
    List<Integer> closestKValues(TreeNode root, final double t, int k) {
        List<Integer> l = new ArrayList();
        dfs(root, l);

        int n = l.size();
        int left = 0;
        int right = n-1;
        if(t < l.get(0)) {
            left = -1;
            right = 0;
        } else if(t > l.get(n-1)){
            left = n-1;
            right = n;
        } else {
            for(int i=0;i<n-1;i++){
                if(t >= l.get(i) && t <= l.get(i+1)) {
                    left = i;
                    right = i+1;
                    break;
                }
            }
        }

        List<Integer> r = new ArrayList();
        for(int i=0;i<k;i++){
            double a = Double.MAX_VALUE;
            if(left >= 0) {
                a = Math.abs(l.get(left) - t);
            }
            double b = Double.MAX_VALUE;
            if(right < n) {
                b = Math.abs(l.get(right) - t);
            }
            if(a <= b) {
                r.add(l.get(left));
                left--;
            } else {
                r.add(l.get(right));
                right++;
            }
        }
        return r;
    }
    /**
     * Sort by difference with target and get k closest values.
     *
     * Time: O(nlgn),  Space: O(n)
     */
    List<Integer> closestKValues_slow(TreeNode root, final double t, int k) {
        List<Integer> l = new ArrayList();
        dfs(root, l);
        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (Math.abs(a - t) <= Math.abs(b - t)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        return l.subList(0, k);
    }

    private void dfs(TreeNode root, List<Integer> l) {
        if(root == null) return;
        dfs(root.left, l);
        l.add(root.val);
        dfs(root.right, l);
    }

    /**
     * Another way is using k-size priority queue.
     *
     * Time: O(nlgk)
     *
     * Be careful:
     *  1. PriorityQueue doesn't ensure the order when using loop!
     */
    List<Integer> closestKValues_priorityQueue(TreeNode root, final double t, int k) {
        PriorityQueue<Tuple> maxHeap = new PriorityQueue(k, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple a, Tuple b) {
                if(a.diff >= b.diff) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        dfsQueue(root, maxHeap, t, k);

        List<Integer> r = new ArrayList();
        while(!maxHeap.isEmpty()) {
            r.add(maxHeap.poll().val);
        }

        // Reverse order
        Collections.reverse(r);
        return r;
    }

    private void dfsQueue(TreeNode root, PriorityQueue<Tuple> maxHeap, double t, int k) {
        if(root == null) return;

        double diff = Math.abs(root.val - t);
        maxHeap.add(new Tuple(diff, root.val));

        if(maxHeap.size() > k) {
            maxHeap.poll();
        }

        dfsQueue(root.left, maxHeap, t, k);
        dfsQueue(root.right, maxHeap, t, k);
    }

    private class Tuple {
        double diff;
        int val;
        public Tuple(double d, int v) {
            diff = d;
            val = v;
        }
    }
}
