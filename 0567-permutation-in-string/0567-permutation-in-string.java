class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int n = s1.length();
        int left = 0;
        int right = 0;

        // Store character frequencies of s1
        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        // Sliding window over s2
        while (right < s2.length()) {

            // Add current character to the window
            freq2[s2.charAt(right) - 'a']++;
            right++;

            // Window is too large, remove the leftmost character
            if (right - left > n) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            // Check if current window is a permutation of s1
            if (right - left == n) {
                if (Arrays.equals(freq1, freq2)) {
                    return true;
                }
            }
        }

        return false;
    }
}