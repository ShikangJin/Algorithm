/**
    Binary Prefix Divisible By 5

    Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)

    Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 */

// Input: [0,1,1]
// Output: [true,false,false]
// Explanation: 
// The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.

import java.util.List;
import java.util.ArrayList;

// Time Complexity: O(N)    N = size of input array
// Space Complexity: O(1)  
public class BinaryPrefixDivisibleBy5 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        // maintain prev remainder
        // determine current remainder by: 
        //      current is 0: prev remainder * 2
        //      current is 1: prev remainder * 2 + 1
        // remainder %= 5, if it is 0 then current result is true
        List<Boolean> result = new ArrayList<>();
        if (A == null || A.length == 0)
            return result;
        
        int size = A.length;
        int prevRemainder = 0;
        for (int i = 0; i < size; i++) {
            int curRemainder;
            if (i == 0) 
                curRemainder = (A[i] == 0 ? 0 : 1);
            else 
                curRemainder = (prevRemainder * 2 + (A[i] == 0 ? 0 : 1)) % 5;
            prevRemainder = curRemainder;
            result.add(curRemainder == 0 ? true : false);
        }
        return result;
    }
}