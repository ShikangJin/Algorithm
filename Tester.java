import java.util.*;

class Tester {
    public static void main(String[] args) {
        System.out.println("test start");
      
        int[] input = {4,3,2,7,8,2,3,1};
        printList(FindAllNumbersDisappearedInAnArray.findDisappearedNumbers(input));
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