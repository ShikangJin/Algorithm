import java.util.*;

class Tester {
    public static void main(String[] args) {
        System.out.println("test start");

        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        printArray(DailyTemperatures.dailyTemperatures(input));
        // System.out.println(ValidParentheses.isValid("{[()]}"));
    }  

    private static void printArray(int[] output) {
        for (int element : output)
            System.out.print(element + " ");
    }

    private static void printMatrix(int[][] output) {
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) 
                System.out.print(output[i][j] + " ");
            System.out.println(" ");
        }
    }

    private static void printList(List<Integer> output) {
        for (Integer element : output) 
            System.out.println(element);
    }
}