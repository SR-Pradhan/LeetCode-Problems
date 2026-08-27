class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] result = new int[m * n];
        int index = 0;

        for (int diagonal = 0; diagonal < m + n - 1; diagonal++) {

            if (diagonal % 2 == 0) {
                // Move up-right
                int row = Math.min(diagonal, m - 1);
                int col = diagonal - row;

                while (row >= 0 && col < n) {
                    result[index++] = mat[row][col];
                    row--;
                    col++;
                }

            } else {
                // Move down-left
                int col = Math.min(diagonal, n - 1);
                int row = diagonal - col;

                while (row < m && col >= 0) {
                    result[index++] = mat[row][col];
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}