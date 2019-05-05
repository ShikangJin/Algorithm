/**
    First Unique Character in a String

    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1. 

    Note: You may assume the string contains only lowercase letters. 
 */

// s = "leetcode"
// return 0

// Time Complexity: O(N)    N = length of input String
// Space Complexity: O(1)   size of map = 26 Since the input string contains only lowercase letters
public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        // iterate the whole string to find all unique characters, then iterate again to find if current character is unique. 
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curCh = s.charAt(i);
            map[curCh - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}