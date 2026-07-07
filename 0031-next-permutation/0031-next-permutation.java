class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int index = -1;

        // Find the break point
        for (int right = n - 1; right > 0; right--) {
            if (nums[right] > nums[right - 1]) {
                index = right - 1;
                break;
            }
        }

        // Find the just greater element and swap it
        if (index != -1) {
            int jGreater = index + 1;

            for (int i = index + 1; i < n; i++) {
                if (nums[i] > nums[index] && nums[i] <= nums[jGreater]) {
                    jGreater = i;
                }
            }

            int temp = nums[index];
            nums[index] = nums[jGreater];
            nums[jGreater] = temp;
        }

        // Reverse the remaining array
        int i = index + 1;
        int j = n - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}