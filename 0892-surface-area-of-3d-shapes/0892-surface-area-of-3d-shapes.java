class Solution {

    public int surfaceArea(int[][] grid) {

        int area = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int height = grid[i][j];

                // If there are no cubes, nothing to count
                if (height == 0) {
                    continue;
                }

                // Top + Bottom
                area += 2;

                // Front
                if (i == 0) {
                    area += height;
                } else {
                    area += Math.max(0, height - grid[i - 1][j]);
                }

                // Back
                if (i == n - 1) {
                    area += height;
                } else {
                    area += Math.max(0, height - grid[i + 1][j]);
                }

                // Left
                if (j == 0) {
                    area += height;
                } else {
                    area += Math.max(0, height - grid[i][j - 1]);
                }

                // Right
                if (j == n - 1) {
                    area += height;
                } else {
                    area += Math.max(0, height - grid[i][j + 1]);
                }
            }
        }

        return area;
    }
}