class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;

        // Find the maximum pile
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int low = 1;
        int high = maxPile;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long totalHour = 0;

            // Calculate total hours for ALL piles
            for (int pile : piles) {
                totalHour += (pile + mid - 1) / mid;
            }

            // mid is valid, try a smaller speed
            if (totalHour <= h) {
                high = mid - 1;
            }

            // mid is too slow, increase the speed
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}