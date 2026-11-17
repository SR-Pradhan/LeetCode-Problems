class Solution {
    public void swap(int[] nums, int left, int right){
        while(left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivort = -1;
        int swap = 0;

        for(int i = n - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                pivort = i - 1;
                break;
            }
        }

        if(pivort == -1){
            swap(nums, 0, n - 1);
            return;
        }
        
    
        for(int j = n - 1; j >= pivort; j--){
            if(nums[j] > nums[pivort]){
                swap = j;
                break;
            }
        }

        int temp = nums[pivort];
        nums[pivort] = nums[swap];
        nums[swap] = temp;

        swap(nums, pivort + 1, n - 1);
    }
}