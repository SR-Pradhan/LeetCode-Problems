class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // Mark the index corresponding to every number as negative.
        for (int i = 0; i < n; i++) {

            int value = Math.abs(nums[i]);
            int index = value - 1;

            // Keep the value negative even if the number appears multiple times.
            nums[index] = -Math.abs(nums[index]);
        }

        // Positive values indicate that the corresponding number is missing.
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}