import java.util.*;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Total must be divisible by k
        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        // Sort in descending order for better pruning
        Arrays.sort(nums);

        // Largest number cannot be greater than target
        if (nums[nums.length - 1] > target) {
            return false;
        }

        int[] buckets = new int[k];

        return backtrack(nums, nums.length - 1, buckets, target);
    }

    private boolean backtrack(
        int[] nums,
        int index,
        int[] buckets,
        int target
    ) {

        // All numbers have been placed
        if (index < 0) {
            return true;
        }

        int num = nums[index];

        for (int i = 0; i < buckets.length; i++) {

            // Don't exceed target
            if (buckets[i] + num > target) {
                continue;
            }

            // Put number into bucket
            buckets[i] += num;

            // Recursively place remaining numbers
            if (backtrack(nums, index - 1, buckets, target)) {
                return true;
            }

            // Backtrack
            buckets[i] -= num;

            // If this bucket was empty before adding num,
            // other empty buckets are equivalent
            if (buckets[i] == 0) {
                break;
            }
        }

        return false;
    }
}