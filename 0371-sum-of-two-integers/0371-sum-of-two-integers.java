class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // Carry
            int carry = a & b;

            // Sum without carry
            a = a ^ b;

            // Move carry one position left
            b = carry << 1;
        }

        return a;
    }
}