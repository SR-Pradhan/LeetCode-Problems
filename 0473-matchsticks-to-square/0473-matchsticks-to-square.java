import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {

        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int total = 0;

        for (int stick : matchsticks) {
            total += stick;
        }

        // Each side must have the same length
        if (total % 4 != 0) {
            return false;
        }

        int side = total / 4;

        // Sort in descending order
        // Helps us fail faster
        Arrays.sort(matchsticks);

        int n = matchsticks.length;
        int[] sides = new int[4];

        return backtrack(matchsticks, n - 1, sides, side);
    }

    private boolean backtrack(
        int[] matchsticks,
        int index,
        int[] sides,
        int target
    ) {

        // All matchsticks have been placed
        if (index < 0) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = matchsticks[index];

        // Try putting the current stick on each side
        for (int i = 0; i < 4; i++) {

            // Don't exceed the target side length
            if (sides[i] + stick > target) {
                continue;
            }

            // Put stick on this side
            sides[i] += stick;

            // Recursively place remaining sticks
            if (backtrack(matchsticks, index - 1, sides, target)) {
                return true;
            }

            // Backtrack
            sides[i] -= stick;

            // If this side was empty, trying other empty sides
            // would produce the same result
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}