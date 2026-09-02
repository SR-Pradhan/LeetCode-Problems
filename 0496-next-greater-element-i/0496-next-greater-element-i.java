class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int max = -1;

            // Find nums1[i] inside nums2
            for (int j = 0; j < m; j++) {

                if (nums2[j] == nums1[i]) {

                    // Search for the first greater element to the right
                    for (int k = j + 1; k < m; k++) {

                        if (nums2[k] > nums1[i]) {
                            max = nums2[k];
                            break;
                        }
                    }

                    // nums1[i] found, no need to search further
                    break;
                }
            }

            ans[i] = max;
        }

        return ans;
    }
}