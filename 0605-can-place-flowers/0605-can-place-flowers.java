
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int m = flowerbed.length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0) {

                // Check whether the left and right positions are empty
                boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == m - 1 || flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    count++;

                    if (count >= n) {
                        return true;
                    }
                }
            }
        }

        return count >= n;
    }
}
