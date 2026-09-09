
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceSum = 0;
        int bobSum = 0;

        // Calculate total candies
        for (int a : aliceSizes) {
            aliceSum += a;
        }

        for (int b : bobSizes) {
            bobSum += b;
        }

        // Difference that needs to be corrected
        int diff = (aliceSum - bobSum) / 2;

        // Store Bob's candy box sizes
        Set<Integer> bobSet = new HashSet<>();

        for (int b : bobSizes) {
            bobSet.add(b);
        }

        // Find the required swap
        for (int a : aliceSizes) {
            int b = a - diff;

            if (bobSet.contains(b)) {
                return new int[]{a, b};
            }
        }

        return new int[0];
    }
}

