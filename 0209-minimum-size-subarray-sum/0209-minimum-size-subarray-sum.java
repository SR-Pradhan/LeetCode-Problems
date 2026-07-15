class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        int l = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];

            while(sum >= target){
                int currLen = r - l + 1;
                minLen = Math.min(currLen, minLen);
                
                sum -= nums[l];
                l++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        else return minLen;   
    }
}