/**
    Sum of Root To Leaf Binary Numbers

    Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

    Return the sum of these numbers.
 */

 // Time Complexity: O(N)       N = total number of tree node
 // Space Complexity: O(height of tree) 
 public class SumOfRootToLeafBinaryNumbers {
    private static int globalSum = 0;
    public static int sumRootToLeaf(TreeNode root) {
        globalSum = 0;
        if (root == null)
            return globalSum;
        dfs(root, 0);
        return globalSum;
    }

    private static void dfs(TreeNode root, int num) {
        int curNum = num * 2 + (root.val == 0 ? 0 : 1);
        if (root.left == null && root.right == null) {
            globalSum += curNum;
            return;
        }  
        if (root.left != null) 
            dfs(root.left, curNum);
        if (root.right != null)
            dfs(root.right, curNum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
 }