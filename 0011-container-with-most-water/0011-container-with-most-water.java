class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        
        int left = 0;
        int right = n-1;

        int maxArea = 0;

        while(left < right){
            int width = Math.min(height[left], height[right]);
            int currHeight = right - left;

            maxArea = Math.max(maxArea, currHeight * width);

            if(height[left] < height[right]) left++;
            else right--;
        }

        return maxArea; 
    }
}
//Pattern: Two Pointer
//T.C: O(n)
//S.C: O(1)