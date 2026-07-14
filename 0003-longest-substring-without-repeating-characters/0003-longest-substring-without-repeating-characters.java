class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int maxCount = 0;

        for(int i = 0; i < n; i++){
            HashSet<Character> set = new HashSet<>();
            int count = 0;
            for(int j = i; j < n; j++){
                
                //if any string have duplicate
                if(set.contains(s.charAt(j))){
                    count = j - i;
                    maxCount = Math.max(count, maxCount);
                    break;
                }
                // if any string don't have duplicate
                else{
                    set.add(s.charAt(j));
                    count = j - i + 1;
                    maxCount = Math.max(count, maxCount);
                }

            }
        }
        return maxCount; 
    }
}