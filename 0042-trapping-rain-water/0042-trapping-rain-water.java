class Solution {
    public int trap(int[] height) {

        int n = height.length;

        // Two pointers starting from both ends
        int left = 0;
        int right = n - 1;

        // Maximum height seen from the left and right
        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left <= right) {

            // The smaller boundary determines the water level
            if (leftMax <= rightMax) {

                // Update maximum height on the left
                leftMax = Math.max(leftMax, height[left]);

                // Water trapped at current left position
                totalWater += leftMax - height[left];

                // Move left pointer
                left++;

            } else {

                // Update maximum height on the right
                rightMax = Math.max(rightMax, height[right]);

                // Water trapped at current right position
                totalWater += rightMax - height[right];

                // Move right pointer
                right--;
            }
        }

        return totalWater;
    }
}