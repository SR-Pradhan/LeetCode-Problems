class Solution {

    public static void solve(int i, int[] nums, List<Integer> current, List<List<Integer>> ans) {

        if (i == nums.length) {
            ans.add(new ArrayList<>(current)); // Store a copy of current subset
            return;
        }

        // Include nums[i]
        current.add(nums[i]);
        solve(i + 1, nums, current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude nums[i]
        solve(i + 1, nums, current, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, nums, current, ans);

        return ans;
    }
}
//Pattern: Recursion
//T.C: O(n × 2^n)
//S.C: O(n), max Stack Space