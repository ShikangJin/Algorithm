/**
    Daily Temperatures

    Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

    For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

    Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. 
 */

import java.util.Deque;
import java.util.ArrayDeque;

// Time Complexity: O(N)    N = length of input array
// Space Complexity: O(N)   N = size of stack = length of input array in worst case
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        // use a stack to store the temperature from end to start of array
        // if temperature in stack is larger, then it's the next higher temperature, then store current smaller temperature into stack
        // if temperature in stack is smaller or equal to current one, then remove the temperature in stack and continue to check. Then store current temperature into stack
        if (T == null || T.length == 0) 
            return T;
        Deque<Pair> stack = new ArrayDeque<>();
        int size = T.length;
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            int curTemp = T[i];
            while (stack.size() > 0 && stack.peekFirst().temperature <= curTemp) 
                stack.removeFirst();

            if (stack.size() == 0)
                res[i] = 0;
            else
                res[i] = stack.peekFirst().index - i;

            stack.addFirst(new Pair(curTemp, i));
        }
        return res;
    }

    public static class Pair {
        int temperature, index;
        public Pair(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }
}