/**
    Remove Outermost Parentheses

    A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

    A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

    Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

    Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 */

// Input: "(()())(())"
// Output: "()()()"
// Explanation: 
// The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
// After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.LinkedList;

// Time Complexity: O(N)        N = length of input String
// Space Complexity: O(N)       N = length of input String
public class RemoveOutermostParentheses {
    // remove when the left parenthes is at the most bottom of stack
    public static String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) 
            return S;
        int size = S.length();
        boolean[] removingIdx = new boolean[size];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (S.charAt(i) == '(')
                stack.addFirst(i);
            else {
                int remove = stack.removeFirst();
                if (stack.size() == 0) {
                    removingIdx[remove] = true;
                    removingIdx[i] = true;
                }
            } 
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (!removingIdx[i]) {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}