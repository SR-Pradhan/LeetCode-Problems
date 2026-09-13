class Solution {
    public int[] findDegrees(int[][] edges) {

        int n = edges.length;
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (edges[i][j] == 1) {
                    degree[i]++;
                }
            }
        }

        return degree;
    }
}