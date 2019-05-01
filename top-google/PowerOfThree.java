/**
    Power of Three

    Given an integer, write a function to determine if it is a power of three.
 */

// Input: 27
// Output: true

// Time Complexity: O((log_3)N)
// Space Complexity: O(1)
public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) 
            return false; 
        
        while (n % 3 == 0) 
            n /= 3;
            
        return n == 1;
    }
}
