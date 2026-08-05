class Solution {

    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        // Perform Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Search in the left half
            else if (nums[mid] > target) {
                high = mid - 1;
            }

            // Search in the right half
            else {
                low = mid + 1;
            }
        }

        // Target not found, return the insertion position
        return low;
    }
}