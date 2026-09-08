import java.util.Arrays;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];

        Arrays.sort(nums1);

        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> Integer.compare(nums2[a], nums2[b]));

        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int idx = index[i];

            if (nums1[right] > nums2[idx]) {
                ans[idx] = nums1[right];
                right--;
            } else {
                ans[idx] = nums1[left];
                left++;
            }
        }

        return ans;
    }
}