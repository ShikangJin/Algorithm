/**
    Robot Return To Origin 

    There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.

    The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.

    Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 */

// Input: "UD"
// Output: true 
// Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.

// Time Complexity: O(N)    N = input String length
// Space Complexity: O(1)
public class RobotReturnToOrigin {
    // track the robot by maintaining a position
    public static boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        int[] position = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            char curMove = moves.charAt(i);
            switch(curMove) {
                default: break;
                case 'U': position[1]++; break;
                case 'D': position[1]--; break;
                case 'R': position[0]++; break;
                case 'L': position[0]--; break;
            }
        }
        return position[0] == 0 && position[1] == 0;
    }
}