/**
    Maximum XOR of Two Numbers in an Array

    Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

    Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

    Could you do this in O(n) runtime?
 */

// Input: [3, 10, 5, 25, 2, 8]

// Output: 28

// Explanation: The maximum result is 5 ^ 25 = 28.

// Time Complexity: O(Nlog32) + O(Nlog32) = O(N)
// Space Complexity: O(2^32)    worst case
public class MaximumXOROfTwoNumbersInAnArray {
    // build a bit tree so for each number, we can find a best fit number from the tree in O(log32)
    // we iterate all number and maintain a global max result. 
    public static int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 2) 
            return 0;
        // build the tree -- left node represents a 0, right node represents a 1
        Node root = new Node();
        for (int num : nums) {
            Node cur = root;
            for (int i = 32; i > 0; i--) {
                int curBit = (num >>> (i - 1)) & 1;
                if (curBit == 1 && cur.right == null) {
                    cur.right = new Node();
                } else if (curBit == 0 && cur.left == null) {
                    cur.left = new Node();
                }
                cur = curBit == 0 ? cur.left : cur.right;
            }
        }

        // check
        int globalMax = 0;
        for (int num : nums) {
            Node cur = root;
            int curMax = 0;
            for (int i = 32; i > 0; i--) {
                int curBit = (num >>> (i - 1)) & 1;
                boolean find = ((curBit == 1 && cur.left != null) || (curBit == 0 && cur.right != null));
                cur = curBit == 1 ? (find ? cur.left : cur.right) : (find ? cur.right : cur.left);
                curMax = (curMax | (find ? 1 : 0)) << (i > 1 ? 1 : 0);
            }
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }

    public static class Node {
        Node left, right;
    }
}