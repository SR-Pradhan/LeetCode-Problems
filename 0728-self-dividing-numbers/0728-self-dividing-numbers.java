class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {

        ArrayList<Integer> ans = new ArrayList<>();
        boolean isDivisible = true;

        for (int i = left; i <= right; i++) {

            int num = i;

            while (num != 0) {
                int digit = num % 10;

                // A number cannot be divided by zero.
                if (digit == 0) {
                    isDivisible = false;
                    break;
                }

                // Check whether the digit divides the number.
                if (i % digit == 0) {
                    num = num / 10;
                } else {
                    isDivisible = false;
                    break;
                }
            }

            // Add the number only if every digit divides it.
            if (isDivisible) {
                ans.add(i);
            }

            // Reset for the next number.
            isDivisible = true;
        }

        return ans;
    }
}