
class Solution {

    // Reverse the elements between left and right using two pointers
    public void swap(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        int successor = 0;

        // Step 1: Find the pivot
        // Scan from right to left to find the first increasing pair
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        // Step 2: If no pivot exists, the array is in descending order
        // This is the last permutation, so reverse the entire array
        if (pivot == -1) {
            swap(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the smallest element greater than the pivot
        // Scan from right because the suffix is in descending order
        for (int j = n - 1; j > pivot; j--) {
            if (nums[j] > nums[pivot]) {
                successor = j;
                break;
            }
        }

        // Step 4: Swap the pivot with its successor
        int temp = nums[pivot];
        nums[pivot] = nums[successor];
        nums[successor] = temp;

        // Step 5: Reverse the suffix to get ascending order
        swap(nums, pivot + 1, n - 1);
    }
}
