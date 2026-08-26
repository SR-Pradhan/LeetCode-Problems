class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int low = 0;
        int high = n - 1;

        int maxWater = Integer.MIN_VALUE;

        while(low < high){
            int area = (high - low) *  Math.min(height[low], height[high]);

            maxWater = Math.max(area, maxWater);

            if(height[low] < height[high]) low++;
            else high--;
        }
        return maxWater;
    }
}