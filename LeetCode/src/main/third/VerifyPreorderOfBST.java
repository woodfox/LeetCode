package third;

/**
 * You have an array of preorder traversal of Binary Search Tree ( BST). Your program should verify whether it is a correct sequence or not.

 Input: Array of Integer [ Pre-order BST ] Output: true or false
 */
public class VerifyPreorderOfBST {
    boolean verifyPreorder(int[] a) {
        return check(a, 0, a.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean check(int[] a, int l, int r, int min, int max) {
        if(l > r) return true;
        if(a[l] <= min || a[r] >= max) return false;

        int pos = l+1;
        while(pos <= r && a[pos] < a[l]) {
            pos++;
        }
        return check(a, l+1, pos-1, min, a[l]) && check(a, pos, r, a[l], max);
    }
}
