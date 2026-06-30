class Solution {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int j = 0;
        int count = 0;
        
        //1st move non-zeros elements to left side
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
                count++;
            }
        }

        // then fill rest position with zeros.
        for(int i = count; i < n; i++){
            nums[i] = 0;
        }
    }
}
//Approach: Optimal App.
//Pattern: Two Pointer
//T.C: O(n)
//S.C: O(1)