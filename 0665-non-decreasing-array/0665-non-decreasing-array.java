class Solution {
    public boolean checkPossibility(int[] nums) {
        int changes = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                changes++;

                if (changes > 1) {
                    return false;
                }

                // Modify nums[i-1] or nums[i]
                if (i >= 2 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }

        return true;
    }
}