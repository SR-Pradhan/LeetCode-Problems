class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        
        // dp[i][d] = length of longest arithmetic subsequence
        // ending at index i with common difference d
        //
        // Difference can range from -500 to 500 for this problem.
        int[][] dp = new int[n][1001];
        
        int ans = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int idx = diff + 500;

                if (dp[j][idx] == 0) {
                    dp[i][idx] = 2;
                } else {
                    dp[i][idx] = dp[j][idx] + 1;
                }

                ans = Math.max(ans, dp[i][idx]);
            }
        }

        return ans;
    }
}