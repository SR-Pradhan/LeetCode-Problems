class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int minElement = Integer.MAX_VALUE;

        for(int i : nums){
            minElement = Math.min(minElement, i);
        }
        return minElement;
    }
}