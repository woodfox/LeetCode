package other;

public class MaxSegmentTree {
    public SegmentTreeNode build(int start, int end) {
        if(start>end) return null;

        SegmentTreeNode root = new SegmentTreeNode(0, start, end);
        if(start < end) {
            int m = (start+end)/2;
            root.left = build(start, m);
            root.right = build(m+1, end);
        }
        return root;
    }

    public int query(SegmentTreeNode root, int start, int end) {
        if(root==null || start<root.start|| end>root.end) return -1;

        int m = (root.start+root.end)/2;
        if(root.start==start && root.end==end){
            return root.max;
        } else if(start>m){
            return query(root.right, start, end);
        } else if(end<=m){
            return query(root.left, start, end);
        } else{
            int left = query(root.left, start, m);
            int right = query(root.right, m+1, end);
            return Math.max(left, right);
        }
    }

    public void modify(SegmentTreeNode root, int index, int value) {
        modifyNode(root, index, value);
    }

    private int modifyNode(SegmentTreeNode root, int index, int value) {
        if(index<root.start || index>root.end) return root.max;

        if(root.start==root.end) {
            root.max = value;
            return root.max;
        } else {
            int m = (root.start + root.end)/2;
            int left = modifyNode(root.left, index, value);
            int right = modifyNode(root.right, index, value);
            root.max = Math.max(left, right);
            return root.max;
        }
    }

    private class SegmentTreeNode {
        public int max;
        public int start, end;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int max, int start, int end) {
            this.max = max;
            this.start = start;
            this.end = end;
        }
    }
}
