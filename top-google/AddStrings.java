/**
    Add Strings

    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

    Note:
        The length of both num1 and num2 is < 5100.
        Both num1 and num2 contains only digits 0-9.
        Both num1 and num2 does not contain any leading zero.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

import java.util.StringBuilder;

// Time Complexity: O(N + M)    N = length of input String1    M = length of input String2
// Space Complexity: O(1)   ignore the result String
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        // add two string from end to head. append result into stringbuilder and reverse it at last
        if ((num1 == null || num1.length() == 0) && (num2 == null || num2.length() == 0)) {
            return "0";
        } else if (num1 == null || num1.length() == 0) {
            return num2;
        } else if (num2 == null || num2.length() == 0) {
            return num1;
        }

        StringBuilder res = new StringBuilder();
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        boolean add = false;
        while (idx1 >= 0 && idx2 >= 0) {
            int cur = (num1.charAt(idx1) - '0') + (num2.charAt(idx2) - '0');
            if (add) {
                cur++;
                add = false;
            }
            if (cur >= 10) {
                cur -= 10;
                add = true;
            }
            res.append(Integer.toString(cur));
            idx1--;
            idx2--;
        }

        while (idx1 >= 0) {
            int cur = num1.charAt(idx1) - '0';
            if (add) {
                cur++;
                add = false;
            }
            if (cur >= 10) {
                cur -= 10;
                add = true;
            }
            res.append(Integer.toString(cur));
            idx1--;
        }
        while (idx2 >= 0) {
            int cur = num2.charAt(idx2) - '0';
            if (add) {
                cur++;
                add = false;
            }
            if (cur >= 10) {
                cur -= 10;
                add = true;
            }
            res.append(Integer.toString(cur));
            idx2--;
        }
        if (add) {
            res.append(Integer.toString(1));
        }
        return res.reverse().toString();
    }
 }