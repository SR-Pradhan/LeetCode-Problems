import java.util.*;

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all land cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // If all cells are land or all cells are water
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int distance = -1;

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int[] dir : directions) {
                    int nr = cell[0] + dir[0];
                    int nc = cell[1] + dir[1];

                    // Check boundaries
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Only visit water cells
                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return distance;
    }
}