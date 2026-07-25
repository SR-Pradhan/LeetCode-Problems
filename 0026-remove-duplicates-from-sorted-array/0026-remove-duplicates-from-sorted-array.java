class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = i + 1;

        while(j < nums.length){
            if(nums[i] != nums[j]){
                int temp = nums[j];
                nums[j] = nums[i+1];
                nums[i+1] = temp;
                i++;
            }
            j++;
        }
        return i+1;  
    }
}