/**
    Reverse Vowels of a String  

    Write a function that takes a string as input and reverse only the vowels of a string.
 */

// Input: "hello"
// Output: "holle"

// Time Complexity: O(N)    N = length of input String
// Space Complexity O(N)    N = char array length = length of input String
public class ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) 
            return s;
        int left = 0, right = s.length() - 1;
        char[] strArr = s.toCharArray();
        while (left < right) {
            while (left < right && !isVowel(strArr[left])) 
                left++;
            while (left < right && !isVowel(strArr[right]))
                right--;
            if (left != right)
                swap(strArr, left++, right--);
        }
        return new String(strArr);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}