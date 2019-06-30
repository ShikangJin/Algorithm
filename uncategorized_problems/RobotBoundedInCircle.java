/**
    Robot Bounded In Circle

    On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

    "G": go straight 1 unit;
    "L": turn 90 degrees to the left;
    "R": turn 90 degress to the right.
    The robot performs the instructions given in order, and repeats them forever.

    Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 */

 // Time Complexity: O(N)   N = length of instruction
 // Space Complexity: O(1)
public class RobotBoundedInCircle {
    // if there is a circle. Robot must be at the origin with same direction after 4 loops
    public static boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) 
            return false;
        int dir = 0;
        int[] position = {0, 0};
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < instructions.length(); i++) {
                switch(instructions.charAt(i)) {
                    case 'G': 
                        if (dir == 0) position[0] -= 1;
                        else if (dir == 1) position[1] += 1;
                        else if (dir == 2) position[0] += 1;
                        else position[1] -= 1;
                        break;
                    case 'L':
                        dir = dir == 0  ? 3 : dir - 1;
                        break;
                    case 'R':
                        dir = dir == 3 ? 0 : dir + 1;
                        break;
                    default:
                        break;
                }
            }
            if (position[0] == 0 && position[1] == 0 && dir == 0) {
                return true;
            }
        }
        return false;
    }
}
