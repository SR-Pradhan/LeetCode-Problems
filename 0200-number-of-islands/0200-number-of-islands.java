class Solution {

    public void dfs(char[][] grid, int row, int col) {

        // Stop if outside grid or water
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }

        // Mark as visited
        grid[row][col] = '0';

        // Explore 4 directions
        dfs(grid, row - 1, col); // up
        dfs(grid, row + 1, col); // down
        dfs(grid, row, col - 1); // left
        dfs(grid, row, col + 1); // right
    }

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }

        return count;
    }
}