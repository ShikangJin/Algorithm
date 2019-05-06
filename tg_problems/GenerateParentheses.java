/**
    Generate Parentheses

    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.StringBuilder;

// Time Complexity: O(2^N)      2^N represents total amount of nodes in recursion tree
// Space Complexity: O(N)       N = height of recursion tree = 2 * input n
public class GenerateParentheses {
    // add left parenthese when left remains > 0
    // add right parenthese only when left remains < right remains, which means that used right parentheses cannot be more than used left parentheses.
    public static List<String> generateParenthesis(int n) { 
        List<String> res = new ArrayList<>();
        if (n < 1) 
            return res;
        StringBuilder sb = new StringBuilder();
        helper(n, n, sb, res);
        return res;
    }

    private static void helper(int left, int right, StringBuilder sb, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        } else if (right == 0)
            return;
        
        if (left > 0) {
            sb.append('(');
            helper(left - 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < right) {
            sb.append(')');
            helper(left, right - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        } 
    }
}