class Solution {

    public boolean isAnagram(String s, String t) {

        // Anagrams must have the same length
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        // Count the frequency of each character in s
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Decrease the frequency for each character in t
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }

        // If any frequency is not zero, the strings are not anagrams
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}