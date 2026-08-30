class Solution {

    private int count = 0;

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        backtrack(1, n, used);
        return count;
    }

    private void backtrack(int position, int n, boolean[] used) {

        // All positions are filled
        if (position > n) {
            count++;
            return;
        }

        // Try every number from 1 to n
        for (int num = 1; num <= n; num++) {

            // Number must not already be used
            if (used[num]) {
                continue;
            }

            // Beautiful arrangement condition
            if (num % position != 0 && position % num != 0) {
                continue;
            }

            // Choose
            used[num] = true;

            // Explore
            backtrack(position + 1, n, used);

            // Backtrack
            used[num] = false;
        }
    }
}