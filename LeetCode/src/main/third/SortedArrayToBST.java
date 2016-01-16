package third;

import second.TreeNode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
       return construct(nums, 0, nums.length-1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if(start > end) return null;

        int middle = (start + end)/2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = construct(nums, start, middle-1);
        node.right = construct(nums, middle+1, end);

        return node;
    }
}
