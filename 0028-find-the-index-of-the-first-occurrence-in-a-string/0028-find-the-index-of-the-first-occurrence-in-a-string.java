class Solution {
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length();
        int n = needle.length();

        // Try every possible starting position
        for (int i = 0; i <= m - n; i++) {

            int j = 0;

            // Check if needle matches starting from index i
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // All characters of needle matched
            if (j == n) {
                return i;
            }
        }

        return -1;
    }
}