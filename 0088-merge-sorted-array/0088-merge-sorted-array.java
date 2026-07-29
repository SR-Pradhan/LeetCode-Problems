class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] merged = new int[m + n];

        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        int k = 0; // Pointer for merged array

        // Merge both arrays while both have elements
        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from nums1
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // Copy remaining elements from nums2
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // Copy merged array back to nums1
        for (int index = 0; index < m + n; index++) {
            nums1[index] = merged[index];
        }
    }
}