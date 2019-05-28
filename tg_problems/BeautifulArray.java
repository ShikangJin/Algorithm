/**
    Beautiful Array

    For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:

    For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].

    Given N, return any beautiful array A.  (It is guaranteed that one exists.)
 */

// Input: 4
// Output: [2,1,4,3]

public class BeautifulArray {
    // rule: for any subarray, arr[start] + arr[end] cannot be equal to 2 * any element in this subarray
    public static int[] beautifulArray(int N) {
        
    }
}