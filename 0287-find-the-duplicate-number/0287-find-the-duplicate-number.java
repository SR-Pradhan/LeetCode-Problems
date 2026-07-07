class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        for(int j = i + 1 ; j < nums.length; j++){
            int count = 0;
            if(nums[i] == nums[j]) count++;
            if(count >= 1) return nums[j];
            i++;
        }
        return -1;  
    }
}