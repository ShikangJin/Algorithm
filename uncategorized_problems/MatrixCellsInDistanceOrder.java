import java.util.LinkedList;
import java.util.Queue;

import TwoCityScheduling.Pair;

/**
    Matrix Cells in Distance Order

    We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

    Additionally, we are given a cell in that matrix with coordinates (r0, c0).

    Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)
 */

// Input: R = 1, C = 2, r0 = 0, c0 = 0
// Output: [[0,0],[0,1]]
// Explanation: The distances from (r0, c0) to other cells are: [0,1]

import java.util.Set;
import java.util.HashSet;

// Time Complexity: O(N)    N = number of cells = R * C
// Space Complexity: O(N)   N = number of cells = R * C
public class MatrixCellsInDistanceOrder {
    // BFS with boundary
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        if (R <= 0 || C <= 0) 
            return res;
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> set = new HashSet<>();
        Pair start = new Pair(r0, c0);
        queue.offer(start);
        set.add(start);
        int resIdx = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair curPair = queue.poll();
                int curR = curPair.r, curC = curPair.c;
                res[resIdx++] = new int[]{curR, curC};    
                if (curC - 1 >= 0) {
                    Pair nextLeft = new Pair(curR, curC - 1);
                    if (set.add(nextLeft)) 
                        queue.offer(nextLeft);
                }
                if (curC + 1 < C) {
                    Pair nextRight = new Pair(curR, curC + 1);
                    if (set.add(nextRight)) 
                        queue.offer(nextRight);
                }
                if (curR - 1 >= 0) {
                    Pair nextUp = new Pair(curR - 1, curC);
                    if (set.add(nextUp)) 
                        queue.offer(nextUp);
                }
                if (curR + 1 < R) {
                    Pair nextDown = new Pair(curR + 1, curC);
                    if (set.add(nextDown)) 
                        queue.offer(nextDown);
                }       
            }
        }
        return res;
    }

    public static class Pair {
        int r, c;
        public Pair (int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) 
                return false;
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return p.r == this.r && p.c == this.c;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.r * 100 + this.c * 17;
        }
    }
}