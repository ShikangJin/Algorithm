import java.util.*;

class Tester {
    public static void main(String[] args) {
        System.out.println("test start");
      
        // int[] input = {9,9,8};
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
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