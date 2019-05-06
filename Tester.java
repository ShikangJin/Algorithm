import java.util.*;

class Tester {
    public static void main(String[] args) {
        System.out.println("test start");
        Tester tester = new Tester();

        tester.printList(GenerateParentheses.generateParenthesis(3));
        // int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        // printMatrix(QueueReconstructionByHeight.reconstructQueue(input));
        // System.out.println(ValidParentheses.isValid("{[()]}"));
    }  

    private void printArray(int[] output) {
        for (int element : output)
            System.out.print(element + " ");
    }

    private void printMatrix(int[][] output) {
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) 
                System.out.print(output[i][j] + " ");
            System.out.println(" ");
        }
    }

    private void printList(List output) {
        for (Object element : output) 
            System.out.println(element);
    }
}