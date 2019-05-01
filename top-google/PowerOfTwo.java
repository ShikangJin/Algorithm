/**
    Power of Two

    Given an integer, write a function to determine if it is a power of two.
 */

// Input: 1
// Output: true 
// Explanation: 2^0 = 1

// Time Complexity: O(1)    worst case is 64 for an integer
// Space Complexity: O(1)
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        // use bit operation
        // pattern of 2-power numbers in bit form: 1 10 100 1000 10000 ...
        // count the amount of 1 in bit pattern. There should be only one 1 
        if (n <= 0) 
            return false;
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) 
                count++;
            if (count > 1) 
                return false;
            n >>= 1;
        }
        return count == 1;
    }
}