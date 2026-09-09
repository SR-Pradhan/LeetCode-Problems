class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        double ans = 0;
        int count = 0;

        int[] arr = new int[m + n];

        // Copy nums1 into arr
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
            count++;
        }

        // Copy nums2 into arr
        for (int j = 0; j < n; j++) {
            arr[count++] = nums2[j];
        }

        // Sort the combined array
        Arrays.sort(arr);

        int total = m + n;

        // Even number of elements
        if (total % 2 == 0) {
            int mid = total / 2;
            ans = (arr[mid] + arr[mid - 1]) / 2.0;
        } 
        // Odd number of elements
        else {
            int mid = total / 2;
            ans = arr[mid];
        }

        return ans;
    }
}