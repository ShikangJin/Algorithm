/**
    Queue Reconstruction by Height

    Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

    Note:
    The number of people is less than 1,100.
 */


// Input:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
// Output:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

// Time Complexity: O(N^2)      N = length of input array   
// sorting time + iteration time * add element = O(NlogN) + O(N) * (O(N) find idx + O(1) insert)
// Space Complexity: O(1)       ignore the output array
public class QueueReconstructionByHeight {
    // Sort the input array first from large to small
    // Iterate the sorted array, insert into result list. Since the array is sorted from large to small, the iterated elements are all equal or larger then current element, so just insert into the k-th index. 
    // If two elements have same h, then the one with smaller k value should be inserted first so the latet inserted element will not influence the previous one.
    public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0) 
            return people;
        Arrays.sort(people, (int[] arr1, int[] arr2) -> 
            arr1[0] < arr2[0] ? 1 : (arr1[0] == arr2[0] ? (arr1[1] < arr2[1] ? -1 : 1) : -1)
        );
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
