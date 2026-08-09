class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Treat the matrix as a logically flattened sorted array.
        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert the 1D index into row and column.
            int row = mid / n;
            int column = mid % n;

            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}