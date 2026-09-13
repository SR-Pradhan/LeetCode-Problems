class Solution {
    public int deleteGreatestValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        // Sort every row
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        // Take the largest value from each row
        // at every step
        for (int j = n - 1; j >= 0; j--) {

            int max = 0;

            for (int i = 0; i < m; i++) {
                max = Math.max(max, grid[i][j]);
            }

            ans += max;
        }

        return ans;
    }
}