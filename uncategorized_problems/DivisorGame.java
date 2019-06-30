/**
    Divisor Game

    Alice and Bob take turns playing a game, with Alice starting first.

    Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

    Choosing any x with 0 < x < N and N % x == 0.
    Replacing the number N on the chalkboard with N - x.
    Also, if a player cannot make a move, they lose the game.

    Return True if and only if Alice wins the game, assuming both players play optimally.
 */

// Input: 2
// Output: true
// Explanation: Alice chooses 1, and Bob has no more moves.

// Time Complexity: O(1)
// Space Complexity: O(1)
public class DivisorGame {
    // even number win: if divide 2 equals to an odd number, then move number / 2 moves, else, move 1 move. Leave Bob an odd number to move.
    // At last, Alice will have 2, move 1, win
    public static boolean divisorGame(int N) {
        if (N <= 0) 
            return false;
        return N % 2 == 0;
    }
}
