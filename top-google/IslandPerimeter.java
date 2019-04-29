/**
    You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

    The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island. 
 */

// Input:
// [[0,1,0,0],
//  [1,1,1,0],
//  [0,1,0,0],
//  [1,1,0,0]]

// Output: 16

// Time Complexity: O(N * M)    N = number of input row     M = number of input col
// Space Complexity: O(1)
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        // for each 1 block, determine four directions of it to see whether the neibor is 0 or boundary
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int total = 0, row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if ((i > 0 && grid[i - 1][j] == 0) || (i == 0)) {
                    total++;
                }
                if ((i < row - 1 && grid[i + 1][j] == 0) || (i == row - 1)) {
                    total++;
                }
                if ((j > 0 && grid[i][j - 1] == 0) || (j == 0)) {
                    total++;
                }
                if ((j < col - 1 && grid[i][j + 1] == 0) || (j == col - 1)) {
                    total++;
                }
            }
        }
        return total;
    }
}