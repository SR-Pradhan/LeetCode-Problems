class Solution {

    public int longestConsecutive(int[] nums) {

        // Handle empty array
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1;
        int count = 1;
        int lastSmaller = Integer.MIN_VALUE;

        // Traverse the sorted array
        for (int i = 0; i < nums.length; i++) {

            // Current element is consecutive
            if (nums[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = nums[i];
            }

            // Ignore duplicate elements
            else if (nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }

            // Update the maximum sequence length
            longest = Math.max(longest, count);
        }

        return longest;
    }
}