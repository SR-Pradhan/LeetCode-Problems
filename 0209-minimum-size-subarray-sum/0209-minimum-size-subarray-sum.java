class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while(right < n){
            sum += nums[right];
            right++;
            while(sum >= target){
                minLen = Math.min(minLen, (right - left));
                sum -= nums[left];
                left++;
            } 
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}