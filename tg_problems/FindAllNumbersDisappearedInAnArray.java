/**
    Find All Numbers Disappeared in an Array

    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements of [1, n] inclusive that do not appear in this array.

    Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */

// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [5,6]

import java.util.List;
import java.util.ArrayList;

// Time Complexity: O(N)    N = size of input array
// Space Complexity: O(1)
public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // each index store number = index + 1 so at the end the indexes stored incorrect number are the index for result number (res number = index + 1)
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int idx = 0;
        while (idx < nums.length) {
            int curNum = nums[idx];
            if (curNum - 1 == idx || nums[curNum - 1] == curNum) {
                idx++;
            } else {
                int temp = nums[curNum - 1];
                nums[curNum - 1] = curNum;
                nums[idx] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}