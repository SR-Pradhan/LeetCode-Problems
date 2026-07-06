class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int maj = nums[0];

        int cm = 0;
        int cn = 0;

        for(int i = 0; i < n; i++){
             if(cm == 0){
                maj = nums[i];
            }
            if(nums[i] == maj) cm++;
            else if(nums[i] != maj){
                cn++;
            }
            if(cn > 0){
                cm--;
                cn--;
            }
        }
        return maj;
    }
}