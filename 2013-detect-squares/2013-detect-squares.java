class DetectSquares {

    private int[][] count = new int[1001][1001];

    public DetectSquares() {
    }

    public void add(int[] point) {
        count[point[0]][point[1]]++;
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;

        // Try every possible x-coordinate
        for (int nx = 0; nx <= 1000; nx++) {

            if (nx == x || count[nx][y] == 0) {
                continue;
            }

            // Side length
            int side = Math.abs(nx - x);

            // Square above
            if (y + side <= 1000) {
                ans += count[nx][y]
                     * count[x][y + side]
                     * count[nx][y + side];
            }

            // Square below
            if (y - side >= 0) {
                ans += count[nx][y]
                     * count[x][y - side]
                     * count[nx][y - side];
            }
        }

        return ans;
    }
}