import java.util.*;

class Tester {
    public static void main(String[] args) {
        System.out.println("test start");
      
        // String input = "leetcode";
        System.out.println(ReverseVowelsOfAString.reverseVowels("aA"));
    }  

    private static void printMatrix(int[][] output) {
      for (int i = 0; i < output.length; i++) {
        for (int j = 0; j < output[0].length; j++) {
          System.out.print(output[i][j] + " ");
        }
        System.out.println(" ");
      }
    }

    private static void printList(List<Integer> list) {
        for (Integer element : list) {
            System.out.println(element);
        }
    }
}