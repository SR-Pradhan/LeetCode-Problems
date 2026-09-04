import java.util.*;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {

            int climb = heights[i + 1] - heights[i];

            // No resources needed for going down or staying level
            if (climb <= 0) {
                continue;
            }

            // Use a ladder for this climb
            minHeap.offer(climb);

            // If we have used more than 'ladders' ladders,
            // replace the smallest ladder usage with bricks
            if (minHeap.size() > ladders) {
                bricks -= minHeap.poll();
            }

            // Not enough bricks
            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }
}