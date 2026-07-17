class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        List<Integer> list = new ArrayList<>();

        while (left <= right && top <= bottom) {

            // Traverse from Left → Right (Top Row)
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // Traverse from Top → Bottom (Right Column)
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // Traverse from Right → Left (Bottom Row)
            // Only if the bottom row still exists
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from Bottom → Top (Left Column)
            // Only if the left column still exists
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}