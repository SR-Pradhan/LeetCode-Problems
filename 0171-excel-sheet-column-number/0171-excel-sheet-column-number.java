class Solution {
    public int titleToNumber(String columnTitle) {

        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            // Convert character to number:
            // A = 1, B = 2, ..., Z = 26
            int value = columnTitle.charAt(i) - 'A' + 1;

            // Shift previous result by 26
            result = result * 26 + value;
        }

        return result;
    }
}