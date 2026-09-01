class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int totalWater = 0;

        // Store maximum height from the left up to each index
        int[] leftMax = new int[n];

        // Store maximum height from the right up to each index
        int[] rightMax = new int[n];

        // Initialize boundary values
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        // Build leftMax array
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Build rightMax array
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water at each index
        for (int i = 0; i < n; i++) {

            int water = Math.min(leftMax[i], rightMax[i]) - height[i];

            totalWater += water;
        }

        return totalWater;
    }
}