class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m+n];
        int count = 0;

        for(int i = 0; i < m; i++){
            temp[i] = nums1[i];
            count++;
        }

        for(int i = 0; i < n ; i++){
            temp[count++] = nums2[i];
        }

        for(int i = 0 ; i < m + n; i++){
            nums1[i] = temp[i];
        }

        Arrays.sort(nums1);  
    }
}