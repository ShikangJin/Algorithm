/**
    Plus One

    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.
 */

// Input: [1,2,3]
// Output: [1,2,4]


// Time Complexity: O(N)    N = length of input array
// Space Complexity: O(1)   ignore the cost of output array
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        // be careful about the potential extra digit after adding one
        if (digits == null || digits.length == 0)
            return digits;

        int size = digits.length;
        boolean addOne = false;
        for (int i = size - 1; i >= 0; i--) {
            int curNum = digits[i];
            if (i == size - 1) 
                curNum += 1;
            if (addOne) {
                curNum += 1;
                addOne = false;
            }
            if (curNum >= 10) {
                curNum -= 10;
                addOne = true;
            }
            digits[i] = curNum;
        }
        if (!addOne) 
            return digits;
        int[] updateRes = new int[size + 1];
        updateRes[0] = 1;
        for (int i = 0; i < size; i++) 
            updateRes[1 + i] = digits[i];
        return updateRes;
    }
}