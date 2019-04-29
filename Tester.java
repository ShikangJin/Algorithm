import java.util.*;

class Tester {
    public static void main(String[] args) {
        System.out.println("test start");
      
        int[][] input = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(IslandPerimeter.islandPerimeter(input));
    }  

    private static void printMatrix(int[][] output) {
      for (int i = 0; i < output.length; i++) {
        for (int j = 0; j < output[0].length; j++) {
          System.out.print(output[i][j] + " ");
        }
        System.out.println(" ");
      }
    }
}