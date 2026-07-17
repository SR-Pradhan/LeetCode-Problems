class Solution {
    public int findNumbers(int[] nums) {

        int n = nums.length;
        int maxCount = 0;

        for(int i = 0; i < n; i++){
            int count = 0;
            while(nums[i] > 0){
                nums[i] /= 10;
                count++;
            }
            if(count % 2 == 0) maxCount++;
        }

        return maxCount;
    }
}