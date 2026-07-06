class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;

        int unk = 0;
        int z = 0;

        int t = n - 1;

        while(unk <= t){
            if(nums[unk] == 0){
                int temp = nums[unk];
                nums[unk] = nums[z];
                nums[z] = temp;
                unk++;
                z++;
            }
            else if(nums[unk] == 1) unk++;
            else if(nums[unk] == 2){
                int temp = nums[unk];
                nums[unk] = nums[t];
                nums[t] = temp;
                t--;
            }

        }
        
    }
}