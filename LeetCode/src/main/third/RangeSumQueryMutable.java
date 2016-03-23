package third;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:
 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {

    // Use Binary Index Tree to reduce the update time to O(logn)
    // (https://www.hrwhisper.me/binary-indexed-tree-fenwick-tree/)
    private int[] nums;
    private int[] bit;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        if(n == 0) return;

        bit = new int[n+1];
        for(int i=0;i<n;i++) {
            initBinaryIndexTree(i+1, nums[i]);
        }
    }

    private void initBinaryIndexTree(int i, int val) {
        while(i<=nums.length){
            bit[i] += val;
            // Get the parent positions and add a[i] into sum
            i += (i&-i);
        }
    }

    // O(logn)
    // Update all parent nodes to increase some value (i starts from 1)
    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        initBinaryIndexTree(i+1, diff);
    }

    // Time: O(logn)
    public int sumRange(int i, int j) {
        // Get total sum of (0,j) excluding range (0,i-1)
        return getSum(j+1) - getSum(i);
    }

    // Sum up from position i (starting from 1) and its left nodes
    private int getSum(int i) {
        int sum = 0;
        while(i>0) {
            sum += bit[i];
            i -= (i&-i);
        }
        return sum;
    }

    //---------------------------------------------------
    // Use Segment Tree to update
    private class RangeSumQueryMutable_segmentTree {

        class Node {
            public long sum;
            public int start, end;
            public Node left, right;
            public Node(long sum, int start, int end) {
                this.sum = sum;
                this.start = start;
                this.end = end;
            }
        }

        Node root;
        int[] a;

        public RangeSumQueryMutable_segmentTree(int[] a) {
            this.a = a;
            root = buildSegmentTree(a, 0, a.length-1);
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
                Node r = new Node(left.sum + right.sum, start, end);
                r.left = left;
                r.right = right;
                return r;
            }
        }

        // Update range sum from root to leaf
        // O(logn)
        void update(int index, int val) {
            int diff = val - nums[index];
            nums[index] = val;
            modifyNode(root, index, diff);
        }

        private void modifyNode(Node root, int index, int diff){
            if(root==null || index<root.start || index>root.end) return;

            root.sum += diff;
            modifyNode(root.left, index, diff);
            modifyNode(root.right, index, diff);
        }

        // Time: O(logn)
        public long sumRange(int start, int end) {
            if (start < 0 || start > end || end >= nums.length) return -1;
            return queryNode(root, start, end);
        }

        private long queryNode(Node root, int start, int end) {
            if(root==null) return Integer.MIN_VALUE;

            int m = (root.start + root.end)/2;
            if(root.start == start && root.end == end) {
                return root.sum;
            } else if(start > m) {
                return queryNode(root.right, start, end);
            } else if(end <= m){
                return queryNode(root.left, start, end);
            } else {
                return queryNode(root.left, start, m) + queryNode(root.right, m+1, end);
            }
        }
    }

    //-------------------------------------------------------------
    private class RangeSumQueryMutable_slow {
        // Maintain sum array when updating
        // Time Limit Exceed!
        private int[] a;
        private int[] sum;

        // O(n)
        public RangeSumQueryMutable_slow(int[] nums) {
            a = nums;
            int n = a.length;
            sum = new int[n];
            if(n == 0) return;

            sum[0] = a[0];
            for(int i=1;i<n;i++){
                sum[i] = sum[i-1] + a[i];
            }
        }

        // O(i), in worst case it's O(n)
        void update(int i, int val) {
            int diff = val - a[i];
            a[i] = val;
            for(int j=i;j<a.length;j++){
                sum[j] += diff;
            }
        }

        // Time: O(1)
        public int sumRange(int i, int j) {
            if(i == 0) return sum[j];
            else return sum[j] - sum[i-1];
        }
    }
}
