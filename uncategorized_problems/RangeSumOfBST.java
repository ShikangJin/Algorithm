/**
    Range Sum of BST

    Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

    The binary search tree is guaranteed to have unique values.
 */

// Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
// Output: 32

// Time Complexity: O(N)    N = number of node in BST  
// Space Complexity: O(1)
public class RangeSumOfBST {
    public static int rangeSumBST(TreeNode root, int L, int R) {
        // meet L, search right; meet R search left
        if (root == null) 
            return 0;
        if (root.val <= L) 
            return (root.val == L ? root.val : 0) + rangeSumBST(root.right, L, R);
        else if (root.val >= R)
            return (root.val == R ? root.val : 0) + rangeSumBST(root.left, L, R);
        else 
            return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}