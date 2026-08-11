class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();

        // Store all numbers present in the array.
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // Check which numbers from 1 to n are missing.
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                answer.add(i);
            }
        }

        return answer;
    }
}