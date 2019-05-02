/**
    Valid Parentheses

    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.

    Note that an empty string is also considered valid.
 */

// Input: "()"
// Output: true

import java.util.Deque;
import java.util.ArrayDeque;

// Time Complexity: O(N)    N = length of input String
// Spcae Complexity: O(N)   N = size of stack = length of input String in worst case
public class ValidParentheses {
    // use a stack to record the previous brackets
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) 
            return true;
        if (s.length() % 2 != 0)
            return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(' || curChar == '[' || curChar == '{') 
                stack.addFirst(curChar);
            else if ((stack.size() == 0) ||
                    (curChar == ')' && stack.removeFirst() != '(') ||
                    (curChar == ']' && stack.removeFirst() != '[') ||
                    (curChar == '}' && stack.removeFirst() != '{'))
                return false;
        }
        return stack.size() == 0;
    }
}
