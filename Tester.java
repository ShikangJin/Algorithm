import java.util.*;

class Tester {
    public static void main(String[] args) {
        System.out.println("test start");
        Tester tester = new Tester();
        // int[] input = {0,1,1,1,1,1};
        // tester.printList(BinaryPrefixDivisibleBy5.prefixesDivBy5(input));
        int[][] input = {{1,2},{2,0},{0,0}};
        // tester.printMatrix(MatrixCellsInDistanceOrder.allCellsDistOrder(2, 3, 1, 2));
        System.out.println(RobotBoundedInCircle.isRobotBounded("GL"));
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