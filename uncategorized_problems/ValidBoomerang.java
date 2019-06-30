/**
    Valid Boomerang

    A boomerang is a set of 3 points that are all distinct and not in a straight line.

    Given a list of three points in the plane, return whether these points are a boomerang.
 */

// Input: [[1,1],[2,3],[3,2]]
// Output: true
import java.util.Math; 

// Time Complexity: O(1)
// Space Complexity: O(1)
public class ValidBoomerang {
    public static boolean isBoomerang(int[][] points) {
        if (same(points[0], points[1]) || same(points[0], points[2]) || same(points[1], points[2]))
            return false;
        else if (points[0][0] == points[1][0] || points[0][0] == points[2][0]) 
            return points[1][0] != points[2][0];
        else if (points[0][1] == points[1][1] || points[0][1] == points[2][1])
            return points[1][1] != points[2][1];
        return ((double)(points[0][0] - points[1][0]) / (points[0][1] - points[1][1])) != ((double)(points[0][0] - points[2][0]) / (points[0][1] - points[2][1]));
    }

    private static boolean same(int[] point1, int[] point2) {
        return point1[0] == point2[0] && point1[1] == point2[1];
    }
}