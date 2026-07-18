class Solution {
    public int countDigits(int num) {

        int count = 0;

        // Preserve the original number for divisibility checks
        int originalNum = num; 

        // Process each digit from right to left
        while (num > 0) {

            int digit = num % 10; // Extract the last digit

            // Count the digit if it evenly divides the original number
            if (originalNum % digit == 0) count++;

            // Remove the last digit
            num /= 10;
        }

        return count;
    }
}