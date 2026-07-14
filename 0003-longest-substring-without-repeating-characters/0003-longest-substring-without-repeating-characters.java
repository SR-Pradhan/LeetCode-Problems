class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int n = s.length();
        int maxCount = 0;

        int i = 0;

        for (int j = 0; j < n; j++) {

            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));

            maxCount = Math.max(maxCount, j - i + 1);
        }
        return maxCount;
    }
}