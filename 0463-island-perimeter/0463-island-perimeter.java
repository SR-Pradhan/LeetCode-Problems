class Solution {
    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    // Top
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }

                    // Bottom
                    if (i == m - 1 || grid[i + 1][j] == 0) {
                        perimeter++;
                    }

                    // Left
                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }

                    // Right
                    if (j == n - 1 || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }
}