class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Find the maximum value in each column
        for (int j = 0; j < n; j++) {

            int max = 0;

            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }

            // Replace -1 with the column maximum
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max;
                }
            }
        }

        return matrix;
    }
}