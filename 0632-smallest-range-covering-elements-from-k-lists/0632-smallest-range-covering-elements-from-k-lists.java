import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        // Min Heap stores:
        // [value, listIndex, elementIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int currentMax = Integer.MIN_VALUE;

        // Add the first element from every list
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);

            pq.offer(new int[]{value, i, 0});

            currentMax = Math.max(currentMax, value);
        }

        int bestLeft = pq.peek()[0];
        int bestRight = currentMax;

        while (true) {

            // Get the smallest current value
            int[] current = pq.poll();

            int minValue = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];

            // Current range is [minValue, currentMax]
            if (currentMax - minValue < bestRight - bestLeft) {
                bestLeft = minValue;
                bestRight = currentMax;
            }

            // Move to the next element in the same list
            if (elementIndex + 1 == nums.get(listIndex).size()) {
                // This list is exhausted, so no future range
                // can contain an element from every list.
                break;
            }

            int nextValue =
                nums.get(listIndex).get(elementIndex + 1);

            pq.offer(new int[]{
                nextValue,
                listIndex,
                elementIndex + 1
            });

            // Update maximum value in the heap
            currentMax = Math.max(currentMax, nextValue);
        }

        return new int[]{bestLeft, bestRight};
    }
}