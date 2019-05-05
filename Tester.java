import java.util.*;

class Tester {
    public static void main(String[] args) {
        System.out.println("test start");

        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        printMatrix(QueueReconstructionByHeight.reconstructQueue(input));
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