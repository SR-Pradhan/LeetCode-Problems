class Solution {
    public String minWindow(String s, String t) {

        StringBuilder ans = new StringBuilder();

        int n = s.length();

        int low = 0;
        int high = 0;

        // Frequency of characters required from t
        int[] need = new int[128];

        // Frequency of characters in the current window
        int[] window = new int[128];

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        // Total number of characters that need to be matched
        int required = t.length();

        // Number of required character occurrences currently matched
        int formed = 0;

        // Length of the smallest valid window
        int minWindow = Integer.MAX_VALUE;

        // Starting index of the smallest valid window
        int start = 0;

        if (t.length() > s.length()) {
            return ans.toString();
        }

        // Sliding window
        while (low < n && high < n) {

            // Add the current character to the window
            char ch = s.charAt(high);
            window[ch]++;

            // Increase formed only if this character
            // is required and is not an extra occurrence
            if (need[ch] > 0 && window[ch] <= need[ch]) {
                formed++;
            }

            // Current window is valid
            while (formed == required) {

                // Calculate current window size
                int currentWindow = high - low + 1;

                // Store the smallest window
                if (currentWindow < minWindow) {
                    minWindow = currentWindow;
                    start = low;
                }

                // Remove the leftmost character
                char cha = s.charAt(low);
                window[cha]--;

                // If removing this character makes the window invalid
                if (need[cha] > 0 && window[cha] < need[cha]) {
                    formed--;
                }

                // Move left pointer
                low++;
            }

            // Expand the window
            high++;
        }

        // No valid window found
        if (minWindow == Integer.MAX_VALUE) {
            return "";
        }

        // Build the answer from the best window
        for (int i = start; i < start + minWindow; i++) {
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}