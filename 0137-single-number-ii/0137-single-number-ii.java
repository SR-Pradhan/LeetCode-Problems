class Solution {
    public int singleNumber(int[] nums) {

        int ones = 0;
        int twos = 0;

        for (int num : nums) {

            // Bits appearing once
            ones = (ones ^ num) & ~twos;

            // Bits appearing twice
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}