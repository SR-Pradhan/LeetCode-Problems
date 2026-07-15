class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        // To maintain s1 frequency
        int[] arr1 = new int[26];

        // To maintain current window frequency in s2
        int[] arr2 = new int[26];

        // Build frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
        }

        int j = 0;

        for (int k = 0; k < s2.length(); k++) {

            // Add current character to the window
            arr2[s2.charAt(k) - 'a']++;

            // Shrink window if it exceeds s1's length
            if (k - j + 1 > s1.length()) {
                arr2[s2.charAt(j) - 'a']--;
                j++;
            }

            // Compare frequency arrays when window size matches s1
            if (k - j + 1 == s1.length()) {
                if (Arrays.equals(arr1, arr2)) {
                    return true;
                }
            }
        }

        return false;
    }
}