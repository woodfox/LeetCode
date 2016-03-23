package other;

import util.Interval;

import java.util.ArrayList;

/**
 * Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list.
 * Each query has two integers [start, end]. For each query, calculate the minimum number between index start and end
 * in the given array, return the result list
 */
public class MinimumNumberQueries {
    /**
     * Use segment to do multiple queries for range minimal value.
     *
     * Time: O(n*logn + m*logn), n is array lenth and m is queries number
     */
    public ArrayList<Integer> intervalMinNumber(int[] a,
                                                ArrayList<Interval> queries) {
        int n = a.length;
        Node root = buildSegmentTree(a, 0, n-1);

        ArrayList<Integer> r = new ArrayList();
        for(Interval query : queries) {
            r.add(queryNode(root, query.start, query.end));
        }
        return r;
    }

    // Time: O(logn)
    private int queryNode(Node root, int start, int end) {
        if(root==null) return Integer.MIN_VALUE;

        int m = (root.start + root.end)/2;
        if(root.start == start && root.end == end) {
            return root.min;
        } else if(start > m) {
            return queryNode(root.right, start, end);
        } else if(end <= m){
            return queryNode(root.left, start, end);
        } else {
            return Math.min(queryNode(root.left, start, m), queryNode(root.right, m+1, end));
        }
    }

    //O(nlogn)
    private Node buildSegmentTree(int[] a, int start, int end) {
        if(start > end) return null;
        else if(start == end) {
            return new Node(a[start], start, end);
        } else {
            int m = (start + end)/2;
            Node left = buildSegmentTree(a, start, m);
            Node right = buildSegmentTree(a, m+1, end);

            int min = Math.min(left.min, right.min);
            Node r = new Node(min, start, end);
            r.left = left;
            r.right = right;
            return r;
        }
    }

    class Node {
        public int min;
        public int start, end;
        public Node left, right;
        public Node(int min, int start, int end) {
            this.min = min;
            this.start = start;
            this.end = end;
        }
    }
}
