import com.apple.concurrent.Dispatch.Priority;

/*
    Two City Scheduling

    There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

    Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
*/

// Input: [[10,20],[30,200],[400,50],[30,20]]
// Output: 110
// Explanation: 
// The first person goes to city A for a cost of 10.
// The second person goes to city A for a cost of 30.
// The third person goes to city B for a cost of 50.
// The fourth person goes to city B for a cost of 20.

import java.util.PriorityQueue;

// Time Complexity: O(NlogN)    N = length of input array
// Space Complexity: O(N)       N = length of input array   Can be optimized to O(1) by modifying input
public class TwoCityScheduling {
    // calculate net cost. order abs of them in large to small
    public static int twoCitySchedCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) 
            return 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(3, (Pair i1, Pair i2) -> Math.abs(i1.netCost) < Math.abs(i2.netCost) ? 1 : -1);
        for (int i = 0; i < costs.length; i++) {
            pq.add(new Pair(costs[i][0] - costs[i][1], i));
        }
        int countA = 0, countB = 0, total = 0, maxCount = costs.length / 2;
        while (pq.size() > 0) {
            Pair curPair = pq.poll();
            if (curPair.netCost > 0) {
                // go to A will cost more than B
                if (countB < maxCount) {
                    // change to B instead of A
                    countB++;
                    total += costs[curPair.idx][1];
                } else {
                    // still go to A
                    countA++;
                    total += costs[curPair.idx][0];
                }
            } else {
                // go to A will cost less than B
                if (countA < maxCount) {
                    // go to A as plan
                    countA++;
                    total += costs[curPair.idx][0];
                } else {
                    // change to B
                    countB++;
                    total += costs[curPair.idx][1];
                }
            }
        }
        return total;
    }

    public static class Pair {
        int netCost, idx;
        public Pair(int netCost, int idx) {
            this.netCost = netCost;
            this.idx = idx;
        }
    }
}

