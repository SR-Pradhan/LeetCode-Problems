class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int left = 0;
        int right = 0;

        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        while(right < n){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
                set.add(s.charAt(right));
                right++;
            
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen; 
    }
}