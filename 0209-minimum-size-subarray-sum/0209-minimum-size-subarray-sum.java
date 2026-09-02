class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = 0;

        int minSize = Integer.MAX_VALUE;
        int sum = 0;

        while (right < n) {

            // Expand the window by adding nums[right]
            sum += nums[right];
            right++;

            // Shrink the window while the sum is valid
            while (sum >= target) {

                // Update the minimum window length
                minSize = Math.min(minSize, right - left);

                // Remove the leftmost element
                sum -= nums[left];
                left++;
            }
        }

        // No valid subarray found
        if (minSize == Integer.MAX_VALUE) {
            return 0;
        }

        return minSize;
    }
}