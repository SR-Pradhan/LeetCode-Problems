import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0;

        // Include i == n as a virtual height of 0
        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            // Current bar is smaller, so calculate areas of taller bars
            while (!stk.isEmpty() && currHeight < heights[stk.peek()]) {

                int index = stk.pop();
                int height = heights[index];

                int width;

                if (stk.isEmpty()) {
                    width = i;
                } else {
                    width = i - stk.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            // Don't push the virtual index n
            if (i < n) {
                stk.push(i);
            }
        }

        return maxArea;
    }
}