class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        // If there is only one element, it is the peak.
        if (n == 1) {
            return 0;
        }

        // Check if the first element is a peak.
        if (nums[0] > nums[1]) {
            return 0;
        }

        // Check if the last element is a peak.
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        // Check all middle elements.
        for (int index = 1; index < n - 1; index++) {
            if (nums[index] > nums[index - 1] &&
                nums[index] > nums[index + 1]) {
                return index;
            }
        }

        // This line is never reached because a peak always exists.
        return -1;
    }
}