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

        private class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode(int v) {
                val = v;
            }
        }

        private int[] nums;
        private int[] sum;
        private TreeNode root;

        public RangeSumQueryMutable_segmentTree(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            if (n == 0) return;

            sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }

            root = new TreeNode(sum[n]);
            buildSegmentTree(sum, 0, n - 1, root);
        }

        private void buildSegmentTree(int[] sum, int l, int r, TreeNode root) {
            if (l < r) {
                int m = (l + r) / 2;
                // Sum[m+1] - sum[l] is the sum for range [l, m]
                root.left = new TreeNode(sum[m + 1] - sum[l]);
                // Sum[r+1] - sum[m+1] is the sum for range [m+1, r]
                root.right = new TreeNode(sum[r + 1] - sum[m + 1]);

                buildSegmentTree(sum, l, m, root.left);
                buildSegmentTree(sum, m + 1, r, root.right);
            }
        }

        // Update range sum from root to leaf
        // O(logn)
        void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            updateNode(i, diff, 0, nums.length - 1, root);
        }

        private void updateNode(int i, int diff, int l, int r, TreeNode root) {
            root.val += diff;
            if (l == i && r == i) return;

            int m = (l + r) / 2;
            if (i <= m) {
                updateNode(i, diff, l, m, root.left);
            } else {
                updateNode(i, diff, m + 1, r, root.right);
            }
        }

        // Time: O(logn)
        public int sumRange(int i, int j) {
            if (i < 0 || i > j || j >= nums.length) return -1;
            return getSum(i, j, 0, nums.length - 1, root);
        }

        private int getSum(int i, int j, int l, int r, TreeNode root) {
            if (i == l && j == r) return root.val;

            int m = (l + r) / 2;
            if (i > m) {
                // The range [i,j] is on right side
                return getSum(i, j, m + 1, r, root.right);
            } else if (j <= m) {
                // The range [i,j] is on left side
                return getSum(i, j, l, m, root.left);
            } else {
                // The range [i,j] is in both sides [i,m] + [m+1,j]
                return getSum(i, m, l, m, root.left) + getSum(m + 1, j, m + 1, r, root.right);
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
