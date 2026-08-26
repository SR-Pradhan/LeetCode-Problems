class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        int maxPile = Integer.MIN_VALUE;

        for(int pile : piles){
            maxPile = Math.max(maxPile, pile);
        }

        int low = 1;
        int high = maxPile;

        while(low < high){
            int mid = low + (high - low) / 2;

            long totalHour = 0;

            for(int pile : piles){
                totalHour += (pile + mid - 1) / mid;
            }
            if(totalHour <= h) high = mid;
            else low = mid + 1;
        }

        return low; 
    }
}