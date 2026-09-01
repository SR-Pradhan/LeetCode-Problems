class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int max = 0;

        // Store all elements in a HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Find the first missing positive number
        for (int i = 1; i <= max; i++) {

            if (!set.contains(i)) {
                return i;
            }
        }

        // If all numbers from 1 to max are present
        return max + 1;
    }
}