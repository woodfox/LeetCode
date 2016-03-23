package third;

import java.util.Arrays;

public class CountOfRangeSum {

    /**
     * Use sorted prefix array so that we can use binary search to find the position of [sum-upper, sum-lower].
     * Reference: https://leetcode.com/discuss/79907/summary-divide-conquer-based-binary-indexed-based-solutions
     *
     * Time: f(n) = 2f(n/2) + O(nlogn)  = O(nlogn)
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n+1];
        for(int i=0;i<n;i++){
            sum[i+1] += sum[i] + nums[i];
        }
        return countWithPrefixSort(sum, 0, n, lower, upper);
    }

    private int countWithPrefixSort(long[] sum, int start, int end, int lower, int upper) {
        if(start == end) return 0;

        // Sort prefix array
        int m = (start + end)/2;
        long[] prefix = new long[m-start+1];
        for(int i=0;i<m-start+1;i++) {
            prefix[i] = sum[i+start];
        }
        Arrays.sort(prefix);

        int total = 0;
        for(int i=m+1;i<=end;i++){
            // lower <= sum[i] - sum[j] <= upper
            // So: sum[i] - upper <= sum[j] <= sum[i] - lower
            // "binarySearch(prefix, sum[i]-lower+0.5)" will find the last position
            // "binarySearch(prefix, sum[i]-upper-0.5)" will find the first position
            total += binarySearch(prefix, sum[i]-lower+0.5) - binarySearch(prefix, sum[i]-upper-0.5);
        }

        return total + countWithPrefixSort(sum, start, m, lower, upper) + countWithPrefixSort(sum, m+1, end, lower, upper);
     }

    // Find the closest position for value. Since value is double,
    // it will find the first position that prefix[i] > val
    private int binarySearch(long[] prefix, double val) {
        int l = 0;
        int r = prefix.length-1;
        while(l <= r) {
            int m = (l+r)/2;
            if(prefix[m] > val) r = m-1;
            else l = m+1;
        }
        return l;
    }

    /**
     * ---------------------------------------------------------------------
     * Use BST to save the previous sum and find the count of previous sum in range in O(longn)
     * l <= sum[i] - sum[j] <= h        =>  sum[i]-h <= sum[j] <= sum[i]-l
     *
     * Time: O(nlogn)
     */
    Tree tree = new Tree();
    public int countRangeSum_BST(int[] a, int lower, int upper) {
        // Init tree every time
        tree = new Tree();

        int n = a.length;
        if(n == 0) return 0;
        int count = 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            if(sum>=lower && sum<=upper) count++;
            count += tree.smaller(sum-lower, true) - tree.smaller(sum-upper, false);

            // Add current sum into BST
            tree.insert(sum);
        }
        return count;
    }

    private class Tree {
        Node root;
        public void insert(long val) {
            if(root == null) {
                root = new Node(val);
            } else {
                insertNode(root, val);
            }
        }

        private void insertNode(Node root, long val) {
            if(root.val == val) {
                root.self++;
            } else if(root.val > val){
                root.smaller++;
                if(root.left == null){
                    root.left = new Node(val);
                }else{
                    insertNode(root.left, val);
                }
            }else {
                if(root.right == null){
                    root.right = new Node(val);
                }else{
                    insertNode(root.right, val);
                }
            }
        }

        public int smaller(long val, boolean inclusive){
            return smallerNode(root, val, inclusive);
        }

        private int smallerNode(Node root, long val, boolean inclusive){
            if(root == null) return 0;
            else if(root.val == val) {
                int r = root.smaller;
                if(inclusive) r += root.self;
                return r;
            } else if(root.val > val){
                return smallerNode(root.left, val, inclusive);
            } else {
                return root.self + root.smaller + smallerNode(root.right, val, inclusive);
            }
        }
    }

    private class Node {
        int self = 1;
        int smaller = 0;
        long val;
        Node left;
        Node right;

        public Node(long val) {
            this.val = val;
        }
    }

    /**
     * ----------------------------------------------------------------
     * Calcuate sum of [0,n], and for every position i, check how many positions on right that has diff within range [low, high].
     * Use merge sort to reduce time since the right part is already sorted and it only needs to access once.
     *
     * Time: f(n) = 2*f(n/2) + n = O(nlogn)
     */
    public int countRangeSum_mergeSort(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n+1];
        for(int i=0;i<n;i++){
            sum[i+1] += sum[i] + nums[i];
        }

        return countWithMergeSort(sum, 0, n, lower, upper);
    }

    private int countWithMergeSort(long[] sum, int start, int end, int lower, int upper) {
        if(start == end) return 0;

        int m = (start+end)/2;
        int count = countWithMergeSort(sum, start, m, lower, upper)
                + countWithMergeSort(sum, m + 1, end, lower, upper);

        // First: calculate total positions for every sum in left comparing with right sum with diff in range
        int j = m+1;
        int k = m+1;
        for(int i=start;i<=m;i++) {
            // Find first position that sum[k]-sum[i] >= lower
            while (k <= end && sum[k] - sum[i] < lower) k++;
            // Find last position that sum[j]-sum[i] <= upper
            while (j <= end && sum[j] - sum[i] <= upper) j++;
            count += j - k;
        }

        // Second: merge sorted left and right array
        int r = m+1;
        int p = 0;
        long[] tmp = new long[end-start+1];
        for(int i=start;i<=m;i++){
            // Merge the arrays, add right elements if smaller
            while(r<=end && sum[r]<sum[i]) tmp[p++] = sum[r++];
            // Then add left element
            tmp[p++] = sum[i];
        }
        while(r<=end) tmp[p++] = sum[r++];

        for(int i=0;i<end-start+1;i++){
            sum[start+i] = tmp[i];
        }

        return count;
    }

    public int countRangeSum_naive(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n+1];
        for(int i=0;i<n;i++){
            sum[i+1] += sum[i] + nums[i];
        }

        int total = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(sum[j]-sum[i] >= lower && sum[j]-sum[i]<=upper) {
                    total++;
                }
            }
        }

        return total;
    }
}
