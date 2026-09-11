class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;        // rows
        int n = grid[0].length;     // columns

        List<List<Integer>> result = new ArrayList<>();

        // Total number of elements
        int total = m * n;

        // Shifting total times gives the original grid
        k = k % total;

        for (int i = 0; i < m; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                // Position in the 1D representation
                int index = i * n + j;

                // Find original position after shifting
                int oldIndex = (index - k + total) % total;

                int oldRow = oldIndex / n;
                int oldCol = oldIndex % n;

                row.add(grid[oldRow][oldCol]);
            }

            result.add(row);
        }

        return result;
    }
}